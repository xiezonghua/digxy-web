if( "undefined" == typeof(site) ){
	var jq = $;
	var site = {
		request : function(url , dataParam , success , failure){
			var setting = { 
					url: "/digxy"+url ,
					data: dataParam ,
					type : "POST", 
					dataType : "json",
					async: true , 
					success: function(data , textStatus , jqXHR){
						success(data);
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){
						
					},
					statusCode:{
						404: function(){
							
						}
					}
			};
			jq.ajax(setting);
		}, 
		
		upload : function(url, dataParam, fileId , success ,failure){
			var setting = { 
					url: url ,
					data: dataParam ,
					type : "POST", 
					dataType : "json",
					context: jq("#"+fileId)[0],
					contentType: "multipart/form-data;boundary=---addd",
					success: function(data , textStatus , jqXHR){
						success(data);
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){
						
					},
					statusCode:{
						404: function(){
							
						}
					}
			};
			
			jq.ajax(setting);
		},
		
		modelConverter:function(prefixed , data){
			var convertData = {} ;
			for(var i = 0 ; i < data.length ; i++){
				convertData[prefixed+"."+data[i]] = jq("#"+data[i]).val(); 
			}
			
			return convertData;
		},
		
		selectedTab : function(prefixed ,tabNum){
			var tab_header = jq("#tab_header_"+prefixed + "> span" );
			tab_header.removeClass("tab_selected").addClass("tab_unselected");
			jq(tab_header[tabNum]).removeClass("tab_unselected").addClass("tab_selected");
			
			var tab_detail = jq("#tab_detail_"+prefixed +"> div");
			tab_detail.addClass("hidden");
			jq(tab_detail[tabNum]).removeClass("hidden");
			
		},
		
		click : function( targetID ){
			jq("#"+targetID).click();
		},
		
		validate : function(data){
			var validateBool = true;
			for(var i=0 ; i < data.length ; i++){
				if(!jq("#"+data[i]).val()){
					jq("#"+data[i]+"_msg").html("此项不能为空").addClass("validate_msg");
					validateBool = false;
				}else{
					jq("#"+data[i]+"_msg").html("").removeClass();
				}
			}
			return validateBool; 
		}
	};
};