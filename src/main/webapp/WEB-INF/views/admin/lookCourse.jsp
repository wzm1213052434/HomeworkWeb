<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xaut.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%> 
<%User user=(User)request.getSession().getAttribute("user");%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="admin" name="description"/>
<meta content="HeQin" name="author"/>
<title>管理员页面</title>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="images/favicon.ico"/>
</head>
<body  class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<div class="page-logo">
			<a href="admin/index">
				<img src="assets/admin/layout/img/logo-big.png" style="width:190px;height:45px;margin:0;" alt="XAUTlogo" class="logo-default"/>
			</a>
			<div class="menu-toggler sidebar-toggler hide"></div>
		</div>
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"></a>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-default">4</span>
					</a>
					<ul class="dropdown-menu">
						<li class="external">
							<h3><span class="bold">4</span>条新消息</h3>
							<a href="#">查看详情</a>
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
											New user registered. 
										</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
										<span class="time">3 mins</span>
										<span class="details">
											<span class="label label-sm label-icon label-danger">
												<i class="fa fa-bolt"></i>
											</span>
											Server #12 overloaded. 
										</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">10 mins</span>
									<span class="details">
										<span class="label label-sm label-icon label-warning">
											<i class="fa fa-bell-o"></i>
										</span>
										Server #2 not responding. 
									</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">14 hrs</span>
									<span class="details">
										<span class="label label-sm label-icon label-info">
											<i class="fa fa-bullhorn"></i>
										</span>
										Application error. 
									</span>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li class="dropdown dropdown-user">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<img alt="管理员：" class="img-circle" src="assets/admin/layout/img/avatar.png"/>
						<span class="username username-hide-on-mobile">管理员</span>
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li><a href="admin/myself"><i class="icon-user"></i>个人信息 </a></li>
						<li><a href="logout"><i class="icon-key"></i>退出登入</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="sidebar-toggler-wrapper">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler"></div>
					<!-- END SIDEBAR TOGGLER BUTTON -->
				</li>
				<li class="heading"><h3 class="uppercase">Functions</h3></li>
				<li class="start active open">
					<a href="javascript:;">
						<i class="icon-home"></i>
						<span class="title">系统使用详情</span>
						<span class="selected"></span>
						<span class="arrow open"></span>
					</a>
					<ul class="sub-menu	">
						<li><a href="admin/index"><i class="icon-bar-chart"></i> 用户信息</a></li>
						<li class="active"><a href="javascript:;"><i class="icon-bar-chart"></i> 课程信息</a></li>
						<li><a href="admin/lookWork"><i class="icon-bar-chart"></i> 作业信息</a></li>
						<li><a href="admin/lookAnnounce"><i class="icon-bar-chart"></i> 公告信息</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">
						<i class="icon-screen-smartphone"></i>
						<span class="title">用户管理</span>
						<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li><a href="admin/mStudent"><i class="icon-user-follow"></i>学生管理</a></li>
						<li><a href="admin/mTeacher"><i class="icon-user-follow"></i>教师管理</a></li>
						<li><a href="admin/mAdmin"><i class="icon-user-follow"></i>管理员管理</a></li>
					</ul>
				</li>
				<li class="last ">
					<a href="javascript:;">
						<i class="icon-user"></i><span class="title">我的信息</span><span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li><a href="admin/myself"><i class="icon-notebook"></i> 您的信息</a></li>
						<li><a href="logout"><i class="icon-key"></i> 退出登入</a></li>
					</ul>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><i class="fa fa-home"></i>系统使用详情<i class="fa fa-angle-right"></i></li>
					<li>课程信息</li>
				</ul>
			</div>
			<h3 class="page-title">
				课程信息 <small>查看所有课程</small>
			</h3>
			<!-- END PAGE HEADER-->
			<!-- 显示表格部分-开始 -->
			<div class="row">
				<div class="col-md-12">
					<div class="portlet box green">
						<div class="portlet-title" style="vertical-align:middle;position:relative;">
							<div class="caption" style="position:absolute;top:30%;"><i class="fa fa-comments"></i>课程信息总览</div>
							<div class="tools" style="height:17px;position:absolute;top:30%;right:2%;overflow:hidden;">
								<a href="javascript:;" class="collapse" title="折叠"></a>
							</div>
						</div>
						<div class="portlet-body">
							<div class="row">
								<div class="col-md-6 col-sm-12">
									<div id="sample_editable_1_filter" class="dataTables_filter">
										<input id="contentInput" type="search" class="form-control input-big input-inline" placeholder="按课程名查询">
										<button class="form-control input-inline" onclick="findInform('请输入课程名');">查询</button>
										<button class="form-control input-inline" onclick="location.href='admin/lookCourse';">显示所有</button>
									</div>
								</div>
							</div>
							<div class="table-scrollable">
								<table class="table table-striped table-hover">
									<thead>
										<tr id="displayMessage" style="display:none;">
											<th style="text-align:center;" colspan="8"><span style="color:#d1d1d1;font-style:oblique;font-size:35px;" id="emptyMessage"></span></th>
										</tr>
										<tr id="displayContent" style="display:show;text-align:center;">
											<th style="width:14%;">课程号</th>
											<th style="width:8%;">教职工号</th>
											<th style="width:10%;">课程名</th>
											<th style="width:8%;">学年</th>
											<th style="width:8%;">学期</th>
											<th style="width:25%;">上课时间</th>
											<th style="width:20%;">上课地点</th>
											<th style="width:5%;">是否结课</th>
											<th style="width:2%;">操作</th>
										</tr>
									</thead>
									<tbody id="contentList"></tbody>
								</table>
							</div>
							<div class="row" id="pages">
								<div class="col-md-4 col-sm-5 pull-right">
									<div class="dataTables_paginate paging_bootstrap_full_number">
										<ul class="pagination">
											<li><a href="javascript:;" title="上一页" onclick="jumpPrevPage();"><i class="fa fa-angle-left"></i></a></li>
											<li id="pageList"></li>
											<li id="pageURL" style="display:none;" name="cname">admin/lookCourse</li>
											<li><a href="javascript:;" title="下一页" onclick="jumpNextPage();"><i class="fa fa-angle-right"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 显示表格部分-结束-->
		</div>
	</div>
</div>


<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="js/global/plugins/respond.min.js"></script>
<script src="js/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<script src="assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- 自定义函数   开始 -->
<script src="assets/admin/admin/pageLook/functions.js" type="text/javascript"></script>
<!-- 自定义函数   结束 -->
<!-- 获取内容  开始 -->
<script>
var Page = 1;      /* 搜索信息所用初始页号  */
var Rows = 10;      /* 搜索信息所用每页条数  */
var TheName = '';  /* 搜索信息所用课程名     */
var total = 1;  /* 记录总页数  */
var now = 1;    /* 记录当前页  */

function changePar(){  /* 更改页面原始参数函数  */
	var id1 = GetPar("page");
	var id2 = GetPar("cname");
	if(id1 != null){
		var nowpage = parseInt(id1);
		Page = nowpage;
		now = Page;
	}
	if(id2 != null){
		TheName = id2;
	}
}
var ajaxForMsg = function (p,r,c) {
    $.ajax({
        url:'/HomeWorkWeb/admin/lookCourseMsg',
        type:'GET',
        async:false,
        traditional : true,
        data:{
            page:p,
            rows:r,
            cname:c
        },
        dataType : 'JSON',
        beforeSend: function () {
            console.log("正在进行，请稍候");
        },
        success: function (data) {
        	dataFirstToLast(data.message,p,r);
	       	dataList(data.data);
        }
    })
}
function dataList(info){  /* 将信息写到列表中  */
	var cList = $('#contentList');
	for(var j=0;j<info.length;j++){
		if(info[j].state == "ture")
			var st = "是";
		else
			var st = "否";
		var newNode=$('<tr><td>'+info[j].cno+'</td><td>'+info[j].tno+'</td><td><a href="admin/lookCourseDetail?cno='+info[j].cno+'">'+info[j].cname+'</a></td><td>'+info[j].year+'</td><td>'+info[j].term+'</td><td>'+info[j].time+'</td><td>'+info[j].place+'</td><td>'+st+'</td><td><a class="edit" href="javascript:;">删除</a></td></tr>');
		cList.append(newNode);
	}
}
</script>
<!-- 获取内容  结束 -->
<script>
jQuery(document).ready(function() {   
	Metronic.init(); // init metronic core componets
	Layout.init(); // init layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	Index.init();   
	Index.initDashboardDaterange();
	Index.initJQVMAP(); // init index page's custom scripts
	Index.initCalendar(); // init index page's custom scripts
	Index.initCharts(); // init index page's custom scripts
	Index.initChat();
	Index.initMiniCharts();
	Tasks.initDashboardWidget();
	changePar();
	ajaxForMsg(Page,Rows,TheName);
});
</script>
</body>
</html>