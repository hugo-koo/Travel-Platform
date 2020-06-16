package cn.edu.bitzh.tp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Cascade;

/**
 * 游记
 * 
 * @author 古学懂_Victor
 * @date 2020年5月8日
 */
@Entity
@Table(name = "t_note")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "note_id")
	private int noteId;
	@Column(name = "note_author")
	private int noteAuthor;
	@Column(name = "note_permission")
	private String notePermission;
	@Column(name = "note_post_date")
	private Date notePostDate;
	@Column(name = "favorite_count")
	private int favoriteCount;
	@Column(name = "like_count")
	private int likeCount;
	@Column(name = "comment_count")
	private int commentCount;
	@OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "note")
	@PrimaryKeyJoinColumn
	private NoteDtl noteDtl;
	@ManyToMany(targetEntity = Region.class, fetch = FetchType.EAGER)
	// 使用hibernate注解级联保存与更新
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	// 映射连接表，指定连接表t_note_region
	@JoinTable(name = "t_note_region", joinColumns = @JoinColumn(name = "note_id"), inverseJoinColumns = @JoinColumn(name = "region_id"))
	//饿汉模式
	private Set<Region> regions = new HashSet<Region>();
	//格式化后的日期字符串
	private String postDateStr = "";
	
	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

	public NoteDtl getNoteDtl() {
		return noteDtl;
	}

	public void setNoteDtl(NoteDtl noteDtl) {
		this.noteDtl = noteDtl;
	}

	/**
	 * @author 古学懂_Victor
	 * @date 2020年5月8日
	 * @param notePermission 1: private, 2: public
	 */
	public void setNotePermission(String notePermission) {
		this.notePermission = notePermission;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public int getNoteAuthor() {
		return noteAuthor;
	}

	public void setNoteAuthor(int noteAuthor) {
		this.noteAuthor = noteAuthor;
	}

	@JSON(serialize = false)
	public Date getNotePostDate() {
		return notePostDate;
	}

	public void setNotePostDate(Date notePostDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.setPostDateStr(sdf.format(notePostDate));
		this.notePostDate = notePostDate;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getNotePermission() {
		return notePermission;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	/**
	 * @return the formated postDateStr
	 */
	public String getPostDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.postDateStr = sdf.format(this.notePostDate);
		return this.postDateStr;
	}

	/**
	 * @param postDateStr the postDateStr to set
	 */
	public void setPostDateStr(String postDateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			this.notePostDate = sdf.parse(postDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.postDateStr = postDateStr;
	}

}
