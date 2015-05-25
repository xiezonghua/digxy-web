if ("undefined" == typeof (page)) {
	var jq = $;
	var page = {
		init: function(){
			jq("#type").click(function(){
				if(this.checked){
					jq("input[name='resType']").attr("checked" , false);
				}else{
					if(jq("input[name='resType']:checked").length == 0){
						$(this).attr("checked", true).prop("checked",true);
					}
				}
			});
			jq("input[name='resType']").click(function(){
				if(this.checked){
					jq("#type").attr("checked" ,false);
				}else{
					if(jq("input[name='resType']:checked").length  == 0){
						jq("#type").attr("checked" ,true).prop("checked",true);
					}
				}
			});
		},
		
		searchKey: function(key){
			jq("#key").val(key);
			jq("#searchSubmit").click();
		}
	
	};
	
}

page.init();