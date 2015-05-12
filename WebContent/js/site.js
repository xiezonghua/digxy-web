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
						if(data.status == 200){
							success(data.data);
						}else if(data.status == 120){
							alert("validate failure:"+ data.validateInfo);
						}else{
							alert(data.statusInfo);
						}
							
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
		
		redirect:function( url ){
			window.location = "/digxy"+url;
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
		},
		show : function( width , height) {
			var w_width = document.body.offsetWidth;
			var w_height = document.body.offsetHeight;
			
			var bgDiv = document.getElementById("pop_divbg");
			bgDiv.style.display = "";
			bgDiv.style.width = w_width;
			bgDiv.style.height = w_height;
			
			var content = document.getElementById("pop_diveditcontent");
			content.style.display = "";
			content.style.width = width + "px";
			content.style.height = height +"px";	

			content.style.left = (w_width - width)/2 +"px";
			
		},
		
		hide: function(){
			document.getElementById("pop_divbg").style.display = "none";
			document.getElementById("pop_diveditcontent").style.display = "none";
		},
		
		alertTips : function( msg ){
			alert(msg);
		}
	};
};