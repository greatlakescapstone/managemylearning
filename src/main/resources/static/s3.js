var S3= S3 || {};

S3 = {

	init:function(){
		COGNITO.accessIdentityToken();
		// Create a service client with the provider


	},
	uploadFile: function (file, fileNameWithoutExtension, bucketName, callback) {
		
		    var s3Admin = new AWS.S3({
		    	  apiVersion: _config.cognito.s3.apiVersion,
		    	  params: {Bucket: bucketName}
		    });
	    
		  if (file) {
			  
			  var fileName = fileNameWithoutExtension;
			  if( file.name.match(_config.videoExtRegExPattern)){
				  fileName = fileName + file.name.substring(file.name.lastIndexOf("."));
			  }
			  
			  //var albumPhotosKey = encodeURIComponent(albumName) + '//';

			  //var photoKey =  fileName;
			  s3Admin.upload({
			    Key: fileName,
			    Body: file,
			    ACL: 'public-read'
			  }, function(err, data) {
			    if (err) {
			    	callback.onFailure(err);
			      
			    }else{
			    	callback.onSuccess(data);
			    }
			   
			  });
		    
		  }else{
			  alert('Please choose a file to upload first.');
			  callback.onFailure(err);
		  }
		  
	},
	listBucketItems: function(bucketName, callback){

	    var s3 = new AWS.S3({
	    	  apiVersion: _config.cognito.s3.apiVersion,
	    	  params: {Bucket: bucketName || _config.cognito.s3.bucket_courseArtifacts}
	    });
	    
	    
	    s3.listObjects({Delimiter: '/'}, function(err, data) {
	        if (err) {
	          alert('There was an error listing your albums: ' + err.message);
	          callback.onFailure(err);
	          
	        } else {
	        	var albums = data.CommonPrefixes.map(function(commonPrefix) {
	            var prefix = commonPrefix.Prefix;
	            var albumName = decodeURIComponent(prefix.replace('/', ''));
	            return albumName;
	          });
	          console.log("List of albums: \o" +albums);
	          callback.onSuccess(albums);
	          
	           
	        }
	    });		
	},
	getBucketItem1: function(album){
		 var s3 = new AWS.S3({
	    	  apiVersion: _config.cognito.s3.apiVersion,
	    	  params: {Bucket: "mmlvideostreamingsolution-destination-r4v2gcf173up"}
	    });
		album = "mmlvideostreamingsolution-destination-r4v2gcf173up";
        if(album != null){
      	  var albumPhotosKey = encodeURIComponent(album) ;
	          s3.listObjects({Prefix: "/Prateek_PMP/hls/"}, function(err, data) {
	            if (err) {
	              return alert('There was an error viewing your album: ' + err.message);
	            }
	            // 'this' references the AWS.Response instance that represents the response
	            var href = this.request.httpRequest.endpoint.href;
	            var bucketUrl = href + _config.cognito.s3.bucket_courseArtifacts + '/';

	            var photos = data.Contents.map(function(photo) {
	              var photoKey = photo.Key;
	              var photoUrl = bucketUrl + encodeURIComponent(photoKey);
	              
	              return photoUrl;
	            });
	            console.log("Photho URL : " + photos)
	            $.ajax({
			        url: photos,
			        type: 'get',
			        
			        success: function (data) {
			            console.log ("Photo data success %o", data);
			        },
			        error: function(){
			        	console.log ("failed to fetch photo data");
			        }
			    });
	           
	          });
	          
        }
	},	getBucketItem: function(bucketName, album){
		var s3 = new AWS.S3({
	    	  apiVersion: _config.cognito.s3.apiVersion,
	    	  params: {Bucket: bucketName || _config.cognito.s3.bucket_courseArtifacts}
	    });
	    
        if(album != null){
        	  var albumPhotosKey = encodeURIComponent(album) + '//';
  	          s3.listObjects({Prefix: albumPhotosKey}, function(err, data) {
  	            if (err) {
  	              return alert('There was an error viewing your album: ' + err.message);
  	            }
  	            // 'this' references the AWS.Response instance that represents the response
  	            var href = this.request.httpRequest.endpoint.href;
  	            var bucketUrl = href + _config.cognito.s3.bucket_courseArtifacts + '/';

  	            var photos = data.Contents.map(function(photo) {
  	              var photoKey = photo.Key;
  	              var photoUrl = bucketUrl + encodeURIComponent(photoKey);
  	              
  	              return photoUrl;
  	            });
  	            console.log("Photho URL : " + photos)
  	            $.ajax({
  			        url: photos,
  			        type: 'get',
  			        
  			        success: function (data) {
  			            console.log ("Photo data success %o", data);
  			        },
  			        error: function(){
  			        	console.log ("failed to fetch photo data");
  			        }
  			    });
  	           
  	          });
  	          
          }
  	}
			
}