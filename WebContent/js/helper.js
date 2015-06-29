if ("undefined" == typeof (helper)) {
	var jq = $;
	var helper = {
		umEdit : {}, 
		init: function(){
			if("undefined" != typeof (UM)){
				 helper.umEdit = UM.getEditor('myEditor');
				 helper.umEdit.setWidth("100%");
			}
		},
		
	    save: function(){
    		if(!site.validate(["selectedType"])) return;
    		var dataParam = {};
    		if(jq("#selectedType").val() == "resume"){
    			dataParam = {"helperModel.resume":helper.umEdit.getContent() , "helperModel.id": jq("#id").val()} ;
    		}else if(jq("#selectedType").val() == "docLaw"){
    			dataParam = {"helperModel.docLaw":helper.umEdit.getContent() , "helperModel.id": jq("#id").val()} ;
    		}else if(jq("#selectedType").val() == "contact"){
    			dataParam = {"helperModel.contactInfo":helper.umEdit.getContent(), "helperModel.id": jq("#id").val()} ;
    		}else if(jq("#selectedType").val() == "userLaw"){
    			dataParam = {"helperModel.userLaw":helper.umEdit.getContent(), "helperModel.id": jq("#id").val()} ;
    		}
			
			site.request(helper.url.update, dataParam, function(data){
					site.redirect("/helper/"+jq("#selectedType").val());
			});
	    },
	    
	    getInfo : function(type){
			site.request(this.url.get,{"helperModel.helperType": type}, function(data){
				layer.open({
					type: 1,
				    skin: 'layui-layer-rim', //加上边框
				    area: ['420px', '240px'], //宽高
				    content: data[type] 
				});	
			});
		},	   
		url :{
			update: "/helper/update" , 
			get: "/helper/get"
		}
	};
	
}

helper.init();