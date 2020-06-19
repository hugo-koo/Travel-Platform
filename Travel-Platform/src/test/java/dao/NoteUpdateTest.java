package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bitzh.tp.dao.INoteDao;
import cn.edu.bitzh.tp.dao.impl.NoteDao;
import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.model.NoteDtl;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.service.IRegionService;
import cn.edu.bitzh.tp.service.impl.NoteService;
import cn.edu.bitzh.tp.service.impl.RegionService;

/**
* @author 古学懂_Victor
* @date 2020
*/
class NoteUpdateTest {
	private Note note = null; 
	private NoteDtl noteDtl = null;
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	private INoteDao nd = (NoteDao) applicationContext.getBean("noteDao");
	@Test
	void test() {
		System.out.println("JUnit Test: Hibernate+Spring Session Test Insert");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		INoteService noteService = (NoteService) ctx.getBean("noteService");
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		IRegionService regionService = (RegionService) ctx.getBean("regionService");
		Note note = new Note();
		NoteDtl noteDtl = new NoteDtl();
		
		note.setNoteId(1121);
		noteDtl.setNoteId(1121);
		
		Set<Region> regions = new HashSet<Region>();
		regions.add(regionService.get(265));
		note.setNoteAuthor(1000);
		note.setNotePermission("private");
		note.setNotePostDate(new Date());
		note.setRegions(regions);
		noteDtl.setNoteHeader("Test 2");
		noteDtl.setNote(note);
		note.setNoteDtl(noteDtl);

		System.out.println(noteService.insert(note));
	}

}
