<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xaut.entity.User"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>教师端 | 课程</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <meta content="教师端课程页面" name="description" />
    <meta content="xiaoMing" name="author" />
    <link
      href="assets/global/plugins/font-awesome/css/font-awesome.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="assets/global/plugins/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link href="assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet"
  type="text/css" />
    <link href="assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />
    <link
      href="assets/global/css/components.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="assets/admin/layout2/css/layout.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      id="style_color"
      href="assets/admin/layout2/css/themes/default.css"
      rel="stylesheet"
      type="text/css"
    />
    <link rel="shortcut icon" href="assets/global/img/webIcon.ico" />
    <style>
      .fileinput-button {
        position: relative;
        display: inline-block;
        overflow: hidden;
      }
    
      .fileinput-button input {
        position: absolute;
        right: 0px;
        top: 0px;
        opacity: 0;
        -ms-filter: 'alpha(opacity=0)';
        font-size: 200px;
      }
    </style>
  </head>
  <body
    class="page-boxed page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo "
  >
    <!-- BEGIN HEADER -->
    <header class="page-header navbar navbar-fixed-top">
      <!-- BEGIN HEADER INNER -->
      <div class="page-header-inner container">
        <!-- BEGIN LOGO -->
        <div class="page-logo">
          <a href="#">
            <img
              src="assets/admin/layout/img/logo-school.png"
			  alt="logo"
			  class="logo-default"
			  style="height:4em;width: 10em;margin-top: -0.1em;"
            />
          </a>
          <div class="menu-toggler sidebar-toggler ">
            <!-- 侧边栏收缩 -->
          </div>
        </div>
        <!-- END LOGO -->
        <!-- BEGIN PAGE TOP -->
        <div class="page-top">
          <!-- BEGIN header导航栏 -->
          <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
              <!-- BEGIN 消息提示悬浮框 -->
              <li
                class="dropdown dropdown-extended dropdown-notification"
                id="header_notification_bar"
              >
                <a
                  href="#"
                  class="dropdown-toggle"
                  data-toggle="dropdown"
                  data-hover="dropdown"
                  data-close-others="true"
                >
                  <i class="icon-bell"></i>
                  <span class="badge badge-danger"> 1 </span>
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <ul
                      class="dropdown-menu-list scroller"
                      style="height: 250px;"
                    >
                      <li>
                        <a href="#">
                          <span class="label label-sm label-icon label-success">
                            <i class="fa fa-plus"></i>
                          </span>
                          New user registered.
                          <span class="time"> Just now </span>
                        </a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
              <!-- END 消息提示悬浮框 -->
              <!-- BEGIN 用户信息悬浮框 -->
              <li class="dropdown dropdown-user">
                <a
                  href="#"
                  class="dropdown-toggle"
                  data-toggle="dropdown"
                  data-hover="dropdown"
                  data-close-others="true"
                >
                  <img
                    alt=""
                    class="img-circle hide1"
                    src="assets/global/img/user.png"
                  />
                  <span class="username username-hide-on-mobile">
                  	<%User user=(User)request.getSession().getAttribute("user"); %>
                  	<%=user.getUserName()%>
                  </span>
                  <i class="fa fa-angle-down"></i>
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <a href="">
                      <i class="icon-user"></i> My Profile
                    </a>
                  </li>
                </ul>
              </li>
              <!-- END 用户信息悬浮框 -->
            </ul>
          </div>
          <!-- END header导航栏 -->
        </div>
        <!-- END PAGE TOP -->
      </div>
      <!-- END HEADER INNER -->
    </header>
    <!-- END HEADER -->
    <div class="clearfix"></div>
    <div class="container">
      <!-- BEGIN 页面主内容容器 -->
      <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar-wrapper">
          <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN 侧边菜单栏 -->
            <ul
              class="page-sidebar-menu page-sidebar-menu-hover-submenu page-sidebar-menu-closed"
              data-auto-scroll="true"
              data-slide-speed="200"
            >
              <li class="start ">
                <a href="#" >
                  <i class="icon-book-open"></i>
                  <span class="title">课程</span>
                </a>
              </li>
              <li>
                <a href="javascript:;">
                  <i class="icon-note"></i>
                  <span class="title">发布作业</span>
                  <span class="arrow "></span>
                </a>
              </li>
              <li>
                <a href="javascript:;">
                  <i class="icon-check"></i>
                  <span class="title">批阅作业</span>
                  <span class="arrow "></span>
                </a>
			  </li>
			  <li>
				<a href="javascript:;">
					<i class="icon-bubbles"></i>
					<span class="title">发布公告</span>
					<span class="arrow "></span>
				</a>
			  </li>
            <!-- END 侧边菜单栏 -->
          </div>
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
          <div class="page-content">
            <!-- BEGIN 页面小头-->
            <div class="page-bar">
              <ul class="page-breadcrumb">
                <li>
                  <i class="fa fa-home"></i>
                  <a href="#">课程</a>
                  <i class="fa fa-angle-right"></i>
                </li>
              </ul>
            </div>
            <!-- END 页面小头-->
            <!-- 主页面内容-->
            <div class="portlet light">
              <div class="portlet-title">
                <div class="caption">
                  <i class="fa fa-cogs font-green-sharp"></i>
                  <span class="caption-subject font-green-sharp bold uppercase">课程</span>
                </div>
                <div class="tools">
                  <a class="btn btn-sm green" data-toggle="modal" href="#large">
                    新增课程 <i class="fa fa-edit"></i>
                  </a>
                </div>
              </div>
              <div class="portlet-body">
                <div class="list-group">
                  <a href="#" class="list-group-item list-group-item-info">
                    info
                  </a>
                </div>
              </div>
            </div>
            <!--新增课程模态框-->
            <div id="large" class="modal fade"  tabindex="-1" data-focus-on="input:first"  data-width="850">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h3 class="modal-title"><strong>新增课程</strong></h3>
              </div>
              <div class="modal-body">
                <div class="form-group">
                  <label for="courseName"><strong>课程名称</strong></label>
                  <input id="courseName" class="form-control" type="text" data-tabindex="1">
                </div>
                <div class="form-group">
                <span class="btn btn-success fileinput-button">
                  <span>学生名单上传</span>
                  <input type="file" accept=".xls" id="file">
                </span>
                  <div class="showFileName"></div>
                  <div class="fileerrorTip"></div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
                <button type="button" id="upload" class="btn btn-primary">提交</button>
              </div>
            </div>
            <!--新增课程模态框结束-->
            <!-- END 主页面内容-->
          </div>
        </div>
        <!-- END CONTENT -->
      </div>
      <!-- END 页面主内容容器 -->
      <!-- BEGIN 底部栏 -->
      <div class="page-footer">
        <div class="page-footer-inner">
          2019 &copy; 西安理工大学作业提交系统.
        </div>
      </div>
      <!-- END 底部栏 -->
    </div>
    <script
      src="assets/global/plugins/jquery-1.11.0.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/jquery-migrate-1.2.1.min.js"
      type="text/javascript"
    ></script>
    <!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
    <script
      src="assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/bootstrap/js/bootstrap.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/jquery.blockui.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/jquery.cokie.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/uniform/jquery.uniform.min.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
      type="text/javascript"
    ></script>
    <!-- END CORE PLUGINS -->
    <!-- BEGIN PAGE LEVEL PLUGINS 就是一些页面特有部件的js-->
    <script
      type="text/javascript"
      src="assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js"
    ></script>
    <script src="assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
    <script src="assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
    <script
      src="assets/global/scripts/metronic.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/admin/layout2/scripts/layout.js"
      type="text/javascript"
    ></script>
    <script
      src="assets/admin/layout2/scripts/demo.js"
      type="text/javascript"
    ></script>
    <script src="assets/admin/pages/scripts/ui-extended-modals.js"></script>
    <!-- END PAGE LEVEL SCRIPTS -->
    <script>
      //文件上传函数
      var fileUpload = function () {
        $("#upload").click(function(){
          var formData = new FormData();
          var name = $("#file").val();
          formData.append("file", $("#file")[0].files[0]);
          formData.append("name", name);
          $.ajax({
            url: 'teacher/upload',
            type: 'POST',
            async: false,
            data: formData,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            beforeSend: function () {
              console.log("正在进行，请稍候");
            },
            success: function (responseStr) {
              if (responseStr == "01") {
                alert("导入成功");
              } else {
                alert("导入失败");
              }
            }
          });
        })
        }
      //判断上传文件类型
      var judgeTheType=function(){
        $(".fileinput-button").on("change", "input[type='file']", function () {
          var filePath = $(this).val();
          if (filePath.indexOf("xls") != -1) {
            $(".fileerrorTip").html("").hide();
            var arr = filePath.split('\\');
            var fileName = arr[arr.length - 1];
            $(".showFileName").html("<strong>" + fileName + "</strong>");
          } else {
            $(".showFileName").html("");
            $(".fileerrorTip").html("<strong>您上传文件类型有误！</strong>").show();
            return false
          }
        });
      }
      
      jQuery(document).ready(function() {
        // initiate layout and plugins
        Metronic.init(); //核心组件初始化
        Layout.init(); //布局初始化
        Demo.init(); // init demo features
        UIExtendedModals.init();//模态框函数
        judgeTheType();
        fileUpload();
      });
    </script>
    <!-- END JAVASCRIPTS -->
  </body>
  <!-- END BODY -->
</html>
