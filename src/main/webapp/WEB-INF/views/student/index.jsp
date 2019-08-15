<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.xaut.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%User user=(User)request.getSession().getAttribute("user");%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<!-- 开始head -->
<head>
<base href="<%=basePath%>">
<meta charset="utf-8"/>
<title>学生主页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- 0.最先：引入CSS -->
<!-- 开始全局强制样式 -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- 结束全局强制样式 -->
<!-- 开始页级插件样式 -->
<link href="assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css">
<!-- 结束页级插件样式 -->
<!-- 开始页面样式 -->
<link href="assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- 结束页面样式 -->
<!-- 开始主题样式 -->
<link href="assets/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="assets/admin/layout4/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="assets/admin/layout4/css/themes/light.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="assets/admin/layout4/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- 结束主题样式 -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- 结束head -->
<!-- 开始body -->
<body class="page-header-fixed page-sidebar-closed-hide-logo page-sidebar-closed-hide-logo">

<!-- 1.开始顶部div -->
<div class="page-header navbar navbar-fixed-top">
	
	<!-- 1.1开始顶部内容 -->
	<div class="page-header-inner">
		
		<!-- 开始LOGO -->
		<div class="page-logo">
			<a href="announcement/index">
			<img src="assets/admin/layout4/img/logo-light.png" alt="logo" class="logo-default"/>
			</a>
			<div class="menu-toggler sidebar-toggler">
				<!-- 文档说明：删除上面的“隐藏”以启用标题上的边栏切换按钮 -->
			</div>
		</div>
		<!-- 结束LOGO -->

		<!-- 开始响应菜单切换 -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- 结束响应菜单切换 -->
		
		<!-- 开始页顶端 -->
		<div class="page-top">
			
			<!-- 开始标题搜索框 -->
			<form class="search-form" action="extra_search.html" method="GET">
				<div class="input-group">
					<input type="text" class="form-control input-sm" placeholder="Search..." name="query">
					<span class="input-group-btn">
					<a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
					</span>
				</div>
			</form>
			<!-- 结束标题搜索框 -->

			<!-- 开始顶部导航菜单 -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="separator hide">
					</li>
					<!-- 开始通知下拉列表 -->
					<li class="dropdown dropdown-extended dropdown-notification dropdown-dark" id="header_notification_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-success">
						7 </span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3><span class="bold">7 个待定</span> 通知</h3>
								<a href="extra_profile.html">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
										<span class="time">just now</span>
										<span class="details">
										<span class="label label-sm label-icon label-success">
										<i class="fa fa-plus"></i>
										</span>
										New user registered. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">3 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Server #12 overloaded. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">10 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Server #2 not responding. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">14 hrs</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										Application error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">2 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Database overloaded 68%. </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- 结束通知下拉列表 -->

					<!-- 开始用户登录下拉列表 -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="username username-hide-on-mobile">
							<%=user.getUserName()%>
						</span>
						<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
						<img alt="" class="img-circle" src="assets/admin/layout4/img/avatar9.jpg"/>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="extra_profile.html">
								<i class="icon-user"></i> 我的信息 </a>
							</li>
							
							<li>
								<a href="page_calendar.html">
								<i class="icon-calendar"></i> 我的日历 </a>
							</li>
							
							<li class="divider">
							</li>
							
							<li>
								<a href="extra_lock.html">
								<i class="icon-lock"></i> 锁屏 </a>
							</li>
							
							<li>
								<a href="login.html">
								<i class="icon-key"></i> 退出登录 </a>
							</li>
						</ul>
					</li>
					<!-- 结束用户登录下拉列表 -->
				</ul>
			</div>
			<!-- 结束顶部导航菜单 -->
		</div>
		<!-- 结束页顶端 -->
	</div>
	<!-- 1.1结束顶部内容 -->
</div>
<!-- 1.结束顶部div -->

<div class="clearfix">
</div>

<!-- 2.开始中间容器 -->
<div class="page-container">
	<!-- 2.1开始提要栏 -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- 开始侧边栏菜单 -->
			<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				
				<li class="start active">
					<a href="announcement/index">
					<i class="icon-home"></i>
					<span class="title">公告管理</span>
					</a>
				</li>
				
				<li>
					<a href="javascript:;">
					<i class="icon-basket"></i>
					<span class="title">课程管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="student/courseChoosed">
							<i class="icon-home"></i>
							已选课程</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="javascript:;">
					<i class="icon-rocket"></i>
					<span class="title">作业管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="student/workChoosed">
							<span class="badge badge-warning">new</span>已选作业</a>
						</li>
						<li>
							<a href="student/workHistory">
							作业提交历史</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="javascript:;">
					<i class="icon-diamond"></i>
					<span class="title">评论管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="student/commentByMe">
							我的历史评论</a>
						</li>
						<li>
							<a href="student/commentAboutMe">
							关于我的评论</a>
						</li>
					</ul>
				</li>
				
				<li>
					<a href="javascript:;">
					<i class="icon-puzzle"></i>
					<span class="title">我的老师</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="student/teacherChoosed">
							已选课程教师</a>
						</li>
						<li>
							<a href="student/teacherOfCollege">
							本院教师</a>
						</li>
					</ul>
				</li>
				
				<li class="tooltips" data-container="body" data-placement="right" data-html="true">
					<a href="student/aboutUs">
					<i class="icon-paper-plane"></i>
					<span class="title">
					联系我们</span>
					</a>
				</li>
			</ul>
			<!-- 结束侧边栏菜单 -->
		</div>
	</div>
	<!-- 2.1结束提要栏 -->

	<!-- 2.2开始内容 -->
	<div class="page-content-wrapper">
		<div class="page-content">
		
			<!-- 开始页首 -->
			<div class="page-head">
				<!-- 开始页标题 -->
				<div class="page-title">
					<h1>公告管理 <small>所有公告</small></h1>
				</div>
				<!-- 结束页标题 -->
			</div>
			<!-- 结束页首 -->

			<!-- 开始页面内容内部 -->
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<!-- 开始组件-->
					<div class="portlet light tasks-widget">
						<div class="portlet-title">
							<div class="caption caption-md">
								<i class="icon-bar-chart theme-font-color hide"></i>
								<span class="caption-subject theme-font-color bold uppercase">最新公告</span>
								<span class="caption-helper">16 个</span>
							</div>
						</div>
						
						<div class="portlet-body">
							<div class="task-content">
								<div class="scroller" style="height: 282px;" data-always-visible="1" data-rail-visible1="0" data-handle-color="#D7DCE2">
									<!-- 开始公告列表 -->
									<ul class="task-list" id="task-list">
										<!-- 说明：此处由JS动态插入 -->
									</ul>
									<!-- 结束公告列表 -->
								</div>
							</div>
							<div class="task-footer">
								<div id="btn-arrow-link" class="btn-arrow-link">
									<!-- 此处内容由JS显示分页内容 -->
								</div>
							</div>
						</div>
					</div>
					<!-- 结束组件-->
				</div>
			</div>
			<!-- 结束页内容内部 -->
		</div>
	</div>
	<!-- 2.2结束内容 -->
</div>
<!-- 2.结束中间容器 -->

<!-- 3.开始页脚 -->
<div class="page-footer">
	<div class="page-footer-inner">
		2019-2020 &copy; 西安理工大学计算机学院计科专业著
		<a href="http://www.xaut.edu.cn/" target="_blank">西安理工大学</a>
	</div>
	<div class="scroll-to-top">
		<i class="icon-arrow-up"></i>
	</div>
</div>
<!-- 3.结束页脚 -->

<!-- 9999.最后：引入JS -->
<!-- 开始核心插件 -->
<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- 结束核心插件 -->
<!-- 开始页级插件 -->
<script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- 结束页级插件 -->
<!-- 开始页级脚本 -->
<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="assets/admin/layout4/scripts/layout.js" type="text/javascript"></script>
<script src="assets/admin/layout2/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="assets/admin/layout4/scripts/demo.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/index3.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<!-- 结束页级脚本 -->
<!-- 开始自定义JS -->
<script>
/**
 * 重定向到自己
 */
function gotoIndex(forwardUrl,gotoUrl,currentPage,pageSize){
	window.location.href = forwardUrl + "?gotoUrl=" + gotoUrl + "&currentPage=" + currentPage + "&pageSize=" + pageSize;
}

/**
 * 解析上个页面带来的所有参数
 */
 function parseUrl(){
     var url = location.href;
     var i = url.indexOf('?');
     if(i == -1)
    	 return;
     var querystr = url.substr(i+1);
     var arr1 = querystr.split('&');
     var arr2 = new Object();
     for(i in arr1){
         var ta = arr1[i].split('=');
         arr2[ta[0]] = ta[1];
     }
     return arr2;
 };
 
/**
 * 展示公告列表
 */
var default_currentPage = 1; //默认当前页
var default_pageSize = 1; //默认页大小
function showAnnouncement(){
	//1.获得前端参数
	var data = parseUrl();//解析所有参数
	var currentPage;
	var pageSize;
	if(data == null){ //如果没有携带参数，给默认值
		currentPage = default_currentPage;
		pageSize = default_pageSize;
	}
	else{
		currentPage = data['currentPage'];
		pageSize = data['pageSize'];
	}
	
	//2.使用Ajax调用接口
	$.ajax({
        url: '/HomeWorkWeb/announcement/findAllAnnouncementByPage',
        type: 'GET',
        async: false,
        data: {
        	currentPage: currentPage,
        	pageSize: pageSize,
        },
        success: function (response) {
        	//2.1.显示公告
        	var ann_ul = $("#task-list");
    		for(var i=0; i<response.list.length; i++){
    			var ann_li = "";
    			//拼接公告
    			ann_li += '<li><div class="task-title"><span class="task-title-sp">' + response.list[i].aName + '</span>';
    			if(response.list[i].isRead == false){
    				ann_li += '<span class="label label-sm label-danger">new</span>';
    			}
    			ann_li += '<div style="display:inline;float:right"><small>' + new Date(response.list[i].occurTime.time).toLocaleString() + '&nbsp;&nbsp;</small><a href="#">查看&nbsp;&nbsp;</a><a href="#">标记已读</a></div>';
    			ann_li += '</div></li>';
    			
    			//添加公告到列表中
    			ann_ul.append(ann_li);
    		}
    		
    		//2.2.显示分页
    		var page_div = $("#btn-arrow-link");
    		var page = "";
    		page += '<a href="javascript:void(0);" onclick="gotoIndex(\'<%=basePath%>forward.jsp\',\'WEB-INF/views/student/index.jsp\',1,' + response.pageSize + ')">首页&nbsp;&nbsp;</a>';
    		if(response.currentPage == 1){ //当前是第一页，不能点击上一页
    			page += '<a href="javascript:;">上一页&nbsp;&nbsp;</a>';
    		}
    		else{
    			page += '<a href="javascript:void(0);" onclick="gotoIndex(\'<%=basePath%>forward.jsp\',\'WEB-INF/views/student/index.jsp\',' + (response.currentPage-1) + ',' + response.pageSize + ')">上一页&nbsp;&nbsp;</a>';
    		}
    		for(var i=response.start; i<response.start+response.pageNo; i++){
    			if(i == response.currentPage)
    			{
    				//page += '<a href="index.jsp?currentPage=' + (i) + '&pageSize=' + (response.pageSize) + '" style="color:red">' + i + '</a>';
    				page += '<a href="javascript:void(0);" onclick="gotoIndex(\'<%=basePath%>forward.jsp\',\'WEB-INF/views/student/index.jsp\',' + (i) + ',' + response.pageSize + ')" style="color:red">' + i + '&nbsp;&nbsp;</a>';
    			}
    			else{
    				page += '<a href="javascript:void(0);" onclick="gotoIndex(\'<%=basePath%>forward.jsp\',\'WEB-INF/views/student/index.jsp\',' + (i) + ',' + response.pageSize + ')">' + i + '&nbsp;&nbsp;</a>';
    			}
    		}
    		if(response.currentPage == response.totalPage){ //当前是最后一页，不能点击下一页
    			page += '<a href="javascript:;">下一页&nbsp;&nbsp;</a>';
    		}
    		else{
    			page += '<a href="javascript:void(0);" onclick="gotoIndex(\'<%=basePath%>forward.jsp\',\'WEB-INF/views/student/index.jsp\',' + (response.currentPage+1) + ',' + response.pageSize + ')">下一页&nbsp;&nbsp;</a>';
    		}
    		page += '<a href="javascript:void(0);" onclick="gotoIndex(\'<%=basePath%>forward.jsp\',\'WEB-INF/views/student/index.jsp\',' + response.totalPage + ',' + response.pageSize + ')">末页&nbsp;&nbsp;</a>';
    		page += '共' + response.totalPage + '页';
    		
    		page_div.append(page);
        }
	})
};

/**
 * 加载完成后初始化页面
 */
$(document).ready(function() {
	Metronic.init(); // 初始化核心组件
	Layout.init(); // 初始化布局
	QuickSidebar.init(); // 初始化快速侧边栏
	
	sessionStorage.setItem('userName',sessionStorage.getItem('userName'));
	
	showAnnouncement();	//展示公告列表
});
</script>
<!-- 结束自定义JS -->
</body>
<!-- 结束body -->
</html>