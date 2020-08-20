package com.rs.board.test.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rs.board.test.entity.Post;
import com.rs.board.test.repository.PostRepository;
import com.rs.board.test.util.Session;

@Component
public class PostAuthInterceptor implements HandlerInterceptor {

    @Autowired
    PostRepository postRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String httpMethod = request.getMethod();

        if(httpMethod.equals("UPDATE") || httpMethod.equals("DELETE")) {
            String sessionItem = (String)request.getSession().getAttribute(Session.SESSION_ID);
            Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            Integer id = Integer.parseInt((String)pathVariables.get("id"));

            Post post = postRepository.findOne(id);
            String postWriter = post.getCreatedBy();

            if(!postWriter.equals(sessionItem)){
                response.getOutputStream().println("NOT AUTHORIZE!!");
                return false;
            }
        }

        return true;
    }

    

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}