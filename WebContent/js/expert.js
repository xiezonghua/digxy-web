if ("undefined" == typeof (expert)) {
	var jq = $;
	var expert = {
	    toUpdatePage: function(id){
	    	hyCom.request(expert.url.get , {"expertModel.id":id} , function(data){
	    		jq("#id").val(data.id);
	    		jq("#name").val(data.name);
	    		jq("#qq").val(data.qq);
	    		jq("#profile").val(data.profile);
	    		jq("#addDate").val(data.addDate);
	    		jq("#updateBtn").show();
	    		jq("#addBtn").hide();
	    	
	    		hyCom.openHtml(jq("#editDiv"));
	    	});
	    },
	    
	    toAddPage : function(){
	    	hyCom.openHtml(jq("#editDiv"));
	    	jq("#addBtn").show();
	    	jq("#updateBtn").hide();
	    },
	    update: function(){
	    	if(!hyCom.validate(["id","name" , "qq" ])) return;
			var dataParam =  hyCom.modelConverter("expertModel" , ["id", "name" , "qq" , "profile"]);
			
			hyCom.request(expert.url.update, dataParam, function(data){
				site.redirect("/expert/m");
			});
	    },
	    
	    del: function(id){
	    	hyCom.request(expert.url.del, {"expertModel.id":id}, function(data){
	    		hyCom.redirect("/expert/m");
			});
	    },
		
	    add: function(){
    		if(!hyCom.validate(["name" , "qq" ])) return;
			var dataParam =  hyCom.modelConverter("expertModel" , ["name" , "qq" , "profile"]);
			
			hyCom.request(expert.url.add, dataParam, function(data){
				hyCom.redirect("/expert/m");
			});
	    },
	   
		url :{
			manager : "/expert/m",
			update: "/expert/update" , 
			add: "/expert/add",
			del: "/expert/del",
			get: "/expert/get"
		}
	};
	
}
