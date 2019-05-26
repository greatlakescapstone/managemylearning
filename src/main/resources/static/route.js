$.ajaxPrefilter(function(options, originalOptions, jqXHR){
	console.log("options.url =>", options.url)
	if(options.url.startsWith("template") 
			|| options.url.startsWith("http")){
		
	}else{
		options.url = "/api/v1" + options.url;
	}
	
	
});


var Router = Backbone.Router.extend({
  routes:{
    '':'home',
    'session':'createSession',
    'dashboard':'showDashboard',
    'admindashboard': 'showAdminDashboard',
    'workspacedashboard': 'showDashboard',
    'contentdashboard':'showContentDashboard',
    'uploadContentDashboard': 'uploadContentDashboard',
    'searchAndShowContentResults':'searchAndShowContentResults',
    'showUser': 'users'
  }

});
var router = new Router();
router.on('route:home', function(){
	loginForm.render();
});

router.on('route:createSession', function(){
	console.log("sign-in to admin account")
});



router.on('route:showDashboard', function(){
	dashboard.render();
});

router.on('route:showAdminDashboard', function(){
	adminDashoard.render();
});

var content = null;
router.on('route:showContentDashboard', function(){
	if(content == null){
		var content = new ContentDashboard ();
	}
	content.render();
});

var uploadContent = null;
router.on('route:uploadContentDashboard', function(){
	if(uploadContent == null){
		var uploadContent = new UploadContentDashboard ();
	}else{
		
	}
	uploadContent.render();
});

var contentResultTable = null;
router.on('route:searchAndShowContentResults', function(){
	if(contentResultTable == null){
		contentResultTable = new SearchContentResultTable();
	}else{
		
	}
	contentResultTable.render();
});

router.on('route:users', function(){
	userList.render();
});

