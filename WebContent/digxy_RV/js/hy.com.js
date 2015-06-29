if ("undefined" == typeof(hyCom)) {
	var jq = $; // JQuery alias define.
	var hyCom = {
		request : function(url, dataParam, success, failure) {
			var setting = {
				url : "/digxy" + url,
				data : dataParam,
				type : "POST",
				dataType : "json",
				async : true,
				success : function(data, textStatus, jqXHR) {
					if (data.status == 200) {
						success(data.data);
					} else if (data.status == 120) {
						alert("validate failure:" + data.validateInfo);
					} else {
						alert(data.statusInfo);
					}

				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {

				},
				statusCode : {
					404 : function() {

					}
				}
			};
			jq.ajax(setting);
		},

		// show dialog common function begin
		alert : function(msg) {
			layer.alert(msg);
		},

		msg : function(msg) {
			layer.msg(msg);
		},

		openHtml : function(content) {
			layer.open({
				type : 1,
				area : [ '600px', '360px' ],
				shadeClose : true, // 点击遮罩关闭
				content : content,
			});
		},
		
		tips : function(msg , id){
			layer.tips( msg,"#"+id, {time:-1,tipsMore:true});
		},

		open : function(config) {
			layer.open(config);
		},
		
		diglogClose : function(type){
			layer.closeAll(type);
		},
		
	// show dialog common function end
		selectedTab : function(prefixed ,tabNum){
			var tab_header = jq("#tab_header_"+prefixed + "> span" );
			tab_header.removeClass("selected").addClass("unselected");
			jq(tab_header[tabNum]).removeClass("unselected").addClass("selected");
			
			var tab_detail = jq("#tab_detail_"+prefixed +"> div");
			tab_detail.addClass("hidden");
			jq(tab_detail[tabNum]).removeClass("hidden");
			
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
		
		modelConverter:function(prefixed , data){
			var convertData = {} ;
			for(var i = 0 ; i < data.length ; i++){
				convertData[prefixed+"."+data[i]] = jq("#"+data[i]).val(); 
			}
			
			return convertData;
		},
	};
}