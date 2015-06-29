if ("undefined" == typeof (keyW)) {
	var jq = $;
	var keyW = {
	    toUpdatePage: function(id){
	    	hyCom.request(keyW.url.get , {"keywordModel.id":id} , function(data){
	    		jq("#id").val(data.id);
	    		jq("#keywords").val(data.keywords);
	    		
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
	    	if(!hyCom.validate(["id","keywords" ])) return;
			var dataParam =  hyCom.modelConverter("keywordModel" , ["id", "keywords"]);
			
			hyCom.request(keyW.url.update, dataParam, function(data){
				site.redirect("/key/m");
			});
	    },
	    
	    del: function(id){
	    	hyCom.request(keyW.url.del, {"keywordModel.id":id}, function(data){
	    		hyCom.redirect("/key/m");
			});
	    },
		
	    add: function(){
    		if(!hyCom.validate(["keywords" ])) return;
			var dataParam =  hyCom.modelConverter("keywordModel" , ["keywords"]);
			
			hyCom.request(keyW.url.add, dataParam, function(data){
				hyCom.redirect("/key/m");
			});
	    },
	   
		url :{
			manager : "/key/m",
			update: "/key/update" , 
			add: "/key/add",
			del: "/key/del",
			get: "/key/get"
		}
	};
	
}
