if ("undefined" == typeof (hyUserCom)) {
	var hyUserCom = {
		url : {
			reg: "/user/regist",
			login: "/user/login",
			signout :"/user/signout",
		},
		
		init : function(config){
			
		},

		login : function() {
			if(!hyCom.validate([ "name" , "pwd"])) return;
			var requestData = {
				"userModel.userName" : $("#name").val(),
				"userModel.password" : $("#pwd").val()
			};
			
			hyCom.request(this.url.login, requestData,function(data) {
				hyCom.selectedTab("login", 0);
				hyCom.dialogClose("page");
				window.location = window.location.pathname;
			});
		},
		signout : function(){
			hyCom.request(this.url.signout, {},function(data) {
				window.location = "/digxy/index";
			});
		},
		register : function(){
			if(!hyCom.validate(["petName" , "userName" , "password" , "password2"])) return;
			if(jq("#password").val() != jq("#password2").val()){
				jq("#password2_msg").html("前后密码不一致").addClass("validate_msg");
				return ;
			}
			
			if(!jq("#readLicense").is(":checked")){
				jq("#protocol_msg").html("请阅读协议").addClass("validate_msg");
				return;
			}else{jq("#protocol_msg").html("").removeClass();}
			
			var requestData = hyCom.modelConverter("userModel" , ["petName" , "userName" , "password"]);
			requestData["userModel.email"] = jq("#userName").val();
			
			hyCom.request(this.url.reg, requestData, function(data) {
				hyCom.msg("注册成功,请登陆邮箱激活。");
				hyCom.selectedTab("login", 0);
			});
		},
		notSignIn: function(){
			if(!jq("#userLogin").val()){
				hyUserCom.loginDialog("#", 0);
				return true;
			}
			return false;
		},
		findPwd : function(){
			var html = new Array();
			
			html.push('<div style="padding:20px;">');
			html.push('			<form class="login" action="');
//			html.push(loginUrl);
			html.push('" method="post">');
			html.push('					<section>');
			// html.push(' <label for="login_name">用户名: </label>');
			html.push('						<input type="text" id="myEmail" name="myEmail" placeholder="请输入注册邮箱"/>');
			html.push('					</section>');
			html.push('					<section>');
			html.push('						<input type="button" value="找回" onclick="">');
			html.push('						<p >');
			html.push('							<em>请到您注册的邮箱，获取重置连接</em>');
			html.push('						</p>');
			html.push('					</section>');
			html.push('			</form>');
			html.push('</div>');
			
			hyCom.open({
				type : 1,
				title : "<strong>找回密码</strong>",
				area : [ "30em", "14em" ],
				shadeClose : true, // 点击遮罩关闭
				content : html.join(""),
			});
		},
		loginDialog : function(loginUrl, num) {
			var html = new Array();

			var tab = "<p id='tab_header_login' class='tab_header'><span onclick='hyCom.selectedTab(\"login\",0)'"
					+ " class='selected'>登录</span><span  onclick='hyCom.selectedTab(\"login\",1)' >快速注册</span></p>";
			html.push(tab);
			html.push('<section id="tab_detail_login">');

			// login
			html.push('<div style="padding:20px;">');
			html.push('			<form class="login" action="');
			html.push(loginUrl);
			html.push('" method="post">');
			html.push('					<section>');
			// html.push(' <label for="login_name">用户名: </label>');
			html.push('						<input type="text" id="name" name="name" placeholder="请输入用户名"/>');
			html.push('				<span id="name_msg"></span>');
			html.push('					</section>');
			html.push('					<section>');
			// html.push(' <label for="login_pwd">密码: </label>');
			html.push('						<input type="password" id="pwd" name="pwd" placeholder="请输入密码"/>');
			html.push('				<span id="pwd_msg"></span>');
			html.push('					</section>');
			html.push('					<section>');
			html.push('						<input type="button" value="登录" onclick="hyUserCom.login();">');
			html.push('						<p >');
			html.push('							<em><a href="#" onclick="hyUserCom.findPwd();">如果忘记，找回密码?</a></em>');
			html.push('						</p>');
			html.push('					</section>');
			html.push('			</form>');
			html.push('</div>');

			// register
			html.push('<div class="article_aside hidden">');
			html.push('		<section  style="padding:20px;">');
			html.push('			<form class="login" method="post" action="/user/regist">');
			html.push('			<section>');
			// html.push(' <label for="userName">用户ID</label>');
			html.push('				<input type="text" id="userName" name="userModel.userName" placeholder="请输入邮箱"/>');
			html.push('				<span id="userName_msg"></span>');
			html.push('			</section>');
			html.push('			<section>');
			// html.push(' <label for="petName">昵称</label>');
			html.push('				<input type="text" id="petName" name="userModel.petName" placeholder="请输入昵称"/>');
			html.push('				<span id="petName_msg"></span>');
			html.push('			</section>');
			html.push('			<section>');
			// html.push(' <label for="password">密码</label>');
			html.push('				<input type="password" id="password" name="userModel.password" placeholder="请输入密码"/>');
			html.push('				<span id="password_msg"></span>');
			html.push('			</section>');
			html.push('			<section>');
			// html.push(' <label for="password">密码</label>');
			html.push('				<input type="password" id="password2" name="userModel.password2" placeholder="请输入确认密码"/>');
			html.push('				<span id="password2_msg"></span>');
			html.push('			</section>');
			html.push('			<section>');
			html.push('				<p>');
			html.push('				<input type="checkbox" id="readLicense" name="readLicense" >');
			html.push('				<span id="protocol_msg"></span>');
			html.push('				<label >我已阅读并接受<a href="about_protocol.html">《用户协议》</a></label>');
			html.push('				</p>');
			html.push('			</section>');
			html.push('			<section>');
			html.push('				<input type="button" value="注册" onclick="hyUserCom.register()">');
			html.push('				<p id="submit_msg"></p>');
			html.push('			</section>		');
			html.push('		</form>');
			html.push('		</section>');
			html.push('</div>');
			
			html.push('</section>');

			hyCom.open({
				type : 1,
				title : "<strong>登录/注册</strong>",
				area : [ "30em", "22em" ],
				shadeClose : true, // 点击遮罩关闭
				content : html.join(""),
			});

			if (num && num > 0) {
				hyCom.selectedTab("login", num);
			}
		},

	};
}

if(window.location.search == "?login"){
	if(document.getElementById("user")){
		window.location = window.location.pathname;
	}
	
	hyUserCom.loginDialog("#", 0);
	hyCom.msg("登录失效或暂未登录，请重新登陆");
}