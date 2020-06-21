package cn.edu.bitzh.tp.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie CRUD工具
 * 
 * @author 古学懂_Victor
 * @date 2020年6月19日
 */
public class CookieUtil {
	/**
	 * 添加cookie
	 * 
	 * @author 古学懂_Victor
	 * @param expiry 保留时间（秒）
	 */
	public Cookie addCookie(HttpServletResponse response, String name, String value, int expiry) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
		return cookie;
	}

	/** 获取cookies */
	public Cookie[] listCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		return cookies;
	}

	/** 获取cookie */
	public Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
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
