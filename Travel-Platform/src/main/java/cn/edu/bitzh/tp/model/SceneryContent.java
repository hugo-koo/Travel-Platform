package cn.edu.bitzh.tp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table
@Entity(name = "t_scenery_content")
public class SceneryContent {
	@Id
	@GenericGenerator(name = "fk", 
	strategy = "foreign", 
	parameters = @Parameter(name="property", value="scenery"))
	@GeneratedValue(generator = "fk")
	@Column(name = "scenery_content_id")
	private int scenery_content_id;
	@Column(name = "scenery_content_name")
	private String scenery_content_name;
	@Lob
	@Column(name = "scenery_content_dtl")
	private String scenery_content_dtl;
	@Column(name = "scenery_content_location")
	private String scenery_content_location;
	@Column(name = "scenery_content_email")
	private String scenery_content_email;
	@Column(name = "scenery_content_phone")
	private String scenery_content_phone;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Scenery scenery;

	public int getScenery_content_id() {
		return scenery_content_id;
	}
	public void setScenery_content_id(int scenery_content_id) {
		this.scenery_content_id = scenery_content_id;
	}
	public String getScenery_content_name() {
		return scenery_content_name;
	}
	public void setScenery_content_name(String scenery_content_name) {
		this.scenery_content_name = scenery_content_name;
	}
	public String getScenery_content_dtl() {
		return scenery_content_dtl;
	}
	public void setScenery_content_dtl(String scenery_content_dtl) {
		this.scenery_content_dtl = scenery_content_dtl;
	}
	public String getScenery_content_location() {
		return scenery_content_location;
	}
	public void setScenery_content_location(String scenery_content_location) {
		this.scenery_content_location = scenery_content_location;
	}
	public String getScenery_content_email() {
		return scenery_content_email;
	}
	public void setScenery_content_email(String scenery_content_email) {
		this.scenery_content_email = scenery_content_email;
	}
	public String getScenery_content_phone() {
		return scenery_content_phone;
	}
	public void setScenery_content_phone(String scenery_content_phone) {
		this.scenery_content_phone = scenery_content_phone;
	}
	public Scenery getScenery() {
		return scenery;
	}
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}

}
