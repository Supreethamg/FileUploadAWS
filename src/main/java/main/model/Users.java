package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceConstructor;


@Entity
public class Users {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstname;
	private String lastname;
	private String username;
	private String passwd;



	public Users() {}

	@PersistenceConstructor
	public Users(String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Users(String firstname, String lastname, String username, String passwd) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.passwd = passwd;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	




	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPwd() {
		return passwd;
	}
	public void setPwd(String pwd) {
		this.passwd = pwd;
	}


}
