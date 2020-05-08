package cn.edu.bitzh.tp.model;

import javax.persistence.CascadeType;
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
@Entity(name = "t_note_dtl")
/**
 *  游记内容
 * @author 古学懂_Victor
 * @date 2020年5月5日
 */
public class NoteDtl {
	@Id
	@GenericGenerator(name = "fk", 
	strategy = "foreign", 
	parameters = @Parameter(name="property", value="note"))
	@GeneratedValue(generator = "fk")
	private int note_id;
	private String note_header;
	@Lob
	private String note_content;
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Note note;

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	public String getNote_header() {
		return note_header;
	}

	public void setNote_header(String note_header) {
		this.note_header = note_header;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
}
