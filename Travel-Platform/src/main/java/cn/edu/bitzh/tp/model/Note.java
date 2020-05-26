package cn.edu.bitzh.tp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "t_note")
/**
 * 游记
 * @author 古学懂_Victor
 * @date 2020年5月8日
 */
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
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	@Column(name = "like_count")
	private int likeCount;
	@Column(name = "comment_count")
	private int commentCount;
	@OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "note")
	@PrimaryKeyJoinColumn
	private NoteDtl noteDtl;
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
	public Date getNotePostDate() {
		return notePostDate;
	}
	public void setNotePostDate(Date notePostDate) {
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
}
