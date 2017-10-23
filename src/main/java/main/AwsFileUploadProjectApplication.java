package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



//@Configuration
//@EnableAutoConfiguration

//@PropertySource({"classpath:application.properties"})
@SpringBootApplication
//@ComponentScan({"main.repository","main.config", "main.controller","main.model","main.service"})
//@EnableJpaRepositories(basePackages= {"repository"})

//@EnableJpaRepositories(basePackages="repository", entityManagerFactoryRef="emf")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AwsFileUploadProjectApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(AwsFileUploadProjectApplication.class, args);
	}
}



