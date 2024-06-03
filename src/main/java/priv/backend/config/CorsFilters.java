package priv.backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 自定义跨域过滤器，解决跨域问题
 */
@Component
public class CorsFilters extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain) throws IOException, ServletException {
        /* 添加跨域请求头 */
        this.addCorsHeader(request, response);
        /* 处理预检请求 */
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        /* 放行所有请求 */
        chain.doFilter(request, response);
    }

    /**
     * 添加跨域响应头
     */
    public void addCorsHeader(HttpServletRequest request,
                              HttpServletResponse response) {
        /* 允许所有来源的跨域请求 */
        response.addHeader("Access-Control-Allow-Origin", "*");
        /* 添加允许请求的方法 */
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        /* 配置允许的请求头 */
        response.addHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With");
    }
}
