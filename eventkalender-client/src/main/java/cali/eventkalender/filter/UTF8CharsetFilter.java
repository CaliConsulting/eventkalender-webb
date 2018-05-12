package cali.eventkalender.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UTF8CharsetFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UTF8CharsetFilter.class);

    public UTF8CharsetFilter() {
        LOGGER.info("Filter created; requests and responses will use UTF-8 as default character encoding");
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void destroy() {

    }
}