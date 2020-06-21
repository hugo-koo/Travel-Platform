package cn.edu.bitzh.tp.service.impl;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bitzh.tp.dao.INoteDao;
import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.util.CookieUtil;

/**
 * @author 古学懂_Victor
 */
@Service
public class NoteService implements INoteService {
	@Autowired
	INoteDao nd;

	@Override
	public Note get(int id) {
		return nd.get(id);
	}

	@Override
	public int insert(Note note) {
		return nd.insert(note);
	}

	@Override
	public boolean delete(int id) {
		return nd.delete(id);
	}

	@Override
	public boolean update(Note note) {
		return nd.update(note);
	}

	@Override
	public List<Note> listBy(int type, Object value) {
		return nd.listBy(type, value);
	}

	@Override
	public List<Note> listAllNotes() {
		return nd.listBy(ALL, null);
	}

	@Override
	public List<Note> list() {
		return nd.list();
	}

	@Override
	public List<Note> listHotestNotes() {
		return nd.listHotestNotes();
	}

	@Override
	public int like(HttpServletRequest request, HttpServletResponse response, int id) {
		System.out.println("like" + id);
		int type = INoteDao.LIKE;
		Cookie cookie;
		CookieUtil cu = new CookieUtil();
		boolean hasLiked = false;
		cookie = cu.getCookie(request, "LIKE");
		String[] likes = { "" };
		String cookieVal = "";
		if (cookie != null) {
			cookieVal = cookie.getValue();
			likes = cookieVal.split("\\|");
			for (String like : likes) {
				if (like.equals(Integer.toString(id))) {
					cookieVal = cookieVal.replaceAll(Integer.toString(id)+"\\|", "");
					hasLiked = true;
				}
			}
		}
		if (hasLiked) {
			System.out.println("UNLIKE ");
			cu.addCookie(response, "LIKE", cookieVal, 60*60*24*30);
			type = INoteDao.UNLIKE;
		} else {
			System.out.println("LIKE ");
			cu.addCookie(response, "LIKE", cookieVal + Integer.toString(id) + "|", 60*60*24*30);
			type = INoteDao.LIKE;
		}
		return nd.like(id, type);
	}

}
