# FileUploadAWS

•    University Name: http://www.sjsu.edu/

•    Course: Cloud Technologies

•    Professor Sanjay Garje 

•    ISA: Divyankitha Urs

•    Student: Supreetha Ganapathi

• LinkedIn: https://www.linkedin.com/in/supreetha-m-g-3787ab35

Project Introduction 
AWSFile Upload is my fist experience towards accessing various AWS resources programatically. So as in this project I have 
tried exploring various activities around File Management.
To use this application, authorized users can login to web app, view the files from the AWS S3 bucket configured for this project, Upload new files and delete existing files all from the web application without having to login to AWS console.

Technology Stack
Spring Boot
HTML/JavaScript (HTML5, Bootstrap), Thymeleaf
JAVA
Tomcat
Apache Maven
Amazon EC2 for Hosting
Amazon R53 for Domain Management
Amazon RDS (MySQL database) for User/File inventory Management
Amazon S3

Pre-requisites Set Up

Configurations to run the code locally
• IDE (Eclipse for Windows/IntelliJ for Mac) for managing the code.
• JAVA 1.7 or above
• application.resources file needs to have the required AWS details (secret key, RDS access etc.)


Configurations on AWS
• AWS Account, can be setup from http://aws.amazon.com
• S3 Bucket with required permissions 
• IAM User with secret key (IAM user should have permissions on the S3 Bucket setup above)
• CloudFront having source as S3 bucket setup above

After setting up the resources as above, run the following commands to run the application:

mvn clean install
Mvn spring-boot run

The application will be accessible on the local host at port 80. Please use the URL http://localhost:8080/AwsFileUploadProject/

Sample Screenshots

Login Page

![login_page](https://user-images.githubusercontent.com/31361767/31921658-60cfa1bc-b825-11e7-82ab-16852fd58e75.png)

File Upload and List

![uploadedfile_listpage](https://user-images.githubusercontent.com/31361767/31921680-838a743e-b825-11e7-8c20-3230605631c1.png)

File Deleted

![filedeleted_page](https://user-images.githubusercontent.com/31361767/31921829-36eff6c0-b826-11e7-87fa-4660f3983f50.png)

