package cn.edu.bitzh.tp.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Note;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.model.User;
import cn.edu.bitzh.tp.service.INoteService;
import cn.edu.bitzh.tp.service.IRegionService;
import cn.edu.bitzh.tp.service.impl.NoteService;
import cn.edu.bitzh.tp.service.impl.RegionService;

/**
 * @author 古学懂_Victor
 * @date 2020年5月
 */
public class NoteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	private INoteService ns = (NoteService) applicationContext.getBean("noteService");
	private ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("beans.xml");
	private IRegionService rs = (RegionService) applicationContext2.getBean("regionService");
	/** 游记，其中内容字段不编译为JSON，减少不必要的传输开支 */
	private Note note;
	private List<Note> notes;
	private int noteId = 1000;
	private int regionId = 0;
	/** 点赞数 */
	private int likeCount = -1;
	/** 页码 */
	private int page = 1;
	/** 页总数 */
	private int totalPages = 1;
	/** 每页项数 */
	private int itemsPerPage = 5;
	/** 独立的内容字段，使允许在JSON中获取内容 */
	private String noteContent = null;

	public String get() {
		final Note note = ns.get(this.noteId);
		// 权限判断
//		if (note.getNotePermission().equals("public")) {
		this.note = note;
		// 向内容字段赋值
		this.noteContent = this.note.getNoteDtl().getNoteContent();
//		} else {
//			return ActionSupport.NONE;
//		}
		return ActionSupport.SUCCESS;
	}

	public String insert() {
		this.note.setNotePostDate(new Date());
		User author = new User();
		author.setUserId(1000);
		note.setNoteAuthor(author);
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
	 * 获取最新的公开游记并分页
	 * 
	 * @author 古学懂_Victor
	 * @date 2020年
	 * @return
	 */
	public String listLatestNotes() {
		this.notes = ns.listAllNotes();
		if (notes == null)
			return ActionSupport.ERROR;
		if (this.notes.size() % itemsPerPage != 0) {
			totalPages = this.notes.size() / itemsPerPage + 1;
		} else {
			totalPages = this.notes.size() / itemsPerPage;
		}
		if (page == totalPages) {
			/** 最后一页 */
			System.out.println(itemsPerPage * (page - 1));
			System.out.println(this.notes.size());
			this.notes = this.notes.subList(itemsPerPage * (page - 1), this.notes.size());
		} else {
			this.notes = this.notes.subList(itemsPerPage * (page - 1), itemsPerPage * page);
		}
		return ActionSupport.SUCCESS;
	}

	/**
	 * 获取最热的公开游记并分页
	 * 
	 * @author 古学懂_Victor
	 * @date 2020年6月15日
	 * @return
	 */
	public String listHotestNotes() {
		this.notes = ns.listHotestNotes();
		if (notes == null)
			return ActionSupport.ERROR;
		if (this.notes.size() % itemsPerPage != 0) {
			totalPages = this.notes.size() / itemsPerPage + 1;
		} else {
			totalPages = this.notes.size() / itemsPerPage;
		}
		if (page == totalPages) {
			/** 最后一页 */
			this.notes = this.notes.subList(itemsPerPage * (page - 1), this.notes.size());
		} else {
			this.notes = this.notes.subList(itemsPerPage * (page - 1), itemsPerPage * page);
		}
		return ActionSupport.SUCCESS;
	}

	public String like() {
		this.likeCount = ns.like(request, response, noteId);
		if (this.likeCount != -1)
			return "success";
		else
			return "error";
	}

	public String modify() {
		System.out.println(noteId);
		this.note.setNoteId(noteId);
		this.note.getNoteDtl().setNoteId(noteId);
		this.note.setNotePostDate(new Date());
		User author = new User();
		author.setUserId(1000);
		note.setNoteAuthor(author);
		Set<Region> regions = new HashSet<Region>();
		Region region = rs.get(regionId);
		regions.add(region);
		this.note.setRegions(regions);
		boolean flag = this.ns.update(this.note);
		if (flag) {
			return ActionSupport.SUCCESS;
		} else {
			return ActionSupport.ERROR;
		}
	}
	
	public String delete() {
		boolean flag = this.ns.delete(noteId);
		if (flag) {
			return ActionSupport.SUCCESS;
		} else {
			return ActionSupport.INPUT;
		}
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

	/**
	 * @return the likeCount
	 */
	public int getLikeCount() {
		return likeCount;
	}

	/**
	 * @param likeCount the likeCount to set
	 */
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	/**
	 * @return the noteContent
	 */
	public String getNoteContent() {
		return noteContent;
	}

	/**
	 * @param noteContent the noteContent to set
	 */
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

}
