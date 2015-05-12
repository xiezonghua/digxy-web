if ("undefined" == typeof (collecter)) {
	var jq = $;
	var collecter = {
		init: function(){
		
		},
		
		add : function(){
			if(!site.validate(["resId"])) return;
			var dataParam =  site.modelConverter("collecterModel" , ["docName" , "resName" , "resDesc" , "resType", "dicType", "resLabel"]);
			
			site.request(collecter.url.add, dataParam, function(data){
				if(data.status == 200){
				}
			});
		},
		
		del : function(id){
			if(!id){ site.alertTips("id obtian failure!");}
			site.request(collecter.url.del , { "collecterModel.id": id} , function(data){
				site.redirect('/collecter/my');
			} );
			
		},
	
		
		url :{
			upload : "/digxy/upload" , 
			add: "/collecter/add",
			del: "/collecter/del"
		}
	};
	
}