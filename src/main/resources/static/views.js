var LoginForm = Backbone.View.extend({
	el:'.page',
	render: function(){
		var that = this;
		var template  =_.template(tpl.get('login-form-template'))

		that.$el.html(template);	
	},
	events: {
		'submit .login-form': 'signin'
	},
	signin: function(ev){
		
				var loginDetails = $(ev.currentTarget).serializeObject();
				COGNITO.login(loginDetails,	{
					onSuccess:function(){
						
						DYNAMODB.init();
						//DYNAMODB.listTables();
						
						S3.init();
						
					/*	S3.listBucketItems(null, {
							onSuccess:function(albums){
								if(albums.length>0){
									S3.getBucketItem(null, albums[01]);
								}
							},onFailure:function(albums){
							
							}
						});*/
						
						router.navigate('dashboard', {
							trigger : true
						});
						
					}, onFailure:function(err){
						
						alert(err.message || JSON.stringify(err));
						
					}
				});	

			  
		
/*		var loginDetails = $(ev.currentTarget).serializeObject();
		
		var session = new Session();
		session.save(loginDetails,{
			
			success: function(data){
				console.log("Session %o", data.toJSON());
				router.navigate('dashboard', {trigger:true})
			},
			error: function(data){
				console.log("Failed Session %o", data.toJSON());
				router.navigate('', {trigger:true})
			}
		});
		*/
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
		'click #manageContents' : 'showContentDashoard'
			
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
			if(contentResultTable == null){
				
				contentResultTable = new SearchContentResultTable();
			}
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
				if(videoPane == null){
					
					videoPane = new VideoPane();
				}
				try{
					videoPane.render();
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
	/*	$("form#content-form").submit(function(e) {
		    e.preventDefault();    
		    var formData = new FormData(this);

		    $.ajax({
		        url: "/content",
		        type: 'POST',
		        data: formData,
		        success: function (data) {
		            console.log ("Form submission success");
		        },
		        error: function(){
		        	console.log ("Form submission failure");
		        },
		        cache: false,
		        contentType: false,
		        processData: false
		    });
		});*/
		
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
					loginDetails.preview, loginDetails.price, 
					loginDetails.tags, document.getElementById('file').files);

	  
	    return false;
	 }
});




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

