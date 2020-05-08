package cn.edu.bitzh.tp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_note")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int note_id;
	private int note_author;
	private int note_permission;
	private Date note_post_date;
	private int favorite_count;
	private int like_count;
	private int comment_count;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@PrimaryKeyJoinColumn
	private NoteDtl noteDtl;
	public NoteDtl getNoteDtl() {
		return noteDtl;
	}
	public void setNoteDtl(NoteDtl noteDtl) {
		this.noteDtl = noteDtl;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getNote_author() {
		return note_author;
	}
	public void setNote_author(int note_author) {
		this.note_author = note_author;
	}
	public int getNote_permission() {
		return note_permission;
	}
	public void setNote_permission(int note_permission) {
		this.note_permission = note_permission;
	}
	public Date getNote_post_date() {
		return note_post_date;
	}
	public void setNote_post_date(Date note_post_date) {
		this.note_post_date = note_post_date;
	}
	public int getFavorite_count() {
		return favorite_count;
	}
	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
}
