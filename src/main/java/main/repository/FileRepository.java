package main.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.model.UploadedFile;
import main.model.Users;

@Repository
public interface FileRepository extends CrudRepository<UploadedFile, Integer> {
	List<UploadedFile> findByUsername(String username);

	@Transactional
	void deleteFileByFilename(String filename);
}
