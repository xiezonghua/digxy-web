var hy = hy ? hy : {};

if("undefined" == typeof(hy.notify)){
	jq = $;
	hy.notify = {
		add : function( id ){
			var param = ["content"];
			hyCom.validate(param);
			var dataParam = {};
			dataParam["notify.content"] = jq("#content").val();
			dataParam["notify.busId"] = id ;
			dataParam["notify.isMain"] = jq("#isMain:checked").val();
			hyCom.request(hy.notify.url.add , dataParam , function(data){
				hy.notify.list(id);
			});

		},
		del : function(id , busId){
			var dataParam ={};
			dataParam["notify.id"] = id ;
			hyCom.request(hy.notify.url.del, dataParam , function(data){
				hy.notify.list(busId);
			});
		},
		update: function(){
			var param = ["content"];
			hyCom.validate(param);
			var dataParam = hyCom.modelConverter( "notify" , ["content" , "isMain"]);
			dataParam["notify.busId"] = id ;
			hyCom.request(hy.notify.url.update, dataParam , function(data){
				
			});
		},
		list : function(id){
			var dataParam = {} ;
			dataParam["notify.busId"] = id ;
			hyCom.request(hy.notify.url.list, dataParam , function(data){
				var html = new Array();
				for (var i = 0; i < data.length; i++) {
					html.push('<section class="project_detail_section">');
					html.push('<p> ');
					html.push(data[i].content);
					if( 1 == data[i].isMain){
						html.push('<span style="color:red;">[公告]</span>');
					}
					html.push('<span class="link" onclick="hy.notify.del(');
					html.push(data[i].id);
					html.push(",");
					html.push(data[i].busId);
					html.push(')">删除</span>');
					html.push('<span class="layout_right"><sub>');
					html.push(data[i].addUserName);
					html.push('</sub><span>');
					html.push(' </p>');
					html.push('</section>');
				}
				jq("#notifyListDiv").html(html.join(""));
			});
		}, 
		url : {
			add : "/notify/add" ,
			del : "/notify/del" ,
			update : "/notify/update" , 
			list : "/notify/list"
		}
	};
};