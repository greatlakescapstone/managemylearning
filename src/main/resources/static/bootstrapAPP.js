
function popover(){
	 $('[data-toggle="popover"]').popover();
}


$.fn.serializeObject = function(){
  var o = {};
  var a = this.serializeArray();
  $.each(a, function(){
    if(o[this.name] !== undefined){
      if(!o[this.name].push){
        o[this.name] = [o[this.name]];
      }
      o[this.name].push(this.value || '');
    }else{
      o[this.name] = this.value || '';

    }

  });
  return o;
}


tpl = {
		 
	    // Hash of preloaded templates for the app
	    templates: {},
	 
	    // Recursively pre-load all the templates for the app.
	    // This implementation should be changed in a production environment:
	    // All the template files should be concatenated in a single file.
	    loadTemplates: function(names, callback) {
	 
	        var that = this;
	 
	        var loadTemplate = function(index) {
	            var name = names[index];
	            console.log('Loading template: ' + name);
	            $.get('templates/' + name + '.html', function(data) {
	                that.templates[name] = data;
	                index++;
	                if (index < names.length) {
	                    loadTemplate(index);
	                } else {
	                    callback();
	                }
	            });
	        }
	 
	        loadTemplate(0);
	    },
	 
	    // Get template by name from hash of preloaded templates
	    get: function(name) {
	        return this.templates[name];
	    }
	 
};

tpl.loadTemplates(['login-form-template', 'dashboard-template', 
	'admindashboard-template', 'newcontent-template',
	'contentdashboard-template', 'searchcontentresult-template',
	'videostreaming-template','video-template',
	'reports'], function() {
    
    Backbone.history.start();
});


