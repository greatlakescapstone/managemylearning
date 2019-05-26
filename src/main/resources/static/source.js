var Identity = Backbone.Model.extend({
  defaults: function(){
    return {type:'basic', userId:'admin', password:'admin'}
  }
});

var identity = new Identity({type:'basic', userId:'admin', password:'admin'});

var ALLMMLSpace = Backbone.Model.extend({
  defaults: function(){
    return { 
	  MMLSpaces:[{
	    type:'individual', 
	    spaceName: 'GUEST'
	    id:'guest', 
	    emailid: ''
	    address: ''
	    phone: '',
	    altphone: ''
	  },{
	    type:'organisation', 
	    spaceName: 'GUEST'
	    id:'guest', 
	    emailid: ''
	    address: ''
	    phone: '',
	    altphone: ''
	  }]
	  
	}
  }
});

var MMLSpace = Backbone.Model.extend({
  defaults: function(){
    return { 
	  type:'individual', 
	  spaceName: 'GUEST'
	  id:'guest', 
	  password:'guest',
	  emailid: ''
	  address: ''
	  phone: '',
	  altphone: ''
	  billingAddr: ''
	}
  }
});


var MMLSpaceUsers = Backbone.Model.extend({
  defaults: function(){
    return { 
	  spaceName: 'GUEST'
	  users:[{
	    type:'root', 
	    id:'userid', 
	    password:'****',
	    emailid: ''
	    address: ''
	    phone: '',
	    altphone: ''
	  },{
	    type:'account', 
	    id:'userid', 
	    password:'****',
	    emailid: ''
	    address: ''
	    phone: '',
	    altphone: ''
	  }]
	}
  }
});

var MMLSpaceAccount = Backbone.Model.extend({
  defaults: function(){
    return { 
	  spaceName: 'GUEST'
	  users:[{
	    type:'account', 
	    id:'userid', 
	    password:'****',
	    emailid: '',
	    address: '',
	    phone: '',
	    altphone: ''
	  }]
	}
  }
});

var AccountSuscriptions = Backbone.Model.extend({
  defaults: function(){
    return { 
	  spaceName: 'GUEST'
	  users:[{
	    id:'userid', 
	    subscriptions:[{
		  id:'',
		  name:'',
		  state:'pending/activated/cancelled/suspended'
		  markProgress:'not_started,playing,paused,completed,downloaded'
		  
		}]
	  }]
	}
  }
});