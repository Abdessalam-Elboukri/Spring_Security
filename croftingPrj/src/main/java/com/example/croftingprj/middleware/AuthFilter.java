package com.example.croftingprj.middleware;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "auth", urlPatterns = {"/product/new","/product/all"})

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
            RequestDispatcher dispatcher;
            HttpSession session = request.getSession();
            if (session != null) {
                System.out.println(session.getAttribute("STOCK"));
                if (session.getAttribute("STOCK") == null ){
                    response.sendRedirect("/stock/login");
                    System.out.println("====================================================");

                    return;
                }
            }
            else {
                request.setAttribute("error", "Session timed out!");
                dispatcher = request.getRequestDispatcher("login.html");
                dispatcher.forward(request, response);
                return;
        }
        filterChain.doFilter(request,response);
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
