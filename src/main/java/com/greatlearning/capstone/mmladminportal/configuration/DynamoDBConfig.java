package com.greatlearning.capstone.mmladminportal.configuration;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.greatlearning.capstone.mmladminportal.repository")
public class DynamoDBConfig {

  
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
  
    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
  
    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentials credentials) {
        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient(credentials);
          
      
        return dynamoDB;
    }
  
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
}
