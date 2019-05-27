var COGNITO = COGNITO || {}

COGNITO = {
	cognitoUser:null,
	registerAccount: function(username, password, name, email, callback){
		
		var poolData = { 
					UserPoolId : _config.cognito.userPool.userPoolId, 
					ClientId : _config.cognito.userPool.clientId		        	  	
		    };
		
		    var userPool = new AmazonCognitoIdentity.CognitoUserPool(poolData);

		    var attributeList = [];

		    var dataEmail = {
					Name : 'email', 
					Value : email, //get from form field
				};
				
			var dataPersonalName = {
				Name : 'name', 
				Value : username, //get from form field
			};
			
			var attributeEmail = new AmazonCognitoIdentity.CognitoUserAttribute(dataEmail);
			var attributePersonalName = new AmazonCognitoIdentity.CognitoUserAttribute(dataPersonalName);
			
			
			attributeList.push(attributeEmail);
			attributeList.push(attributePersonalName);


		    userPool.signUp(username, password, attributeList, null, function(err, result){
		        if (err) {
		        	callback.onFailure(err);
		            return;
		        }
		        callback.onSuccess(result);
		        
		    });
	},

	login : function(usercredential, callback) {
		var authenticationData = {
			Username : usercredential.admin,
			Password : usercredential.password,
		};

		var authenticationDetails = new AmazonCognitoIdentity.AuthenticationDetails(
				authenticationData);

		var poolData = {
			UserPoolId : _config.cognito.userPool.userPoolId, 
			ClientId : _config.cognito.userPool.clientId,
		};

		var userPool = new AmazonCognitoIdentity.CognitoUserPool(poolData);

		var userData = {
			Username : usercredential.admin,
			Pool : userPool,
		};

		var cognitoUser = new AmazonCognitoIdentity.CognitoUser(userData);

		cognitoUser.authenticateUser(authenticationDetails, {
			onSuccess : function(result) {

				_config.cognito.userPool.accesToken = result.getAccessToken()
						.getJwtToken();
				_config.cognito.userPool.accesTokenExpiration = result
						.getAccessToken().getExpiration();
				_config.cognito.userPool.idToken = result.getIdToken()
						.getJwtToken();
				_config.cognito.userPool.refreshToken = result
						.getRefreshToken().getToken();
				
				callback.onSuccess(result);

				
			},
			onFailure : function(err) {
				callback.onFailure(err);
				
			},
		});

	},
	accessIdentityToken: function(){
		
		// Set the region where your identity pool exists
		// (us-east-1, eu-west-1)
		AWS.config.region = _config.cognito.region;

		// Configure the credentials provider to use your
		// identity pool
		AWS.config.credentials = new AWS.CognitoIdentityCredentials({
		    IdentityPoolId: _config.cognito.identityPool.identityPoolId,
		    Logins: { }
		});
		


		// Make the call to obtain credentials
		AWS.config.credentials.get(function(){
			
		    // Credentials will be available when this function
			// is called.
			_config.cognito.identityPool.accessKeyId = AWS.config.credentials.accessKeyId;
			_config.cognito.identityPool.secretAccessKey = AWS.config.credentials.secretAccessKey;
			_config.cognito.identityPool.sessionToken = AWS.config.credentials.sessionToken;
			
			console.log(_config);
		});
	},
	logout: function(){
		if (cognitoUser != null) {
			cognitoUser.globalSignOut();
	    }
	}
}