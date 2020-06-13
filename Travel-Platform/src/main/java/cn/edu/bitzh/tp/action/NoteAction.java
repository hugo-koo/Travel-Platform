package cn.edu.bitzh.tp.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.service.IRegionService;
import cn.edu.bitzh.tp.service.impl.NoteService;
import cn.edu.bitzh.tp.service.impl.RegionService;

/**
 * @author 古学懂_Victor
 * @date 2020
 */
public class NoteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	private INoteService ns = (NoteService) applicationContext.getBean("noteService");;
	private ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("beans.xml");
	private IRegionService rs = (RegionService) applicationContext2.getBean("regionService");
	private Note note;
	private int noteId = 1000;
	private int regionId = 0;

	public String get() {
		final Note note = ns.get(this.noteId);
		// 权限判断
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
		Set<Region> regions = new HashSet<Region>();
		Region region = rs.get(regionId);
//		region.setId(regionId);
		regions.add(region);
		this.note.setRegions(regions);
		int id = this.ns.insert(this.note);
		if (id != 0) {
			this.noteId = id;
		} else {
			return ActionSupport.INPUT;
		}
		return ActionSupport.SUCCESS;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
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
