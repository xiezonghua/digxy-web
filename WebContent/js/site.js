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
		
		showSWF : function(){
			 jq('#flashcontent').FlexPaperViewer(
			            { config : {

			                SWFFile : 'upload/',

			                Scale : 0.6,
			                ZoomTransition : 'easeOut',
			                ZoomTime : 0.5,
			                ZoomInterval : 0.2,
			                FitPageOnLoad : true,
			                FitWidthOnLoad : false,
			                FullScreenAsMaxWindow : false,
			                ProgressiveLoading : false,
			                MinZoomSize : 0.2,
			                MaxZoomSize : 5,
			                SearchMatchAll : false,
			                InitViewMode : 'Portrait',
			                RenderingOrder : 'flash',
			                StartAtPage : '',

			                ViewModeToolsVisible : true,
			                ZoomToolsVisible : true,
			                NavToolsVisible : true,
			                CursorToolsVisible : true,
			                SearchToolsVisible : true,
			                WMode : 'window',
			                localeChain: 'en_US'
			            }}
			    );
		},
		hide: function(){
			document.getElementById("pop_divbg").style.display = "none";
			document.getElementById("pop_diveditcontent").style.display = "none";
		},
		
		alertTips : function( msg ){
			alert(msg);
		},
		
		openIframe : function(htmlURL){
			layer.open({
			    type: 2,
			    area: ['650px', '440px'],
			    fix: false, //不固定
			    maxmin: true,
			    content: htmlURL 
			});	
		},
		openHtml : function(id){
			  layer.open({
			        type: 1,
			        area: ['600px', '360px'],
			        shadeClose: true, //点击遮罩关闭
			        content: $("#"+id).html(),
			    });
		}
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
			
			localConfig.pageCount = (localConfig.count/localConfig.limit);
			if(localConfig.count%localConfig.limit > 0){
				localConfig.pageCount = localConfig.pageCount + 1;
			}
			var leftOffset = (localConfig.selectedNum + localConfig.limit/2);
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
			return localConfig;
		},
		
		init: function( wrapperId, config ){
			if(config.count < 2){return ;}
			var localConfig = this.extendConfig(config);
			
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
