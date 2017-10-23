package main.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
	List<Users> findByLastname(String lastname);
	List<Users> findByUsername(String username);
	
}
