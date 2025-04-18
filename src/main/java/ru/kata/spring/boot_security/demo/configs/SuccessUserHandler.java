package ru.kata.spring.boot_security.demo.configs;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final String ROLE_USER = "ROLE_USER";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains(ROLE_ADMIN)) {
            response.sendRedirect("/admin/user-list");
        } else if (roles.contains(ROLE_USER)) {
            response.sendRedirect("/user/user-page");
        } else {
            response.sendRedirect("/login?error=unauthorized");
            System.out.println("Error: Unauthorized role");
        }

        System.out.println("User " + authentication.getName() + " logged in with roles: " + roles);
    }
}