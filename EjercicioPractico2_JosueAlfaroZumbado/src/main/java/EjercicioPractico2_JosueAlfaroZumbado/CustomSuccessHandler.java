/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/usuario/lista");
        } else if (roles.contains("ROLE_ORGANIZADOR")) {
            response.sendRedirect("/evento/lista");
        } else if (roles.contains("ROLE_CLIENTE")) {
            response.sendRedirect("/evento/lista");
        } else {
            response.sendRedirect("/");
        }
    }
}
