package kr.or.ddit.jstl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LocaleSelectFilter
 */
@WebFilter("/localeSelect")
public class LocaleSelectFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LocaleSelectFilter.class);

	public LocaleSelectFilter() {
		
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전처리
		HttpServletRequest req = (HttpServletRequest)request;		
		
		// 후처리
		
		logger.debug(req.getRequestURI() + " : LocaleSelectFilter doFilter");
		
		// lock이 걸려있는 map 객체라 임의 등록이 불가능하다.
		// Map<String, String[]> requestMap = req.getParameterMap(); // *
		// requestMap.put("locale", new String[]{"valueByFilter"}); // *
		LocaleSelectWrapper localeSelectWrapper = new LocaleSelectWrapper(req); // *
		localeSelectWrapper.getParameter("name");
		
		// filter / servlet 요청처리
		// chain.doFilter(request, response);
		chain.doFilter(localeSelectWrapper, response);
		
		// 후처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}