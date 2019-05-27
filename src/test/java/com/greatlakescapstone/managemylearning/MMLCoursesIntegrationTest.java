/*package com.greatlakescapstone.managemylearning;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.greatlearning.capstone.mmladminportal.ManagemylearningApplication;
import com.greatlearning.capstone.mmladminportal.model.MMLCourses;
import com.greatlearning.capstone.mmladminportal.repository.MMLCoursesRepository;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManagemylearningApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { 
  "amazon.dynamodb.endpoint=http://localhost:8080/", 
  "amazon.aws.accesskey=AKIAXZHYGNZ7DRIXK2KU", 
  "amazon.aws.secretkey=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" })
public class MMLCoursesIntegrationTest {
  

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
  
    @Autowired
    MMLCoursesRepository repository;
    
  

  
    @Before
    public void setup() throws Exception {
       
          
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Book.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
          
        // your code here...
  
        dynamoDBMapper.batchDelete((List<MMLCourses>)repository.findAll());
    }
  
    @Test
    public void dynamoDBTestCase() {
//    	MMLCourses codeflex = new MMLCourses(ID, NAME, PRICE);
//    	MMLCoursesRepository.save(codeflex);
  
        List<MMLCourses> theBook = (List<MMLCourses>) repository.findByContentTitle("kanchan_Test1");
          
        Assert.assertTrue("Book found.", theBook.size() > 0);
        //assertTrue("The book name is correct.", theBook.get(0).getName().equals(NAME));
    }
}*/