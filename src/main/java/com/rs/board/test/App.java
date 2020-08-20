package com.rs.board.test;



import com.rs.board.test.util.Session;

import java.io.IOException;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@SpringBootApplication
@EnableJpaAuditing
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
//    @Bean
//    public AuditorAware<String> auditorProvider() {
//      return () -> Optional.of("사용자이름.. 실무에서는 세션이나 스프링 시큐리티 로그인 정보 이용"); }
//    
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            ServletRequestAttributes attr
                = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            String currentUser = (String)attr.getRequest().getSession().getAttribute(Session.SESSION_ID);

            if(currentUser != null) {
                return currentUser;
            }else {
            	return "Anonymous";
            }
                
        };
    };
    
}