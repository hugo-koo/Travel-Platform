package cn.edu.bitzh.tp.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
	private List<Note> notes;
	private int noteId = 1000;
	private int regionId = 0;
	/** 页码 */
	private int page = 0;
	/** 页总数 */
	private int totalPages = 0;
	/** 每页项数 */
	private int itemsPerPage = 5;

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

	/**
	 * 获取最新游记并分页
	 * @author 古学懂_Victor
	 * @date 2020年
	 * @return
	 */
	public String listLatestNotes() {
		this.notes = ns.listAllNotes();
		if (this.notes.size() % itemsPerPage != 0) {
			totalPages = this.notes.size() / itemsPerPage + 1;
		} else {
			totalPages = this.notes.size() / itemsPerPage;
		}
		if (page == totalPages - 1) {
			/** 最后一页 */
			this.notes = this.notes.subList(itemsPerPage * page, this.notes.size());
		} else {
			this.notes = this.notes.subList(itemsPerPage * page, itemsPerPage * (page + 1));
		}
		return ActionSupport.SUCCESS;
	}

	/**
	 * 获取最热游记并分页
	 * @author 古学懂_Victor
	 * @date 2020年6月15日 下午3:08:29
	 * @return
	 */
	public String listHotestNotes() {
		this.notes = ns.listHotestNotes();
		if (this.notes.size() % itemsPerPage != 0) {
			totalPages = this.notes.size() / itemsPerPage + 1;
		} else {
			totalPages = this.notes.size() / itemsPerPage;
		}
		if (page == totalPages - 1) {
			/** 最后一页 */
			this.notes = this.notes.subList(itemsPerPage * page, this.notes.size());
		} else {
			this.notes = this.notes.subList(itemsPerPage * page, itemsPerPage * (page + 1));
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

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the itemsPerPage
	 */
	public int getItemsPerPage() {
		return itemsPerPage;
	}

	/**
	 * @param itemsPerPage the itemsPerPage to set
	 */
	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

}
