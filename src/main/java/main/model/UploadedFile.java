package main.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.web.multipart.MultipartFile;


@Entity
public class UploadedFile {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	
	private String username;

	private String uploadtime;

	private String filename;
	
	public UploadedFile(String description, String username, String uploadtime, String filename) {
		super();
		this.description = description;
		this.username = username;
		this.uploadtime = uploadtime;
		this.filename = filename;
	}

	public UploadedFile() {}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public String getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
