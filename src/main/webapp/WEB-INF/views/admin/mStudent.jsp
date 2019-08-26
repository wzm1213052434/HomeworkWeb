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
<link href="assets/golbal/plugins/select2/select2.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<link href="assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
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
						<li><a href="admin/myself"><i class="icon-user"></i>个人信息 </a></li>
						<li><a href="logout"><i class="icon-key"></i>退出登入</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
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
				<li>
					<a href="javascript:;">
						<i class="icon-home"></i>
						<span class="title">系统使用详情</span>
						<span class="selected"></span>
						<span class="arrow open"></span>
					</a>
					<ul class="sub-menu	">
						<li><a href="admin/index"><i class="icon-bar-chart"></i> 用户信息</a></li>
						<li><a href="admin/lookCourse"><i class="icon-bar-chart"></i> 课程信息</a></li>
						<li><a href="admin/lookWork"><i class="icon-bar-chart"></i> 作业信息</a></li>
						<li><a href="admin/lookAnnounce"><i class="icon-bar-chart"></i> 公告信息</a></li>
					</ul>
				</li>
				<li class="start active open">
					<a href="javascript:;">
						<i class="icon-screen-smartphone"></i>
						<span class="title">用户管理</span>
						<span class="arrow"></span>
					</a>
					<ul class="sub-menu">
						<li class="active"><a href="javascript:;"><i class="icon-user-follow"></i>学生管理</a></li>
						<li><a href="admin/mTeacher"><i class="icon-user-follow"></i>教师管理</a></li>
						<li><a href="admin/mAdmin"><i class="icon-user-follow"></i>管理员管理</a></li>
					</ul>
				</li>
				<li class="last ">
					<a href="javascript:;">
						<i class="icon-user"></i>
						<span class="title">我的信息</span>
						<span class="arrow "></span>
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
					<li><i class="fa fa-home"></i>用户管理<i class="fa fa-angle-right"></i></li>
					<li>学生管理</li>
				</ul>
			</div>
			<h3 class="page-title">
				学生管理 <small>查看所有学生用户的信息</small>
			</h3>
			<!-- END PAGE HEADER-->
			<!-- 信息表格 开始 -->
			<div class="portlet box green">
				<div class="portlet-title" style="vertical-align:middle;position:relative;">
					<div class="caption" style="position:absolute;top:30%;"><i class="fa fa-comments"></i>学生用户信息</div>
					<div class="tools" style="height:17px;position:absolute;top:30%;right:2%;overflow:hidden;">
						<a href="javascript:;" class="collapse" title="折叠"></a>
						<a href="javascript:;" class="reload" title="刷新"></a>
					</div>
				</div>
				<div class="portlet-body">
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div id="sample_editable_1_filter" class="dataTables_filter">
								<input type="search" class="form-control input-big input-inline" placeholder="按学号查询" aria-controls="sample_editable_1">
								<button type="submit" class="form-control input-inline">查询</button>
							</div>
						</div>
						<div class="col-md-6 col-sm-6">	
							<div class="pull-right">
								<a class="edit" data-toggle="modal" href="#large2"><button class="form-control input-inline">增加学生</button></a>
							</div>
						</div>
					</div>
					<div id="able_1_wrapper" class="dataTables_wrapper no-footer">
						<div class="table-scrollable">
							<table class="table table-striped table-hover table-bordered dataTable no-footer" id="able_1" style="text-align:center;">
								<thead>
									<tr role="row">
										<th class="sorting_asc" tabindex="0" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;"></th>
										<th class="sorting" tabindex="1" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;">
									 		学号
										</th>
										<th class="sorting" tabindex="0" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;">
											姓名
										</th>
										<th class="sorting" tabindex="2" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;">
							 				专业
										</th>
										<th class="sorting" tabindex="2" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;">
							 				邮箱
										</th>
										<th class="sorting" tabindex="0" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;">
											账号密码
										</th>
										<th class="sorting" tabindex="3" aria-controls="sample_editable_1" rowspan="1" colspan="1" style="text-align:center;">
							 				使用状态
										</th>
										<th class="sorting" tabindex="4" aria-controls="sample_editable_1" rowspan="1" colspan="3" style="text-align:center;">
							 				可用操作
										</th>
									</tr>
								</thead>
								<tbody>
									<tr role="row" class="odd">
										<td class="sorting_1">1</td>
										<td>3160661515</td>
										<td>小兵</td>
										<td>计算机科学与技术</td>
										<td>无</td>
										<td>123456</td>
										<td>
											<span class="label label-sm label-success">
												 正常
											</span>
										</td>
										<td><a class="edit" data-toggle="modal" href="#large">更改信息</a></td>
										<td><a class="edit" href="javascript:;">冻结/解冻</a></td>
										<td><a class="edit" href="javascript:;">删除</a></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col-md-4 col-sm-5 pull-right">
								<div class="dataTables_paginate paging_bootstrap_full_number" id="sample_1_paginate">
									<ul class="pagination">
										<li class="prev disabled">
											<a href="#" title="Prev"><i class="fa fa-angle-left"></i></a>
										</li>
										<li><a href="#">first</a></li>
										<li class="active"><a>---</a></li>
										<li class="active"><a>now</a></li>
										<li class="active"><a>---</a></li>
										<li><a href="#">last</a></li>
										<li class="next">
											<a href="#" title="Next"><i class="fa fa-angle-right"></i></a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 信息表格  结束 -->
			<!-- 修改信息模态框1   开始-->
            <div id="large2" class="modal fade" tabindex="-1" data-width="850">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h3 class="modal-title"><i class="fa fa-gift"></i>增加学生</h3>
                </div>
            	<div class="modal-body">
            		<form role="form" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">学号</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm" onblur="checkSno(this);">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">姓名</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">专业</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">邮箱</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">密码</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-11 col-md-offset-1 col-md-11">
								<button type="button" data-dismiss="modal" class="btn default">取消</button>
								<button type="submit" class="btn green">提交</button>
				            </div>
						</div>
					</form>
            	</div>
            </div>
            <!-- 修改信息模态框1  结束-->	
            <!-- 修改信息模态框2  开始-->
            <div id="large" class="modal fade" tabindex="-1" data-width="850">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h3 class="modal-title"><i class="fa fa-gift"></i>修改信息</h3>
                </div>
            	<div class="modal-body">
            		<form role="form" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">学号</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm" onblur="checkSno(this);">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">姓名</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">专业</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">邮箱</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 col-md-1 control-label">密码</label>
							<div class="col-sm-11 col-md-11">
								<input type="text" class="form-control" placeholder="input-sm">
				            </div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-11 col-md-offset-1 col-md-11">
								<button type="button" data-dismiss="modal" class="btn default">取消</button>
								<button type="submit" class="btn green">提交</button>
				            </div>
						</div>
					</form>
            	</div>
            </div>
            <!-- 修改信息模态框2  结束-->	
			
			<!-- 老刘的分界线 -->
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
<script src="assets/admin/pages/scripts/table-editable.js"></script>
<script src="assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
<script src="assets/admin/pages/scripts/ui-extended-modals.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
	Metronic.init(); // init metronic core componets
	Layout.init(); // init layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	UIExtendedModals.init();//模态框函数
	Index.init();   
	Index.initJQVMAP(); // init index page's custom scripts
	Index.initCalendar(); // init index page's custom scripts
	Index.initCharts(); // init index page's custom scripts
	Index.initDashboardDaterange();
	Index.initChat();
	Index.initMiniCharts();
	Tasks.initDashboardWidget();
});

function checkSno(val){  /* 检查学生学号是否为十位的函数  */
	var str = val.value;
	if(str.length != 10)
		alert("学号需为十位数字");
}
</script>
</body>
</html>