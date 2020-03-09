package cn.eight.purcharseforward.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//过滤的目标资源
@WebFilter("/houtai/main.html/")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        //判断依据：session中是否有用户名,参数为false时，如果没有也不会自动创建
        HttpSession session = request.getSession(false);
        if (session==null||session.getAttribute("user")==null){
            //该用户未登陆过，重定向到当前请求的根目录
            response.sendRedirect(request.getContextPath());
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
