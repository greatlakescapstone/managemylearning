var Config = Backbone.Collection.extend({
	url: '/config'
});


var Reports = Backbone.Collection.extend({
	url: 'https://2ig7h87k3i.execute-api.us-east-1.amazonaws.com/dev'
});



var Users = Backbone.Collection.extend({
	url: '/users'
});


var Session = Backbone.Model.extend({
	urlRoot: '/session'
});


var Admins = Backbone.Model.extend({
	urlRoot: '/admins'
});