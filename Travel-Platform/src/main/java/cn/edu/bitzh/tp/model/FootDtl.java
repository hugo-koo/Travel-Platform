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

/**
 * 举报
 * @author 霍子钊
 * @date 2020年6月12日
 */

@Entity
@Table(name = "t_footprint_dtl")
public class FootDtl {
	@Id
	@GenericGenerator(name = "fk", 
	strategy = "foreign", 
	parameters = @Parameter(name="property", value="note"))
	@GeneratedValue(generator = "fk")
	@Column(name = "footprint_id")
	private int footId;
	@Column(name = "footprint_header")
	private String header;
	@Lob
	@Column(name = "footprint_content")
	private String content;
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Foot foot;
	/**
	 * @author 霍子钊
	 * @date 2020年6月12日
	 * @param notePermission 1: private, 2: public
	 */
	public int getFootId() {
		return footId;
	}
	public void setFootId(int footId) {
		this.footId = footId;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Foot getFoot() {
		return foot;
	}
	public void setFoot(Foot foot) {
		this.foot = foot;
	}
	
}
