if ("undefined" == typeof (rv)) {
	var jq = $;
	var rv = {
		aid : function(){
			var html = new Array();
			html.push("<p class='article_content'>项目开发需要每一位热心人士的帮助和一定资金投入，为了保证项目如期完成，并实现最终规模盈利，我们接受任何资助，并给予最大程度的利益反馈。水下机器人研发项目计划筹集资金20万元，在项目结束时，将召开资金捐献者会议，以产品或项目权益的形式反馈您最初的帮助。</p>");
			html.push("<p class='article_content'>捐助账号：</p>");
			html.push("<p class='article_content'>网银：</p>");
			html.push("<p class='article_content'>支付宝：</p>");
			html.push("<p class='article_content'>截止x年x月x日，已收捐款112300元，明细如下：</p>");
			html.push("<p class='article_content'>20xx年x月x日Xxx   xx元支付宝</p>");
			html.push(" <p class='article_content'>20xx年x月x日Xxx   xx元网银转账</p>");
			html.push("<p class='article_content'> 20xx年x月x日Xxx   xx元汇款</p>");
			this.serviceEntry("项目资助", html.join(""));
		},
		addIn : function(){
			var html = new Array();
			html.push("<p class='article_content'>1、该项目招募5名左右机械、自动化、海洋工程等相关专业人员，要求动手能力强，责任心强，主动性强，具有英文文献阅读能力，并且具有课余时间，能够坚持完成该项目；</p>");
			html.push("<p class='article_content'>2、保证每周能投入30小时以上的时间进行项目工作，及时完成项目负责人分配的具体任务，并能积极主动与项目负责人及项目组成员交流工作进展、遇到的问题和困难，进行和谐的团队工作；</p>");
			html.push("<p class='article_content'>3、想在专业知识、科研能力等方面取得进步的，喜欢科研工作的，有读研、博意愿的同学优先。</p>");
			this.serviceEntry("加入我们", html.join(""));
		},
		contact:function(){
			var html = new Array();
			html.push("<p class='article_content'>如果您有好的建议或任何意见，以及其他的合作提议等，请随时联系：Infor@digxy.com</p>");
			this.serviceEntry("联系我们", html.join(""));
		},
		serviceTime : function(){
			var html = new Array();
			html.push("<p class='article_content'>距离Rov LAB产品发布还有x天Xh，xm，xs。</p>");
			html.push("<p class='article_content'>距离Rov Real产品发布还有x天Xh，xm，xs。</p>");
			html.push("<p class='article_content'>水下机器人基础研发项目计划于x年x月x日结束，期间将完成ROV整体结构设计、控制系统设计、操作软件编制、样机组装与调试、零部件购买或定制加工方案设计等工作，完成模块化水下机器人的研发工作，发布Rov LAB产品，回馈资金捐献人员，完成本项目初始目标。 在此基础上，同时考虑水下机器人升级改造工作和实际应用工作，通过加大资金投入、提升研发平台，开发Rov Real产品。在工业应用方面，通过定制化技术升级和功能开发，以应用价值为导向，实现水下检查与探测、管网勘察、深水打捞、安装维修等功能。在管理方面，成立水下服务团队，通过产品输出、技术服务、教育培训等工作，实现项目营收平衡，将项目参与人员与资金捐献人员的利益最大化。 </p>");
			this.serviceEntry("加入我们", html.join(""));
		},
		serviceEntry : function(title ,content){
			  layer.open({
			        type: 1,
			        title : title,
			        area: ['600px', '360px'],
			        shadeClose: true, //点击遮罩关闭
			        content: content,
			    });
		}
		
	};
}