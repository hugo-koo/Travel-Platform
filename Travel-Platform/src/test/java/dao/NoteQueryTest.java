package dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.service.impl.NoteService;

/**
* @author 古学懂_Victor
*/
class NoteQueryTest {

	@Test
	void testALL() {
		System.out.println("JUnit Test: Note query all");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		INoteService noteService = (NoteService) ctx.getBean("noteService");
		List<Note> notes = noteService.listAllNotes();
		System.out.println(notes.get(0).getNoteDtl().getNoteHeader());
	}
	@Test
	void testAuthor() {
		System.out.println("JUnit Test: Note query author");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		INoteService noteService = (NoteService) ctx.getBean("noteService");
		List<Note> notes = noteService.listNotesBy(INoteService.AUTHOR, 1000);
		System.out.println(notes.get(0).getNoteDtl().getNoteHeader());
	}

}
