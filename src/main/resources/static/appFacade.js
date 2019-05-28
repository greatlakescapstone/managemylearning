var AppController = AppController || {}	

AppController = {
		postContent: function(category, author, title, preview, priceperminute, onetimeprice, tags, files){
			
			category = category.trim().replace(_config.lineFeedPatternAroundString,'');
			title = title.trim().replace(_config.lineFeedPatternAroundString,'');
			preview = preview.trim().replace(_config.lineFeedPatternAroundString,'');
			
			var content_title = author+"_"+title;
			content_title = content_title.trim().replace(_config.lineFeedPattern,'');
			
			
			
			var file = files[0];
			var customFileName = content_title
			
			var extIndex = file.type.indexOf("/");
			if(extIndex >= 0 && !file.type.substring(extIndex+1).match(_config.videoExtRegExTypePattern)){
				customFileName = customFileName + file.type.substring(extIndex+1);
			}
			

			S3.uploadFile(file, customFileName, _config.cognito.s3.bucket_course_destination, {
				
				onSuccess: function(data){
					
					data.Location = data.Location.replace(_config.cognito.s3.bucket_course_destination_domain,_config.cognito.cloudfront.classfieddomain);
					var itemDetails = {
					        "content_title": content_title,
					        "price":priceperminute,
					        "onetimeprice":onetimeprice,
				            "category": category,
				            "author": author,
				            "title": title,
				            "preview":preview,
				            "links":data.Location,
					        "rating":{
					        	"5star":0,
					        	"4star":0,
					        	"3star":0,
					        	"2star":0,
					        	"1star":0,
					        },
					        "comments":"-"
					}
					
					DYNAMODB.createContent(itemDetails, 
							{
								onSuccess(data){
								console.log("PutItem succeeded: " + "\n" + JSON.stringify(data, undefined, 2));
								},onFailure(err){
									console.log("Unable to add item: " + "\n" + JSON.stringify(err, undefined, 2));
								}
					});
					
					var authorFirstName = author.substring(0,author.indexOf(' '));
					var searchTags = [category, author, authorFirstName, title].concat(tags.split(","));
					
					DYNAMODB.registerContentWithSearchTags(searchTags, content_title,	
					{ 
						onSuccess(data){
							console.log("SearchTag succeeded: " + "\n" + JSON.stringify(data, undefined, 2));
						},onFailure(err){
							console.log("Unable to add searchTag: " + "\n" + JSON.stringify(err, undefined, 2));
						}
					});
					
					
					if( file.name.match(_config.videoExtRegExPattern)){
						S3.uploadFile(file, customFileName, _config.cognito.s3.bucket_course_hls_source_origin, {
							onSuccess:function(data){
								itemDetails.linkshls="https://"+_config.cognito.cloudfront.hlsdomain + "/" + customFileName + "/hls/" + customFileName +".m3u8";
								DYNAMODB.createContent(itemDetails, 
										{
											onSuccess(data){
												console.log("Update data with video streaming link for  "+ customFileName + "\n" + JSON.stringify(data, undefined, 2));
											},onFailure(err){
												console.log("Failed to update video streaming link for streaming link for  "+ customFileName + "\n" + JSON.stringify(err, undefined, 2));
											}
								});
								
							},
							onFailure: function(err){
								alert("Video streaming conversion request upload failed for "+ customFileName + "\n" + JSON.stringify(err, undefined, 2));
								
								
							}
						});
					}
					
					
					
					
						
					
					
					
					
					
					
				},
				onFailure: function(err){
					alert('There was an error uploading your file: ', err.message);
				}
			});

			

			
		}
		
}
