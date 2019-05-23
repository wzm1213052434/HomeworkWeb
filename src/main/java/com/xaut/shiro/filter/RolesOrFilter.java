package com.xaut.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class RolesOrFilter extends AuthorizationFilter {

	/**
	 * 自定义满足其中任一角色的filter
	 */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest,ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        String[] roles = (String[]) o;
        
        if (roles == null || roles.length == 0) {
            return true;
        }
        for (String role : roles) {
            if (subject.hasRole(role)) {
                return true;
            }
        }
        
        return false;
    }
}