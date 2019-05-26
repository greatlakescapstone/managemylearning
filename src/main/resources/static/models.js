
var Users = Backbone.Collection.extend({
	url: '/users'
});


var Session = Backbone.Model.extend({
	urlRoot: '/session'
});


var Admins = Backbone.Model.extend({
	urlRoot: '/admins'
});