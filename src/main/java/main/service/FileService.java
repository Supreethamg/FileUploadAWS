package main.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.model.UploadedFile;
import main.model.Users;
import main.repository.FileRepository;
import main.repository.UserRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepo;

	public void addFile(String username, String filename, String description) {
		final UploadedFile file = new UploadedFile(description, username, new Date().toString(), filename);
		fileRepo.save(file);
	}
	
	public List<UploadedFile> getFiles(final String username) {
		return fileRepo.findByUsername(username);
	}
	
	@Transactional
	public void deleteFiles(final String filename) {
		fileRepo.deleteFileByFilename(filename);
	}

}
