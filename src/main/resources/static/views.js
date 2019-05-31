var LoginForm = Backbone.View.extend({
	el:'.page',
	render: function(){
		var that = this;
		var template  =_.template(tpl.get('login-form-template'))
		
		var config = new Config();
		config.fetch({
			success: function (config){
				console.log(" config = %o", config.models)
				_config.init(config.models[0]);
				
				
				
				

				that.$el.html(template);	
				
				
			},
			error: function(){
				console.log("some problem accessing server");	
				

				that.$el.html(template);	
			}
		});
	},
	events: {
		'submit .login-form': 'signin'
	},
	signin: function(ev){
		
				
				var loginDetails = $(ev.currentTarget).serializeObject();
				COGNITO.login(loginDetails,	{
					onSuccess:function(){
						_config.userId = loginDetails.userId;
						DYNAMODB.init();
						//DYNAMODB.listTables();
						
						S3.init();
						

						
						router.navigate('dashboard', {
							trigger : true
						});
						
					}, onFailure:function(err){
						
						alert(err.message || JSON.stringify(err));
						
					}
				});	


		return false;
	}
});

var loginForm = new LoginForm();



var Dashboard = Backbone.View.extend({
	el:'.page',
	render: function(){
		var that = this;
		var template  =_.template(tpl.get('dashboard-template'));
		
		
		

		that.$el.html(template);	
	},events: {
		'click #logout' : 'logout',
		'click #dashboard' : 'showDashboard',
		'click #manageAdmins' : 'showAdminDashboard',
		'click #manageWorkspace' : 'showWorkspaceDashboard',
		'click #manageContents' : 'showContentDashoard',
		'click #reportsByUsrExp' : 'showReports'
			
	},
	logout: function(ev){
		router.navigate('', {trigger:true})
		return false;
	},
	showDashboard: function(ev){
		router.navigate('dashboard', {trigger:true})
		return false;
	},
	showAdminDashboard: function(ev){
		router.navigate('admindashboard', {trigger:true})
		return false;
	},
	showWorkspaceDashboard: function(ev){
		router.navigate('workspacedashboard', {trigger:true})
		return false;
	},
	showContentDashoard: function(ev){
		router.navigate('contentdashboard', {trigger:true})
		return false;
	},
	showReports: function(ev){
		router.navigate('showReports', {trigger:true})
		return false;
	}
	 
});

var dashboard = new Dashboard();




var AdminDashboard = Backbone.View.extend({
	el:'.dashboardcontent',
	render: function(){
		var that = this;
		
		var admins = new Admins();
		admins.fetch({
			success: function (admins){
					var template  =_.template(tpl.get('admindashboard-template'));
					var data = {admins: admins.models}
					var element = document.getElementById("dashboardcontent");
					element.innerHTML = template(data);
			}
		});
		
	}
});
var adminDashoard = new AdminDashboard();

var ContentDashboard = Backbone.View.extend({
	el:'.dashboardcontent',
	render: function(){
		
		var that = this
		var template  =_.template(tpl.get('contentdashboard-template'));
		that.$el.html(template);	
		
	},
	events: {
		'submit .searchContentByTags' : 'searchContentByTags',
		'click .uploadNewContent': 'uploadNewContent'
	},
	
	searchContentByTags: function (ev) {
			ev.preventDefault();
			var data = $(ev.currentTarget).serializeObject();
			window.currentSearchCriteria = data.searchByTags;
			contentResultTable = new SearchContentResultTable();
			
			contentResultTable.render();
	  
	    return false;
	 },
	 searchContentByAuthorAndTitle: function (ev) {
			ev.preventDefault();
		

	  
	    return false;
	 },uploadNewContent: function (ev) {
			ev.preventDefault();
			router.navigate('uploadContentDashboard', {trigger:true});

	  
	    return false;
	 }
	
});

var SearchContentResultTable = Backbone.View.extend({
	el:'.contentSearchResult',
	render: function(){
		
		var that = this
		var searchOptionData = window.currentSearchCriteria
		DYNAMODB.queryData(searchOptionData, {
			onSuccess: function(data){
				var template  =_.template(tpl.get('searchcontentresult-template'));
				var templateData = {contents: data}
				that.$el.html(template(templateData));
				
				window.popover();
			},
			onFalure: function(){}  
		});
		
	},
	events: {
		
		'click #videoLink' : 'setVideoLink'
			
	}, setVideoLink: function(ev){
		 console.log("video data %o", ev);
		 var link= $(ev.currentTarget).attr( 'contentlink' );
		 if(link ){
			
			if(link.match(_config.videoExtRegExPattern)){
				window.currentVideoLink = link;
				var video;
				if(link.match(_config.videoStreamingRegExPattern)){
					
					if(videoStreamingPane != null){
						try{videoStreamingPane.dispose()}catch(e){console.log(e);}
					}
					videoStreamingPane = new VideoStreamingPane();
						
					
					video = videoStreamingPane;
				}else{
					if(videoPane != null){
						try{videoPane.dispose()}catch(e){console.log(e);}
					}
					videoPane = new VideoPane();
				
					video = videoPane;
				}
				try{
					video.render();
					document.getElementById("autoClickModalVideo").click();
					
				}catch(e){
					console.log(e);
				}
			}else{
				window.open(link,"resizeable,scrollbar"); 
			}
			
			
		}else{
			console.log("no content link available");
		}
		
		
		return false;
		 
	 },	
	editContent: function (ev) {
		ev.preventDefault();

	  
	    return false;
	 }
	
});
var videoPane = null;
var VideoPane = Backbone.View.extend({
	el:'.videocontainer',
	render: function(){
		var that = this;
		var template  =_.template(tpl.get('video-template'));
		var data = {videolink:window.currentVideoLink}
		that.$el.html(template(data));
		
	}
});

var videoStreamingPane = null;
var VideoStreamingPane = Backbone.View.extend({
	el:'.videocontainer',
	render: function(){
		var that = this;
		var template  =_.template(tpl.get('videostreaming-template'));
		var data = {}
		that.$el.html(template());
		
	}
});

var UploadContentDashboard = Backbone.View.extend({
	el:'.dashboardcontent',
	render: function(){
		
		var that = this
		var template  =_.template(tpl.get('newcontent-template'));
		//var data = {admins: admins.models}
		//var element = document.getElementById("dashboardcontent");
		//element.innerHTML = template();
		
		

		that.$el.html(template);	

		
	},
	events: {
		'submit .content-form' : 'upload'
			
	},
	
	upload: function (ev) {
			ev.preventDefault();
			var formData = new FormData($(ev.currentTarget));
			var loginDetails = $(ev.currentTarget).serializeObject();
			
			AppController.postContent(loginDetails.newcategory, 
					loginDetails.newauthor,loginDetails.title,
					loginDetails.preview, loginDetails.price, loginDetails.oneTimePrice, 
					loginDetails.tags, document.getElementById('file').files);

	  
	    return false;
	 }
});


var ReportPanel = Backbone.View.extend({
	el:'.dashboardcontent',
	render: function(){
		var that = this;
		
		$.ajax({
	        url: "https://2ig7h87k3i.execute-api.us-east-1.amazonaws.com/dev",
	        type: 'get',
	        
	        success: function (data) {
	        	var template  =_.template(tpl.get('reports'));
				var data = {data: data}
				that.$el.html(template(data));
	        },
	        error: function(){
	        	console.log ("failed to fetch photo data");
	        }
	    });
		
		
	}
});

reportPanel = new ReportPanel();


var UserList = Backbone.View.extend({
	el:'.page',
	render: function(){
		var that = this;
		
		var users = new Users();
		users.fetch({
			success: function (userList){
				
				
					var template  =_.template($('#user-list').html());
					var data = {users: userList.models}
					that.$el.html(template(data));
			}
		});
		
	}
});

var userList = new UserList();

