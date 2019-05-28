    
window._config = {

	videoStreamingRegExPattern:/\.m3u8|\.dass/g,	
	videoExtRegExPattern:/\.mps|\.mp4|\.mov|\.m3u8/g,
	videoExtRegExTypePattern:/mps|mp4|mov|m3u8/g,
	lineFeedPatternAroundString:/^\s+|\s+$/g,
	lineFeedPattern:/(\s|\r\n|\n|\r)/gm,
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