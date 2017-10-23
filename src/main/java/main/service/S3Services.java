package main.service;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import main.config.S3BucketConfig;

@Service
public class S3Services {
	
	private Logger logger = LoggerFactory.getLogger(S3Services.class);
	
	@Autowired
	private AmazonS3 s3client;

	private String bucketName;
	
	public void downloadFile(String keyName) throws IOException {
		bucketName = new S3BucketConfig().getBucketname();
		
		try {
			
            System.out.println("Downloading an object");
            S3Object s3object = s3client.getObject(new GetObjectRequest(
            		bucketName, keyName));
            System.out.println("Content-Type: "  + 
            		s3object.getObjectMetadata().getContentType());
            //Utility.displayText(s3object.getObjectContent());
            logger.info("===================== Import File - Done! =====================");
            
        } catch (AmazonServiceException ase) {
        	logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
        	logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        }
	}

	
	public void uploadFile(String keyName, File uploadFile) {
		bucketName = new S3BucketConfig().getBucketname();
		try {
	       s3client.putObject(new PutObjectRequest(bucketName, keyName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
	        logger.info("-- Upload File - Successfull!---");
	        
		} catch (AmazonServiceException ase) {
			logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        }
	}
	
	
	
	public void deleteFile(String keyName) {
		bucketName = new S3BucketConfig().getBucketname();
			try {
				
				s3client.deleteObject(bucketName, keyName);
		        logger.info("---- Delete File - Successfull! -----");
		        
			} catch (AmazonServiceException ase) {
				logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
				logger.info("Error Message:    " + ase.getMessage());
				logger.info("HTTP Status Code: " + ase.getStatusCode());
				logger.info("AWS Error Code:   " + ase.getErrorCode());
				logger.info("Error Type:       " + ase.getErrorType());
				logger.info("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            logger.info("Caught an AmazonClientException: ");
	            logger.info("Error Message: " + ace.getMessage());
	        }
		}
	
	}
