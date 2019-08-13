<%--
	功能：实现WEB-INF下jsp/html页面之间直接的跳转,而不使用Controller
	参数：要跳转的jsp/html的路径(从WEB-INF级开始)
	作者：吴小华
	时间：2019-8-13 晚
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String gotoUrl = request.getParameter("gotoUrl");
    request.getRequestDispatcher(gotoUrl).forward(request,response); //转发时：request中的数据也会传递过去
%>