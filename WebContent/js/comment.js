if ("undefined" == typeof (comment)) {
	var jq = $;
	var comment = {
		init:function(){
			jq("#content").click(function(){
				hyUserCom.notSignIn();
			});
		},
	    add : function(id , callback){
	    	if(hyUserCom.notSignIn()){
	    		return ;
	    	}
	    	
	    	var content = jq("#content").val();
	    	if(!content){
	    		layer.alert("评论信息不能为空");
	    		return ;
	    	}
	    	var dataParam = {"commentModel.resId":id , "commentModel.content": content  };
	    	
	    	hyCom.request(this.url.add , dataParam, function(data){
	    		callback();
	    	});
	    },  
	    
	    addInPage : function(id){
	    	this.add(id , function(){
	    		window.location = "index?commentModel.resId="+id;
	    	});
	    },
	    list : function(resId , pageNum){
	    	var dataParam = {"commentModel.resId" :resId , "pageNum": pageNum };
	    	hyCom.request(this.url.list , dataParam, function(data){ 
	    		var html = new Array();
	    		for(var i = 0 ; i < data.length ; i++){
		    		html.push('<section class="user_comment">');
		    		html.push('<p class="say_content">');
		    		html.push(data[i].content);
		    		html.push('</p><p class="user_title"><span class="title_dash"></span><a href="');
		    		html.push(data[i].commenterId);
		    		html.push('">');
		    		html.push(data[i].commenter);
		    		html.push('</a> , &nbsp;&nbsp;评论于：');
		    		html.push(data[i].commentDate);
		    		html.push('</p></section>');	
	    		}
	    		jq("#comment").append(html.join(""));
	    		
	    	});
	    },
	    del : function(id){
	    	hyCom.request(this.url.del, {"commentModel.id":id}, function(data){ 
	    		hyCom.redirect("/comment/my");
	    	});
	    },
		url :{
			add : "/comment/add" , 
			del : "/comment/del" , 
			list : "/comment/list" 
		}
	};
	
}
