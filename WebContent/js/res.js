if ("undefined" == typeof (res)) {
	var jq = $;
	var res = {
		init: function(){
		
		},
		
		upload : function(){
			jq('#fileupload').fileupload({
		        url: res.url.upload,
		        dataType: 'json',
		        singleFileUploads : false,
		        limitMultiFileUploads : 2,
		        maxFileSize: 5000000 ,
		        disableValidation : true,
		        add:function(e, data){
		        	var acceptFileTypes =  /(\.|\/)(pdf|doc|docx|xsl)$/i;
		        	if(data.files.length > 1){
		        		alert("只能选择一个文件");
		        	}
		        	if(!acceptFileTypes.test(data.files[0].name)){
		        		alert("只能上传pdf/doc/docx/xsl文件");
		        	}
		        	data.submit(); 
		        },
		        done: function (e, data) {
		            jq.each(data.files, function (index, file) {
		               jq("#uploadFileSection").addClass("hidden");
		               jq("#fileDetailSection").removeClass("hidden");
		               jq("#uploadSave").removeClass("hidden");
		               jq("#uploadSaveTwo").addClass("hidden");
		          
		               jq("#docName").val(file.name);
		            });
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
			
//			jq("#uploadForm").submit();
//			site.upload(res.url.upload , {} , "myFile" ,function(data){
//				console.log(data);
//			});
		},
		
		add : function(){
			if(!site.validate(["docName" , "resName" , "resDesc" , "resType", "dicType"])) return;
			var dataParam =  site.modelConverter("resModel" , ["docName" , "resName" , "resDesc" , "resType", "dicType", "resLabel"]);
			
			site.request(res.url.add, dataParam, function(data){
				if(data.status == 200){
					jq("#uploadSaveTwo").removeClass("hidden");
					jq("#uploadSave").addClass("hidden");
					jq("#res_add_msg").html("添加成功").addClass("validate_msg");
				}
			});
		},
		
		toUpload: function(){
			 jq("#uploadFileSection").removeClass("hidden");
		     jq("#fileDetailSection").addClass("hidden");
		},
		
		url :{
			upload : "/digxy/upload" , 
			add: "/res/add",
		}
	};
	
}

res.upload();