<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xaut.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="admin" name="description"/>
<meta content="HeQin" name="author"/>
<title>管理员界面</title>
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

<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<div class="page-header-inner">
		<div class="page-logo">
			<a href="#">
				<img src="assets/admin/layout/img/logo-big.png" style="width:190px;height:45px;margin:0;" alt="XAUTlogo" class="logo-default"/>
			</a>
			<div class="menu-toggler sidebar-toggler hide"></div>
		</div>
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-default">
						4
						</span>
					</a>
					<ul class="dropdown-menu">
						<li class="external">
							<h3>
								<span class="bold">
									4
								</span>
									条新消息
							</h3>
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
						<li><a href="findMyself"><i class="icon-user"></i>个人信息 </a></li>
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
						<li class="active"><a href="#"><i class="icon-bar-chart"></i> 用户信息</a></li>
						<li><a href="lookCourse"><i class="icon-bar-chart"></i> 课程信息</a></li>
						<li><a href="lookWork"><i class="icon-bar-chart"></i> 作业信息</a></li>
						<li><a href="lookAnnounce"><i class="icon-bar-chart"></i> 公告信息</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:;">
						<i class="icon-screen-smartphone"></i>
						<span class="title">用户管理</span>
						<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li><a href="findstudent"><i class="icon-user-follow"></i>学生管理</a></li>
						<li><a href="findteacher"><i class="icon-user-follow"></i>教师管理</a></li>
						<li><a href="findadmin"><i class="icon-user-follow"></i>管理员管理</a></li>
					</ul>
				</li>
				<li class="last ">
					<a href="javascript:;">
						<i class="icon-user"></i>
						<span class="title">我的信息</span>
						<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li><a href="findMyself"><i class="icon-notebook"></i> 您的信息</a></li>
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
					<li><i class="fa fa-home"></i>系统使用详情<i class="fa fa-angle-right"></i></li>
					<li>用户信息</li>
				</ul>
			</div>
			<h3 class="page-title">用户信息 <small>查看所有用户</small></h3>
			<!-- END PAGE HEADER-->
			
			<!-- 显示总人数部分-开始 -->
			<div style="border-style:dashed;padding:25px 10px 5px 10px;border-color:gray;margin:5px 0 15px 0;">
				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat green-haze">
							<div class="visual"><i class="fa fa-shopping-cart"></i></div>
							<div class="details">
								<div id="adminCount" class="number">0</div>
								<div class="desc">管理员人数</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat blue-madison">
							<div class="visual"><i class="fa fa-comments"></i></div>
							<div class="details">
								<div id="teacherCount" class="number">0</div>
								<div class="desc">教师人数</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat red-intense">
							<div class="visual"><i class="fa fa-bar-chart-o"></i></div>
							<div class="details">
								<div id="studentCount" class="number">0</div>
								<div class="desc">学生人数</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat purple-plum">
							<div class="visual"><i class="fa fa-globe"></i></div>
							<div class="details">
								<div id="superAdminCount" class="number">0</div>
								<div class="desc">超级管理员人数</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 显示总人数部分-结束 -->
			<!-- 显示详细信息部分  开始 -->
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<div class="portlet light bordered">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-bar-chart font-green-haze"></i>
								<span class="caption-subject bold uppercase font-green-haze">学生用户信息统计</span>
							</div>
							<div class="tools">
								<a href="javascript:;" class="fullscreen" title="全屏"></a>
							</div> 
						</div>
						<div class="portlet-body">
							<div style="background-color:#fafafa;padding:2px 4px;">
								<div class="row static-info">
									<div class="col-md-6 col-sm-6 name">
										<h4> 学生用户人数： <span id="stuMsg1">0</span> 人</h4>
									</div>
								</div>
								<div class="row static-info">
									<div class="col-md-12 col-sm-12" style="font-size:12px;color:gray;">
										<div class="col-md-2 col-sm-12 name">其中：</div>
										<div class="col-md-5 col-sm-12 name">账号正常： 
											<span id="stuMsg2">0</span> 人
										</div>
										<div class="col-md-5 col-sm-12 name">账号冻结： 
											<span id="stuMsg3">0</span> 人
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div id="chart_my_1" class="chart" style="overflow: hidden; text-align: left;"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-12">
					<div class="portlet light bordered">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-bar-chart font-green-haze"></i>
								<span class="caption-subject bold uppercase font-green-haze">教师用户信息统计</span>
							</div>
							<div class="tools"><a href="javascript:;" class="fullscreen" title="全屏"></a></div>
						</div>
						<div class="portlet-body">
							<div style="background-color:#fafafa;padding:2px 4px;">
								<div class="row static-info">
									<div class="col-md-6 col-sm-6 name">
										<h4>教师用户人数： <span id="teaMsg1">0</span> 人</h4>
									</div>
								</div>
								<div class="row static-info">
									<div class="col-md-12 col-sm-12" style="font-size:12px;color:gray;">
										<div class="col-md-2 col-sm-12 name">其中：</div>
										<div class="col-md-5 col-sm-12 name">账号正常： 
											<span id="teaMsg2">0</span> 人
										</div>
										<div class="col-md-5 col-sm-12 name">账号冻结： 
											<span id="teaMsg3">0</span> 人
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div id="chart_my_2" class="chart" style="overflow: hidden; text-align: left;"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- 图表内容附加处 -->
			</div>
			<!-- 显示详细信息部分  结束 -->
			
			<!-- 内容附加处 -->
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
<script src="assets/global/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="assets/global/plugins/flot/jquery.flot.stack.min.js"></script>
<script src="assets/global/plugins/flot/jquery.flot.crosshair.min.js"></script>
<script src="assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-daterangepicker/moment.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<script src="assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/pie.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/radar.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/themes/light.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amcharts/themes/chalk.js" type="text/javascript"></script>
<script src="assets/global/plugins/amcharts/amstockcharts/amstock.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/index.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/charts-amcharts.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->


<!-- 获取json数据的代码  开始 -->
<script>
var ajaxForMsg = function () {
    $.ajax({
        url:'/HomeWorkWeb/admin/lookIndexMsg',
        type:'GET',
        async:false,
        traditional : true,
        data:{},
        dataType : 'JSON',
        beforeSend: function () {
            console.log("正在进行，请稍候");
        },
        success: function (data) {
        	changeNum(data.data);
        	changeMsg(data.data);
        	
        	/* 更改两图表数据，其js代码路径为："assets/admin/pages/scripts/charts-amcharts.js" */
 			ChartsAmcharts.init(data.data.studentInfo,data.data.teacherInfo);
        }
    })
}

/* 更改人数信息显示 */
function changeNum(info){
	var num = document.getElementById("adminCount");//更改管理员人数显示
	num.innerHTML = info.adminInfo.adminCount;
	num = document.getElementById("studentCount");//更改学生人数显示
	num.innerHTML = info.studentInfo.studentCount;
	num = document.getElementById("teacherCount");//更改教师人数显示
	num.innerHTML = info.teacherInfo.teacherCount;
	num = document.getElementById("superAdminCount");//更改超级管理员人数显示
	num.innerHTML = info.superAdminInfo.superAdminCount;
}

/* 更改学生用户与教师用户的信息统计  */
function changeMsg(info){
	var num = document.getElementById("stuMsg1");
	num.innerHTML = info.studentInfo.studentCount;
	num = document.getElementById("stuMsg2");
	num.innerHTML = info.studentInfo.unLocked;
	num = document.getElementById("stuMsg3");
	num.innerHTML = info.studentInfo.locked;
	num = document.getElementById("teaMsg1");
	num.innerHTML = info.teacherInfo.teacherCount;
	num = document.getElementById("teaMsg2");
	num.innerHTML = info.teacherInfo.unLocked;
	num = document.getElementById("teaMsg3");
	num.innerHTML = info.teacherInfo.locked;
}

</script>
<!-- 获取json数据的代码  结束 -->


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
   ajaxForMsg();
});
</script>


</body>
</html>