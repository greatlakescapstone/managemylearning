var DYNAMODB = DYNAMODB || {}	
DYNAMODB = {
		dynamodb: null,
		docClient: null,
		init:function(){
			COGNITO.accessIdentityToken();
			// Create a service client with the provider
			dynamodb = new AWS.DynamoDB({region: _config.cognito.region});
			docClient = new AWS.DynamoDB.DocumentClient();
		},
		
		listTables:function(){
			var params = {};
		    dynamodb.listTables(params, function(err, data) {
			    if (err){
			        console.log("Unable to list tables:\n" + JSON.stringify(err, undefined, 2));
			    }
			    else{
			    	console.log("List of tables: \n" + JSON.stringify(data, undefined, 2));
			    }
		    });
		},
		createContent: function (itemDetails, callback) {
		    var params = {
		        TableName :_config.cognito.dynamodb.contentTbl,
		        Item:itemDetails
		    };
		    docClient.put(params, function(err, data) {
		    	
		        if (err) {
		        	callback.onFailure(err);
		            
		        } else {
		        	callback.onSuccess(data);
		            
		        }
		    });
		},
		registerContentWithSearchTags: function(searchtags, contenttitle, callback){
			var params ; 
			var i;
			for(i=0; i<searchtags.length; i++){
				var tag = searchtags[i].trim().toLowerCase();
				params = {
				        TableName :_config.cognito.dynamodb.tagTbl,
				        Item:{
				            "content_tag": tag,
				            "content_title": contenttitle
				        }
				    };
				    docClient.put(params, function(err, data) {
				    	
				        if (err) {
				        	callback.onFailure(err);
				            
				        } else {
				        	callback.onSuccess(data);
				            
				        }
				    });
			}
			 
		},
		queryData: function(tags, callback) {
			
			var tagSet = tags.split(",");
			var content_title = {};
			var i;
			var found = 0;
			for(i=0; i<tagSet.length; i++){
				 params = {
					        TableName : 'ContentByTag',
					        KeyConditionExpression: "#tag = :tagValue",
					        ExpressionAttributeNames:{
					            "#tag": "content_tag"
					        },
					        ExpressionAttributeValues: {
					            ":tagValue":tagSet[i]
					        }
					    };

					    docClient.query(params, function(err, data) {
							found++;
					        if (err) {
					            console.log(err);
					        } else {
							    for(var k=0; k<data.Items.length; k++)
								content_title[data.Items[k].content_title]={};
					            
								if(found == tagSet.length){
									found =  Object.keys(content_title).length;
									console.log("Total content_titles are ", found);
									console.log("content_title %o", content_title);
									Object.keys(content_title).forEach(function(key) {
					
										console.log("fetching record for " + key);
										params = {
											TableName : 'Content',
											KeyConditionExpression: "#tag = :tagValue",
											ExpressionAttributeNames:{
												"#tag": "content_title"
											},
											ExpressionAttributeValues: {
												":tagValue":key
											}
										};

										docClient.query(params, function(err, data) {
											found--;
											if (err) {
												console.log(err);
												callback.onFailure(err)
											} else {
												//for(var k=0; k<data.Items.length; k++)
												//content_title.push(data.Items[k].content_title);
												//console.log("data set %o", content_title);
												console.log("records =" + data);
												content_title[key]=data;
												
											}
											
											if(found <= 0){
												var recordItems = [];
												Object.keys(content_title).forEach(function(key) {
													recordItems.push(content_title[key].Items[0]);
												    
												});
												callback.onSuccess(recordItems);
												console.log("r %o", recordItems);	
											}
										});
									});
								
															
								}

					        }
					    });
			    		
				
			}
			
		    
			 
		    		

		}


}
							
							

						