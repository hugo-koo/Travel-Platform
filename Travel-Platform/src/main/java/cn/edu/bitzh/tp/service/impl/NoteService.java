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
	public Note getNoteById(int id) {
		return nd.getNoteById(id);
	}

	@Override
	public int insertNote(Note note) {
		return nd.insertNote(note);
	}

	@Override
	public int deleteNote(int id) {
		return nd.deleteNote(id);
	}

	@Override
	public boolean updateNote(Note note) {
		return nd.updateNote(note);
	}

	@Override
	public List<Note> listNotesBy(int type, Object value) {
		return nd.listNotesBy(type, value);
	}

	@Override
	public List<Note> listAllNotes() {
		return nd.listNotesBy(ALL, null);
	}

}
