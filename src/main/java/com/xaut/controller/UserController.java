package com.xaut.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xaut.entity.User;

@Controller
public class UserController {
	
	/**
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
    public String toLogin() {
		/** 此处用来判断是否已经登录
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated() || subject.isRemembered()) {
			if(subject.hasRole("admin") || subject.hasRole("superadmin")) {
	        	return "admin/index";
	        } else if(subject.hasRole("student")) {
	        	return "student/index";
	        } else if(subject.hasRole("teacher")) {
	        	return "teacher/index";
	        }
		}
		*/
		
		return "login";
	}
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String userLogin(User user,Model model) {
        Subject subject = SecurityUtils.getSubject();
        
     	//身份验证
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
        try {
        	
        	//token.setRememberMe(user.isRememberMe());
            subject.login(token);
        } catch (UnknownAccountException e) {
        	model.addAttribute("error", "账号不存在");
        	return "login";
        } catch (IncorrectCredentialsException e) {
        	model.addAttribute("error", "用户名/密码错误");
        	return "login";
        } catch (LockedAccountException e) {
        	model.addAttribute("error", "账号被锁定");
        	return "login";
        } catch (Exception e) {
        	model.addAttribute("error", "其他异常信息");
        	return "login";
        }
        
        if(subject.hasRole("admin") || subject.hasRole("superadmin")) { //具有管理员或超级管理员身份
        	return "admin/index";
        } else if(subject.hasRole("student")) { //判断具有学生身份
        	return "student/index";
        } else if(subject.hasRole("teacher")) {	//判断具有教师身份
        	return "teacher/index";
        }
        //没有任何角色
        return "redirect:nopermission.jsp";
    }
    
	/**
	 * 用户增加
	 */
    @RequestMapping(value="/add")
    @ResponseBody
    public String add() throws  Exception{
        return "add users";
    }
    
    /**
	 * 用户删除
	 */
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    @RequiresPermissions(value="users:delete")
    @ResponseBody
    public String delete() throws  Exception{
        return "delete users";
    }
    
    /**
     * function：用户退出登录
     * @return
     */
    @RequestMapping(value="/logout",method=RequestMethod.GET)  
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {  
            subject.logout();  
        }
        System.out.println("您已退出登录");
        return "login";
    }
}