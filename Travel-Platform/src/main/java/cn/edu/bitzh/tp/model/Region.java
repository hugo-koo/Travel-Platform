package cn.edu.bitzh.tp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 地区模型
 * 
 * @author 古学懂_Victor
 */
@Entity
@Table(name = "t_region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name = "pid")
	int pid;
	@Column(name = "path")
	String path;
	@Column(name = "level")
	int level;
	@Column(name = "name")
	String name;
	@Column(name = "name_en")
	String nameEn;
	@Column(name = "name_pinyin")
	String namePinyin;
	@Column(name = "code")
	String code;
	@ManyToMany(targetEntity = Note.class)
	// 映射连接表，指定连接表t_note_region
	@JoinTable(name = "t_note_region",
			joinColumns = @JoinColumn(referencedColumnName = "region_id", name = "region_id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "note_id", name = "note_id"))
	private List<Note> notes;

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNamePinyin() {
		return namePinyin;
	}

	public void setNamePingyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "id=" + this.id + "\npid=" + this.pid + "\npath=" + this.path + "\nlevel=" + this.level + "\nname="
				+ this.name + "\ncode=" + this.code + "\n";
	}

}
