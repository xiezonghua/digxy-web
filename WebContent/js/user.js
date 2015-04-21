if ("undefined" == typeof (user)) {
	var user = {
		init : function() {
			var requestData = {
				"userModel.id" : 1
			};
			site.request(user.url.init, requestData, function(data) {
				console.log(data);
			});
		},
		
		reg : function(){
			if(!site.validate(["petName" , "userName" , "password"])) return;
			if(!jq("#readLicense").is(":checked")){
				jq("#protocol_msg").html("请阅读协议").addClass("validate_msg");
				return;
			}else{jq("#protocol_msg").html("").removeClass();}
			
			var requestData ={
			    "userModel.petName" :jq("#petName").val(),
			    "userModel.userName":jq("#userName").val(),
			    "userModel.password":jq("#password").val(),
			    "userModel.email" : jq("#userName").val()
			};
			
			site.request(user.url.reg, requestData, function(data) {
				console.log(data);
			});
		},
		
		toUnEditBaseInfo : function(value){
			jq("#petName").attr("disabled" ,value).toggleClass("un-editable");
			jq("#email").attr("disabled" ,value).toggleClass("un-editable");
			jq("#imessager").attr("disabled" ,value).toggleClass("un-editable");
			jq("#phone").attr("disabled" ,value).toggleClass("un-editable");
			jq("#profile").attr("disabled" ,value).toggleClass("un-editable");
			
			if(value){
				jq("#edit_p").show();
				jq("#update_p").hide();
			}else{
				jq("#update_p").show();
				jq("#edit_p").hide();
			}
			
		},
		
		updateBaseInfo: function(){
			if(!site.validate(["id" , "petName"   , "email"])) return;
			var requestData = site.modelConverter("userModel" , ["id" , "petName" , "email" , "imessager" , "phone", "profile"]);
			
			site.request(user.url.update, requestData, function(data) {
				if(data.status == 200){
					jq("#update_p_message").html("更新成功").addClass("validate_msg");
					user.toUnEditBaseInfo(true);
				}
			});
		},
		
		updatePassword : function(){
			if(!site.validate(["oldPassword" , "password" , "password2"])) return ;
			if(jq("#password").val() != jq("#password2").val()){
				jq("#password2_msg").html("前后密码不一致").addClass("validate_msg");
				return;
			}
			
			site.requset(user.url.updatePwd , requestData, function(data){
				if(data.status == 200){
					jq("#pwd_update_msg").html("更新成功").addClass("validate_msg");
				}
			});
		},
		
		
	
	};

	user.url = {
		init : "/user/getById",
		reg: "/user/regist"	,
		update: "/user/update",
		updatePwd: "/user/"
		
	};
}
