package main.controller;

import main.model.UploadedFile;
import main.repository.FileRepository;
import main.repository.UserRepository;
import main.service.FileService;
import main.service.S3Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private S3Services s3service;
    
    @Autowired
	private FileService fileService;
    
    @Autowired
   	private main.config.S3BucketConfig S3bucketconfig;

    
    @RequestMapping(method=RequestMethod.POST ,value="/upload")
    public ResponseEntity<?> uploadFileMulti(
            @RequestParam("desc") String description,
            @RequestParam("files") MultipartFile[] uploadfiles, @RequestParam("username") String username) {

        // Get file name
        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));

        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {     	
           
            for (MultipartFile file : uploadfiles) {            
            	File convFile = new File(file.getOriginalFilename());
                convFile.createNewFile(); 
                FileOutputStream fos = new FileOutputStream(convFile); 
                fos.write(file.getBytes());
                fos.close(); 
                System.out.println("file name:"+convFile.getName());
                s3service.uploadFile(convFile.getName(),convFile);
                fileService.addFile(username, convFile.getName(), description);
                break;
            }
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - "   + uploadedFileName, HttpStatus.OK);

    }

    // 3.1.3 maps html form to a Model
    @PostMapping("/api/upload/multi/model")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadedFile model) throws IOException {

        logger.debug("Multiple file upload! With UploadModel");

        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);

    }
    
   
    @RequestMapping(method=RequestMethod.GET, value="/list")
    public String getBucketObjects(Model model, @RequestParam("username") String username) {
    	System.out.println("Listing objects");
    	
    	model.addAttribute("files", fileService.getFiles(username));
    	return "Home";
    }
   
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteFile(@RequestParam("filename") String filename) {
    	s3service.deleteFile(filename);
    	fileService.deleteFiles(filename);
    	return "Home";
    }
    
}