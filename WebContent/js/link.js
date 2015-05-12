if ("undefined" == typeof (link)) {
	var jq = $;
	var link = {
	    toUpdatePage: function(id){
	    	site.request(link.url.get , {"linkModel.id":id} , function(data){
	    		jq("#id").val(data.id);
	    		jq("#name").val(data.name);
	    		jq("#address").val(data.address);
	    		jq("#sequence").val(data.sequence);
	    		
	    		jq("#updateBtn").show();
	    		jq("#addBtn").hide();
	    		site.show(400,300);
	    	});
	    },
	    
	    toAddPage : function(){
	    	site.show(400,300);
	    	jq("#addBtn").show();
	    	jq("#updateBtn").hide();
	    },
	    update: function(){
	    	if(!site.validate(["id","name" , "address" ])) return;
			var dataParam =  site.modelConverter("linkModel" , ["id", "name" , "address" , "sequence"]);
			
			site.request(link.url.update, dataParam, function(data){
				site.redirect("/link/index");
			});
	    },
	    
	    del: function(id){
	    	site.request(link.url.del, {"linkModel.id":id}, function(data){
				site.redirect("/link/index");
			});
	    },
		
	    add: function(){
    		if(!site.validate(["name" , "address" ])) return;
			var dataParam =  site.modelConverter("linkModel" , ["name" , "address" , "sequence"]);
			
			site.request(link.url.add, dataParam, function(data){
					site.redirect("/link/index");
			});
	    },
	   
		url :{
			update: "/link/update" , 
			add: "/link/add",
			del: "/link/del",
			get: "/link/get"
		}
	};
	
}
