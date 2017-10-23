package main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3BucketConfig {
	
	private String awsId=new ProfileCredentialsProvider().getCredentials().getAWSAccessKeyId();

	
	private String awsKey=new ProfileCredentialsProvider().getCredentials().getAWSSecretKey();
	
	@Value("us-west-2")
	private String region;
	
	public String getAwsId() {
		return awsId;
	}

	public void setAwsId(String awsId) {
		this.awsId = awsId;
	}

	public String getAwsKey() {
		return awsKey;
	}

	public void setAwsKey(String awsKey) {
		this.awsKey = awsKey;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getBucketname() {
		return bucketname;
	}

	public void setBucketname(String bucketname) {
		this.bucketname = bucketname;
	}

	private String bucketname = "supreetha-s3";

	@Bean
	public AmazonS3 s3client() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
								.withRegion(Regions.fromName(region))
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .build();
		
		return s3Client;
	}
}
