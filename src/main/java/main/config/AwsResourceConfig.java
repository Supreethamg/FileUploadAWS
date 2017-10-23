package main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
@Configuration
@ImportResource("classpath:/aws-config.xml")

public class AwsResourceConfig {

}