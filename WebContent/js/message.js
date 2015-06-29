if ("undefined" == typeof (message)) {
	var jq = $;
	var message = {
		openDialog : function(id , name){
			var html = new Array();
			html.push("<div><form> <section> <label>To:</label>");
			html.push('<input type="text" id="receiverId" name="receiverId" class="hidden" value="');
			html.push(id);
			html.push('" /><p id="receiver_msg"></p>');
			html.push('<input type="text" name="receiver" id="receiver" disabled="disabled" value="');
			html.push(name);
			html.push('" />');
			html.push('</section>');
			html.push('<section> <label>标题:</label>');
			html.push('<input type="text" name="title1" id="title1"  /><p id="title1_msg"></p></section>');	 
			html.push('<section> <label>内容:</label>');
			html.push('<textarea rows="5" cols="40" id="content" name="content"></textarea><p id="content_msg"></p></section>');		
			html.push('</form></div>');
					
			layer.open({
				type: 1,
			    shift: 2,
			    title: "发信",
			    shadeClose: true, //开启遮罩关闭
			    content:html.join(""),
			    btn : ["发送" , "取消"],
			    area: ['500px', '300px'],
			    yes : function(index, layero){
			    	message.send();
			    },
			    cancel: function(index){
			    	
			    }
				
			});	

			
		},
		send : function(){
			if(!site.validate(["receiverId" , "receiver" , "title1" , "content"])) return;
			var dataParam = {
					"msgModel.receiverId" : $("#receiverId").val(),
					"msgModel.receiver" : $("#receiver").val(),
					"msgModel.title" : $("#title1").val(),
					"msgModel.content" : $("#content").val(),
			};
			site.request(this.url.add, dataParam, function(data){
				layer.closeAll();
				layer.msg('发送成功');
			});
		},
		
		read : function(id){
			site.request(this.url.read, {"msgModel.id" :id}, function(data){
				var html = new Array();
				html.push("<div><form>");
				html.push('<section> <label>From:</label><input type="text" name="sender" id="sender" disabled="disabled" value="');
				html.push(data.sender);
				html.push('" /></section>');
				html.push('<section> <label>To:</label><input type="text" name="receiver" id="receiver" disabled="disabled" value="');
				html.push(data.receiver);
				html.push('" /></section>');
				html.push('<section> <label>标题:</label>');
				html.push('<input type="text" name="title1" id="title1" disabled="disabled" value="');
				html.push(data.title);
				html.push('" /></section>');	 
				html.push('<section> <label>内容:</label>');
				html.push('<textarea rows="5" cols="40" id="content" name="content" disabled="disabled">');
				html.push(data.content);
				html.push('</textarea></section>');		
				html.push('</form></div>');
				
				layer.open({
					type: 1,
				    shift: 2,
				    title: "信息",
				    area: ['500px', '300px'],
				    shadeClose: true, //开启遮罩关闭
				    content:html.join(""),
				});	
			});
		},
		
		delSelf : function(id){
			site.request(this.url.delSelf , {"msgModel.id" :id}, function(data){
				site.redirect("/message/mysend");
			});
		},
		
		del : function(id){
				site.request(this.url.del, {"msgModel.id" :id}, function(data){
				site.redirect("/message/myreceive");
			});
		},
		url :{
			add: "/message/add" , 
			read: "/message/read",
			delSelf : "/message/delSelf",
			del: "/message/del"
		}
	};
	
}
