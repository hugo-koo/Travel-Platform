package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.model.NoteDtl;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.service.IRegionService;
import cn.edu.bitzh.tp.service.impl.NoteService;
import cn.edu.bitzh.tp.service.impl.RegionService;

/**
 * @author 古学懂_Victor
 */
class SpringSessionTest {
	Session session = null;
	Transaction transaction = null;

	@Test
	void testQuery() {
		System.out.println("JUnit Test: Hibernate+Spring Session Test Query");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		INoteService noteService = (NoteService) ctx.getBean("noteService");
		Note note = null;
		note = noteService.get(1085);
		System.out.println(note.getNoteDtl().getNoteHeader());
	}

	@Test
	void testInsert() {
		System.out.println("JUnit Test: Hibernate+Spring Session Test Insert");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		INoteService noteService = (NoteService) ctx.getBean("noteService");
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		IRegionService regionService = (RegionService) ctx.getBean("regionService");
		Note note = new Note();
		NoteDtl noteDtl = new NoteDtl();
		Set<Region> regions = new HashSet<Region>();
		regions.add(regionService.get(265));
		note.setNoteAuthor(1000);
		note.setNotePermission("private");
		note.setNotePostDate(new Date());
		note.setRegions(regions);
		noteDtl.setNoteHeader("Test");
//		noteDtl.setNote(note);
		note.setNoteDtl(noteDtl);
		System.out.println(noteService.insert(note));
	}

	@After
	void after() {
		session.close();
	}

}
