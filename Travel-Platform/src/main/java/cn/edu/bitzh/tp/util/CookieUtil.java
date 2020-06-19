package cn.edu.bitzh.tp.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Cookie CRUD工具
 * 
 * @author 古学懂_Victor
 * @date 2020年6月19日
 */
public class CookieUtil {
	/** 添加cookie */
	public Cookie addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60);
		return cookie;
	}

	/** 获取cookies */
	public Cookie[] getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		return cookies;
	}

	/** 删除cookie */
	public Cookie delCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					return cookie;
				}
			}
		}
		return null;
	}

	/** 修改cookie */
	public Cookie mdfCookie(HttpServletRequest request, String name, String value, int expiry) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					cookie.setValue(value);
					cookie.setMaxAge(expiry);
					return cookie;
				}
			}
		}
		return null;
	}
}
