    
window._config = {

	videoStreamingRegExPattern:/\.m3u8|\.dass/g,	
	videoExtRegExPattern:/\.mps|\.mp4|\.mov|\.m3u8/g,
	videoExtRegExTypePattern:/mps|mp4|mov|m3u8/g,
	lineFeedPatternAroundString:/^\s+|\s+$/g,
	lineFeedPattern:/(\s|\r\n|\n|\r)/gm,
	

	init(model){
		
		if(model){
			_config.cognito.region = model.get("cognitoRegion");
	    	
			_config.cognito.userPool.userPoolId = model.get("cognitoUserPoolId");
		            
			_config.cognito.userPool.clientId = model.get("cognitoUuserPoolClientId");
		        
			_config.cognito.identityPool.identityPoolId = model.get("cognitoIdentityPoolId");
			_config.cognito.cloudfront.hlsdomain = model.get("cognitoCloudfrontHlsdomain");
			_config.cognito.cloudfront.classfieddomain = model.get("cognitoCloudfrontClassfieddomain");
			
				
			_config.cognito.s3.apiVersion = model.get("cognitoS3ApiVersion");
			_config.cognito.s3.bucket_course_destination = model.get("cognitoS3BucketCourseDestination");
			_config.cognito.s3.bucket_course_hls_source_origin = model.get("cognitoS3BucketCourseHlsSourceOrigin");
			_config.cognito.s3.bucket_course_destination_domain = model.get("cognitoS3DestinationDomain"); 
			_config.cognito.s3.bucket_course_hls_destination_origin = model.get("cognitoS3BucketCourseHlsDestinationOrigin");
			
			
			_config.cognito.dynamodb.contentTbl = model.get("cognitoDynamoDbContentTbl"); 
			_config.cognito.dynamodb.tagTbl = model.get("cognitoDynamoDbTagTbl"); 
			_config.cognito.dynamodb.mmlworkspace = model.get("cognitoDynamoDbMmlWorkspace"); 
			_config.cognito.dynamodb.orgaccounts = model.get("cognitoDynamoDbOrgAccounts"); 
			_config.cognito.dynamodb.useraccounts = model.get("cognitoDynamoDbUserAccounts"); 
			_config.cognito.dynamodb.usersubscription = model.get("cognitoDynamoDbUserSubscription"); 
			_config.cognito.dynamodb.userwallet = model.get("cognitoDynamoDbUserWallet"); 
			_config.cognito.dynamodb.userbilling = model.get("cognitoDynamoDbUserBilling"); 
			_config.cognito.dynamodb.usercredit = model.get("cognitoDynamoDbUserCredit"); 
			
			console.log("Updated config " + JSON.stringify(_config));
					
		}else{
			console.log("failed to fetch configuration for target env. Running with default configuration");
			
		}

	},
	
    cognito: {
    	region: 'us-east-1', // e.g. us-east-2
    	
        userPool:{
        	userPoolId: 'us-east-1_7pGvAR1Zk', // e.g. us-east-2_uXboG5pAb
            
    		clientId: '6gqc8dln4ihgcnq0ai3tvmpk29', //is this used anywhere?
        },
		identityPool: {
			identityPoolId: 'us-east-1:4adcf012-d73f-4c77-823f-b22913a4661d'
		},
		cloudfront:{
			hlsdomain:'d24y44sy387x3m.cloudfront.net',
			classfieddomain:'d3n9eih2fcno3x.cloudfront.net'
		},
		s3:{
			apiVersion:'2006-03-01',
			bucket_course_destination:'classifiedcourses',
			bucket_course_hls_source_origin: 'mmlvideostreamingsolution-source-n6swh5wfqrxg',
			bucket_course_destination_domain:'classifiedcourses.s3.amazonaws.com',
			bucket_course_hls_destination_origin: 'https://s3.amazonaws.com/mmlvideostreamingsolution-destination-r4v2gcf173up'
				
		},
		dynamodb:{
			contentTbl:'Content',
			tagTbl:'ContentByTag'
		}
    },
};