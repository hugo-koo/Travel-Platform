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
@Table(name="t_scenery_review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="scenery_review_id")
	private int scenery_review_id;	
	@Column(name="scenery_review_author")
	private int scenery_review_author;
	@Column(name="scenery_review_score")
	private int scenery_review_score;
	@Column(name="scenery_review_dtl")
	private String scenery_review_dtl;
	@Column(name="scenery_review_time")
	private Date scenery_review_time;
	
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
	
	public int getScenery_review_id() {
		return scenery_review_id;
	}
	public void setScenery_review_id(int scenery_review_id) {
		this.scenery_review_id = scenery_review_id;
	}
	public int getScenery_review_author() {
		return scenery_review_author;
	}
	public void setScenery_review_author(int scenery_review_author) {
		this.scenery_review_author = scenery_review_author;
	}
	public String getScenery_review_dtl() {
		return scenery_review_dtl;
	}
	public void setScenery_review_dtl(String scenery_review_dtl) {
		this.scenery_review_dtl = scenery_review_dtl;
	}
	public Date getScenery_pulish_time() {
		return scenery_review_time;
	}
	public void setScenery_review_time(Date scenery_review_time) {
		this.scenery_review_time = scenery_review_time;
	}
	
	/*
	@Override
	public String toString() {
		return "id="+this.id+"\npid="+this.pid+"\npath="+this.path+"\nlevel="+this.level+"\nname="+this.name+"\ncode="+this.code+"\n";
	}*/
}
