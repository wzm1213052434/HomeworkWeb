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
<style>
.Gridborder{
	height:60px;
	padding:5% 10%;
	text-align:center;
	vertical-align:center;
}
a.studentGrid{
	display:block;
	height:100%;
	width:100%;
	background-color:#fafafa;
	border:solid 1px #bababa;
}
a.studentGrid:hover {
	display:block;
	height:100%;
	width:100%;
	background-color:#efefef;
	border:solid 1px gray;
	text-decoration:none;
}
</style>
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
						<li><a href="login"><i class="icon-key"></i>退出登入</a></li>
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
						<li class="active"><a href="admin/lookCourse"><i class="icon-bar-chart"></i> 课程信息</a></li>
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
						<li><a href="login"><i class="icon-key"></i> 退出登入</a></li>
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
					<li><a href="admin/lookCourse"><i class="fa fa-angle-left"></i>返回课程总览</a></li>
				</ul>
			</div>
			<h3 class="page-title">课程信息详情 &nbsp;<small id="courseNo"></small></h3>
			<!-- END PAGE HEADER-->
			<!-- 显示基本信息  开始 -->
			<div class="portlet light bordered">
				<div class="portlet-title">
					<div class="caption">
						<span class="caption-subject font-red-sunglo bold">课程基本信息</span>
					</div>
				</div>
				<div class="portlet-body">
					<div class="list-group">
						<div class="row">
							<!-- 左部信息  开始 -->
							<div class="col-md-6 col-sm-12">
								<div class="portlet light bordered">
									<div class="portlet-body">
										<table class="table table-bordered table-hover">
											<tbody>
												<tr><td>课程号</td><td id="courseNo2"></td></tr>
												<tr><td>课程名</td><td>***</td></tr>
												<tr><td>课程教师</td><td>***</td></tr>
												<tr><td>发布作业数</td><td>***</td></tr>
												<tr><td>学生人数</td><td>***</td></tr>												
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- 左部信息  结束 -->
							<!-- 右部信息  开始 -->
							<div class="col-md-6 col-sm-12">
								<div class="portlet light bordered" style="height:250px">
									<div  class="portlet-body" style="position:relative;">
										<div style="width:25%;position:absolute;top:18px;">课程描述</div>
										<div style="width:80%;position:absolute;left:70px;top:10px;">
											<div class="list-group-item" style="height:200px;word-wrap: break-word;overflow:auto;">
												<span>
												lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
												lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
												lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
												lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 右部信息  结束 -->
						</div>
					</div>
				</div>
				<hr color="gray"/>
			</div>
			<!-- 显示基本信息 结束 -->
			<!-- 显示所有作业 开始 -->
			<div class="portlet light bordered">
				<div class="portlet-title">
					<div class="caption">
						<span class="caption-subject font-red-sunglo bold">作业发布情况</span>
						<span class="caption-helper">&nbsp;已发布</span>
						<span id="courseWorkAmount">0</span>
						<span class="caption-helper">次作业</span>
					</div>
				</div>
				<div class="portlet-body">
					<div class="rows">
						<div class="list-group" style="width:60%;margin:0 auto;">
							<div>
								<a href="javascript:;" class="list-group-item listHead" onclick="openAndClose(0);">
									<span>作业号：</span><span>***</span>
									<span>作业名：</span><span>***</span>
									|<i class="fa fa-angle-left" name="listIcon0"></i>
								</a>
								<div class="portlet light bordered listContent0" style="display:none;">
									<div class="portlet-body">
										<table class="table table-bordered">
											<tbody>
												<tr><td>发布时间</td><td>***</td></tr>
												<tr><td>截止时间</td><td>***</td></tr>
												<tr><td>作业描述</td><td>***</td></tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div>
								<a href="javascript:;" class="list-group-item listHead" onclick="openAndClose(1);">
									<span>作业号：</span><span>***</span>
									<span>作业名：</span><span>***</span>
									|<i class="fa fa-angle-left" name="listIcon1"></i>
								</a>
								<div class="portlet light bordered listContent1" style="display:none;">
									<div class="portlet-body">
										<table class="table table-bordered">
											<tbody>
												<tr><td>发布时间</td><td>***</td></tr>
												<tr><td>截止时间</td><td>***</td></tr>
												<tr><td>作业描述</td><td>***</td></tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr color="gray"/>
			</div>
			<!-- 显示所有作业  结束 -->
			<!-- 显示所有学生 开始 -->
			<div class="portlet light bordered">
				<div class="portlet-title">
					<div class="caption">
						<span class="caption-subject font-red-sunglo bold">所选学生信息</span>
						<span class="caption-helper">&nbsp;共</span>
						<span id="studentAmount">0</span>
						<span class="caption-helper">个学生</span>
					</div>
				</div>
				<div class="portlet-body">
					<table class="table">
						<tbody>
							<tr>
								<td><div class="Gridborder"><a class="studentGrid">1213883121<br/>老五</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883122<br/>裤比勒</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883123<br/>浪</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883124<br/>拉布达</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883125<br/>加尼夫利</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883126<br/>尼古拉斯</a></div></td>
							</tr>
							<tr>
								<td><div class="Gridborder"><a class="studentGrid">1213883121<br/>老五</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883122<br/>裤比勒</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883123<br/>浪</a></div></td>
								<td><div class="Gridborder"><a class="studentGrid">1213883124<br/>拉布达</a></div></td>
								
							</tr>
						</tbody>
					</table>
						
				</div>
				<div class="portlet-title">
					<ul class="pagination">
						<li><a href="javascript:;" title="上一页" onclick="jumpPrevPage();"><i class="fa fa-angle-left"></i></a></li>
						<li id="pageList"></li>
						<li id="pageURL" style="display:none;" name="cno">admin/lookCourseDetail</li>
						<li><a href="javascript:;" title="下一页" onclick="jumpNextPage();"><i class="fa fa-angle-right"></i></a></li>
					</ul>
				</div>
			</div>
			<!-- 显示所有学生  结束 -->
			<!-- 内容由此增加 -->
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

function changePar(){  /* 更改页面原始参数的函数  */
	var id1 = GetPar("page");
	var id2 = GetPar("cno");
	if(id1 != null){
		var nowpage = parseInt(id1);
		Page = nowpage;
		now = Page;
	}
	if(id2 != null){
		TheName = id2;
	}
	document.getElementById("courseNo").innerHTML = TheName;
	document.getElementById("courseNo2").innerHTML = TheName;
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
		var newNode=$('<tr><td>'+info[j].cno+'</td><td>'+info[j].tno+'</td><td><a href="admin/">'+info[j].cname+'</a></td><td>'+info[j].year+'</td><td>'+info[j].term+'</td><td>'+info[j].time+'</td><td>'+info[j].place+'</td><td>'+st+'</td><td><a class="edit" href="javascript:;">删除</a></td></tr>');
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
	//ajaxForMsg(Page,Rows,Cname);
});
</script>
</body>
</html>