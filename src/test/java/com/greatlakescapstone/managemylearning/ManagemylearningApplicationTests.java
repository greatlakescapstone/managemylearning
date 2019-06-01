package com.greatlakescapstone.managemylearning;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.greatlearning.capstone.mmladminportal.ManagemylearningApplication;
import com.greatlearning.capstone.mmladminportal.model.Configurations;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagemylearningApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagemylearningApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port + "/api/v1";
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllConfiguration() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/config",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetConfigurationsById() {
		Configurations config = restTemplate.getForObject(getRootUrl() + "/config/production-adminportal", Configurations.class);
		System.out.println(config);
		Assert.assertNotNull(config);
	}

	@Test
	public void testCreateConfigurations() {
		Configurations config = new Configurations();
		config.setId("production-adminportal");


		config.setCognitoRegion("us-east-1");
		config.setCognitoUserPoolId("us-east-1_7pGvAR1Zk");
		config.setCognitoUserPoolClientId("6gqc8dln4ihgcnq0ai3tvmpk29");
		config.setCognitoIdentityPoolId("us-east-1:4adcf012-d73f-4c77-823f-b22913a4661d");
		config.setCognitoCloudfrontHlsdomain("d24y44sy387x3m.cloudfront.net");
		config.setCognitoCloudfrontClassfieddomain("d3n9eih2fcno3x.cloudfront.net");
		config.setCognitoS3ApiVersion("2006-03-01");
		config.setCognitoS3BucketCourseDestination("classifiedcourses");
		config.setCognitoS3BucketCourseHlsSourceOrigin("mmlvideostreamingsolution-source-n6swh5wfqrxg");
		config.setCognitoS3DestinationDomain("classifiedcourses.s3.amazonaws.com");
		config.setCognitoS3BucketCourseHlsDestinationOrigin("https://s3.amazonaws.com/mmlvideostreamingsolution-destination-r4v2gcf173up");
		config.setCognitoDynamoDbContentTbl("Content");
		config.setCognitoDynamoDbTagTbl("ContentByTag");
		config.setCognitoDynamoDbMmlWorkspace("mmlworkspace");
		config.setCognitoDynamoDbOrgAccounts("org_accounts");	
		config.setCognitoDynamoDbUserAccounts("user_accounts");
		config.setCognitoDynamoDbUserSubscription("usersubscription");
		config.setCognitoDynamoDbUserWallet("userwallet");
		config.setCognitoDynamoDbUserBilling("user_billing_records");
		config.setCognitoDynamoDbUserCredit("user_creditrecords");

		
		ResponseEntity<Configurations> postResponse = restTemplate.postForEntity(getRootUrl() + "/config", config, Configurations.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdatePost() {
		String id = "production";
		Configurations config = restTemplate.getForObject(getRootUrl() + "/config/" + id, Configurations.class);
		config.setCognitoDynamoDbMmlWorkspace("mmlworkspace");
		config.setCognitoDynamoDbOrgAccounts("org_accounts");	

		restTemplate.put(getRootUrl() + "/config/" + id, config);

		Configurations updatedUser = restTemplate.getForObject(getRootUrl() + "/config/" + id, Configurations.class);
		Assert.assertNotNull(updatedUser);
	}

/*	@Test
	public void testDeletePost() {
		String id = "production";
		Configurations config = restTemplate.getForObject(getRootUrl() + "/config/" + id, Configurations.class);
		Assert.assertNotNull(config);

		restTemplate.delete(getRootUrl() + "/config/" + id);

		try {
			config = restTemplate.getForObject(getRootUrl() + "/config/" + id, Configurations.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
*/
}

