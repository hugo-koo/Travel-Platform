package cn.edu.bitzh.tp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_scenery")
public class Scenery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="scenery_id")
	private int scenery_id;	
	@Column(name="scenery_pid")
	private Integer scenery_pid;
	@Column(name="scenery_author")
	private int scenery_author;
	@Column(name="scenery_region")
	private int scenery_region;
	@Column(name="scenery_ispublish")
	private String scenery_ispublish;
	@Column(name="scenery_ischecked")
	private String scenery_ischecked;
	@Column(name="scenery_publish_time")
	private Date scenery_publish_time;
	@Column(name="scenery_click")
	private int scenery_click;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "scenery")
	@PrimaryKeyJoinColumn
	private SceneryContent sceneryContent;
	public SceneryContent getSceneryContent() {
		return sceneryContent;
	}
	public void setSceneryContent(SceneryContent sceneryContent) {
		this.sceneryContent = sceneryContent;
	}
	
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "scenery")
	@PrimaryKeyJoinColumn
	private Review review;
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	*/
	
	public int getScenery_id() {
		return scenery_id;
	}
	public void setScenery_id(int scenery_id) {
		this.scenery_id = scenery_id;
	}
	public Integer getScenery_pid() {
		return scenery_pid;
	}
	public void setScenery_pid(Integer scenery_pid) {
		this.scenery_pid = scenery_pid;
	}
	public int getScenery_author() {
		return scenery_author;
	}
	public void setScenery_author(int scenery_author) {
		this.scenery_author = scenery_author;
	}
	public int getScenery_region() {
		return scenery_region;
	}
	public void setScenery_region(int scenery_region) {
		this.scenery_region = scenery_region;
	}
	public String getScenery_ispulish() {
		return scenery_ispublish;
	}
	public void setScenery_ispulish(String scenery_ispulish) {
		this.scenery_ispublish = scenery_ispulish;
	}
	public String getScenery_ischecked() {
		return scenery_ischecked;
	}
	public void setScenery_ischecked(String scenery_ischecked) {
		this.scenery_ischecked = scenery_ischecked;
	}
	public Date getScenery_publish_time() {
		return scenery_publish_time;
	}
	public void setScenery_publish_time(Date scenery_pulish_time) {
		this.scenery_publish_time = scenery_pulish_time;
	}
	public int getScenery_click() {
		return scenery_click;
	}
	public void setScenery_click(int scenery_click) {
		this.scenery_click = scenery_click;
	}
	
	/*
	@Override
	public String toString() {
		return "id="+this.id+"\npid="+this.pid+"\npath="+this.path+"\nlevel="+this.level+"\nname="+this.name+"\ncode="+this.code+"\n";
	}*/
}
