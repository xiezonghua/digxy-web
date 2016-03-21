layer.config({
    skin: 'demo-class'
})

if ("undefined" == typeof(hyCom)) {
	var jq = $; // JQuery alias define.
	var hyCom = {
		request : function(url, dataParam, success, failure) {
			var setting = {
				url : url,
				data : dataParam,
				type : "POST",
				dataType : "json",
				async : true,
				success : function(data, textStatus, jqXHR) {
					if (data.status == 200) {
						success(data.data);
					} else if (data.status == 120) {
						hyCom.alert("validate failure:" + data.validateInfo);
					} else {
						hyCom.alert(data.statusInfo);
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
		
		upload : function(id , contextId , success ,failure , url){
			var urlAd = url ? url : "/upload";
			jq('#' + id).fileupload({
		        url: urlAd,
		        dataType: 'json',
		        singleFileUploads : false,
		        limitMultiFileUploads : 2,
		        maxFileSize: 5000000 ,
		        disableValidation : true,
		        add:function(e, data){
		        	var acceptFileTypes =  /(\.|\/)(pdf|doc|docx|xsl)$/i;
		        	if(data.files.length > 1){
		        		alert("只能选择一个文件");
		        		return ;
		        	}
		        	if(!acceptFileTypes.test(data.files[0].name)){
		        		alert("只能上传pdf/doc/docx/xsl文件");
		        		return ;
		        	}
		        	data.submit(); 
		        },
		        done: function (e, data) {
		            jq.each(data.files, function (index, file) {
		               jq("#"+ contextId).val(file.name);
		            });
		            success && success(data);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            jq('#progress .progress-bar').css(
		                'width',
		                progress + '%'
		            );
		        }
		    }).prop('disabled', !$.support.fileInput)
	        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		},

		// show dialog common function begin
		alert : function(msg) {
			layer.alert(msg);
		},

		msg : function(msg) {
			layer.msg(msg);
		},

		openHtml : function(content , title , type) {
			var index = layer.open({
				type : type ? type : 1,
				area : [ '600px', '360px' ],
				shadeClose : true, // 点击遮罩关闭
				content : content,
				title: title , 
			});
			
			return index;
		},
		
		tips : function(msg , id){
			layer.tips( msg,"#"+id, {time:-1,tipsMore:true});
		},

		open : function(config) {
			layer.open(config);
		},
		
		dialogClose : function(type){
			layer.closeAll(type);
		},
		
		dialogCloseById : function(index){
			layer.close(index);
		},
		
	// show dialog common function end
		selectedTab : function(prefixed ,tabNum){
			var tab_header = jq("#tab_header_"+prefixed + "> span" );
			if(tab_header.length == 0){
				tab_header = jq("#tab_header_"+prefixed + "> li" );
			}
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
					
					if(data[i] == "email" || data[i] == "mail"){
						if(!hyCom.validateMail(jq("#"+data[i]).val())){
							jq("#"+data[i]+"_msg").html("邮件格式不正确").addClass("validate_msg");
							validateBool = false;
						}
					}
				}
			}
			return validateBool; 
		},
		validateMail : function(mail){
			 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			 if(filter.test(mail)){
				 return true;
			 }
			 return false;
		},
		
		modelConverter:function(prefixed , data){
			var convertData = {} ;
			for(var i = 0 ; i < data.length ; i++){
				convertData[prefixed+"."+data[i]] = jq("#"+data[i]).val(); 
			}
			
			return convertData;
		},
		redirect:function( url ){
			window.location = url;
		},
		 getUrlParam: function(name) {
	            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	            if (r != null) return unescape(r[2]); return null; //返回参数值
	        },
	};
};

if( "undefined" == typeof(paginate) ){
	var paginate = {
		extendConfig : function( config){
			var localConfig = {
				selectedNum : config.selectedNum ? config.selectedNum : 1,
				count : config.count,
				limit : config.limit ? config.limit: 10 ,
				pageCount : 1,
				startNum : 1 , 
				end : 0 ,
				searchKey : config.searchKey,
				url : config.url
			};
			
			localConfig.pageCount = parseInt(localConfig.count/localConfig.limit);
			if(localConfig.count%localConfig.limit > 0){
				localConfig.pageCount = localConfig.pageCount + 1;
			}
			var leftOffset = (localConfig.selectedNum + parseInt(localConfig.limit/2));
			if( leftOffset > localConfig.limit ){
				if(localConfig.pageCount >= leftOffset){
					localConfig.end = leftOffset - 1;
				}else{
					localConfig.end = localConfig.pageCount;
				}
			}else{
				localConfig.end = (localConfig.pageCount > localConfig.limit)? localConfig.limit: localConfig.pageCount;
			}
		
			localConfig.startNum = localConfig.end - localConfig.limit;
			localConfig.startNum = (localConfig.startNum > 0)? localConfig.startNum: 1;
			return localConfig;
		},
		
		init: function( wrapperId, config ){
			var localConfig = this.extendConfig(config);
			if(config.count <= localConfig.limit){return ;}
			
			var url = localConfig.url + localConfig.searchKey + "&pageNum=";
			if(!localConfig.searchKey){
				url = localConfig.url + "pageNum=";
			}
				
			var html = new Array();
			var end ="</a>";
			
			if(localConfig.selectedNum > 1){
				html.push('<a href="');
				html.push(url + (localConfig.selectedNum - 1));
				html.push('" class="n">&lt;上一页</a>');
			}
			
			for(var i= localConfig.startNum ; i <= localConfig.end; i++){
				if(i == localConfig.selectedNum){
					html.push("<strong");
					end ="</strong>"; 
				}else{
					html.push("<a href=");
					html.push(url + i);	
				}
				
				html.push('><span class="pc">');
				html.push(i);
				html.push("</span>");
				html.push(end);
			}
			
			if(localConfig.selectedNum <  localConfig.end){
				html.push('<a href="');
				html.push(url + (localConfig.selectedNum + 1));
				html.push('" class="n">下一页&gt;</a>');
			}
			
			document.getElementById(wrapperId).innerHTML = html.join("");
		}
		
		
	};
};
