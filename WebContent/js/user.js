if ("undefined" == typeof (user)) {
	var user = {
		init : function() {
			var requestData = {
				"userModel.id" : 1
			};
			hyCom.request(user.url.init, requestData, function(data) {
				console.log(data);
			});
		},
		
		reg : function(){
			if(!hyCom.validate(["petName" , "userName" , "password"])) return;
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
			
			hyCom.request(user.url.reg, requestData, function(data) {
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
			if(!hyCom.validate(["id" , "petName"   , "email"])) return;
			var requestData = site.modelConverter("userModel" , ["id" , "petName" , "email" , "imessager" , "phone", "profile"]);
			
			hyCom.request(user.url.update, requestData, function(data) {
//				jq("#update_p_message").html("更新成功").addClass("validate_msg");
				hyCom.msg("更新成功");
				user.toUnEditBaseInfo(true);
			});
		},
		
		updatePassword : function(){
			if(!hyCom.validate(["oldPassword" , "password" , "password2"])) return ;
			if(jq("#password").val() != jq("#password2").val()){
				jq("#password2_msg").html("前后密码不一致").addClass("validate_msg");
				return;
			}
			var requestData = site.modelConverter("userModel" , ["oldPassword" , "password"]);
			hyCom.request(user.url.updatePwd , requestData, function(data){
				hyCom.msg("更新成功");
				jq("#passwordForm")[0].reset();
//				jq("#pwd_update_msg").html("更新成功").addClass("validate_msg");
			});
		},
		
		showDetail : function(id , isDetail){
			
			hyCom.request(user.url.getById, {"userModel.id":id}, function(data){
				jq("#userId").val(data.id);
				jq("#userName").val(data.userName);
				jq("#petName").val(data.petName);
				jq("#email").val(data.email);
				jq("#cardID").val(data.cardID);
				jq("#imessager").val(data.imessager);
				jq("#phone").val(data.phone);
				
				jq("#regtime").val(data.regtime);
				jq("#level").val(data.level).attr("disabled", isDetail);
				jq("#role").val(data.role).attr("disabled", isDetail);
				if(isDetail){
					jq("#user_opt").addClass("hidden");
				}else{
					jq("#user_opt").removeClass("hidden");
				}
				
				hyCom.openHtml(jq("#detailDIV"));
			});
		},
		updateM : function(){
			var id = jq("#userId").val();
			var paramData = {
				"userModel.id" : id,
				"userModel.level": jq("#level").val(),
				"userModel.role": jq("#role").val(),
				"userModel.petName": jq("#petName").val(),
				"userModel.email": jq("#email").val(),
			};
			hyCom.request(user.url.update,paramData, function(data){
					hyCom.msg("更新成功");
					jq("#utype_"+id).html(jq("#role").find("option:selected").text());
					jq("#level_"+id).html(jq("#level").val());
					hyCom.dialogClose("page");
				});
		},
		
		attentive : function(userId, name , id){
			hyCom.request(user.url.attentive,paramData, function(data){
				hyCom.msg("关注成功");
				jq("#utype_"+id).html(jq("#role").find("option:selected").text());
				jq("#level_"+id).html(jq("#level").val());
				hyCom.dialogClose("page");
			});
		}
		
	
	};

	user.url = {
		init : "/user/getById",
		reg: "/user/regist"	,
		update: "/user/update",
		updatePwd: "/user/updatePwd",
		getById : "/user/getById" , 
		attentive : "/attentive/add"
		
	};
}
