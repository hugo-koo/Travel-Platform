package cn.edu.bitzh.tp.model;

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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

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
	@ManyToMany(targetEntity = Note.class, fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinTable(name = "t_note_region", joinColumns = @JoinColumn(name = "region_id"), inverseJoinColumns = @JoinColumn(name = "note_id"))
	private Set<Note> notes = new HashSet<Note>();

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
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
