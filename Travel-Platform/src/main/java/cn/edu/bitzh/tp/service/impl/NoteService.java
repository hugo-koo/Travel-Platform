package cn.edu.bitzh.tp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.bitzh.tp.dao.INoteDao;
import cn.edu.bitzh.tp.dao.impl.NoteDao;
import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.service.INoteService;

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
		return nd.insertOrUpdate(note);
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
	
	public List<Note> listHotestNotes(){
		return nd.listHotestNotes();
	}

}
