package kr.or.ddit.jstl;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LocaleSelectWrapper extends HttpServletRequestWrapper{
	

	private Map<String, String[]> map; // 다른 메서드에서 참조해야되서?

	public LocaleSelectWrapper(HttpServletRequest request) {
		super(request);
		
		// 기존 request 객체의 파라미터 map을 복사
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		// locale 파라미터는 확인하고 없으면 등록
		String[] locale = map.get("locale");
		
		// locale 파라미터가 null 혹은 whiteSapce인 경우 --> 기본값으로 설정
		if(locale==null || locale[0].equals(""))
			map.put("locale",new String[]{"en"});
	}

	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values!=null)
			return values[0];
		else
			return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}
}