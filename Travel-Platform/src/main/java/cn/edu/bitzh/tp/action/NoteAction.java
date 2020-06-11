package cn.edu.bitzh.tp.action;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.service.impl.NoteService;

/**
 * @author 古学懂_Victor
 * @date 2020
 */
public class NoteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	private INoteService ns = (NoteService) applicationContext.getBean("noteService");
	private Note note;
	private int noteId = 1000;

	public String get() {
		final Note note = ns.get(this.noteId);
		//权限判断
//		if (note.getNotePermission().equals("public")) {
		this.note = note;
//		} else {
//			return ActionSupport.NONE;
//		}
		return ActionSupport.SUCCESS;
	}

	public String insert() {
		this.note.setNotePostDate(new Date());
		this.note.setNoteAuthor(1000);
		int id = this.ns.insert(this.note);
		if (id != 0) {
			this.noteId = id;
		} else {
			return ActionSupport.INPUT;
		}
		return ActionSupport.SUCCESS;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

}
