package cn.edu.bitzh.tp.model;

import java.util.Date;
import javax.persistence.*;

/**
 * 举报
 * @author 霍子钊
 * @date 2020年6月12日
 */

@Entity
@Table(name = "t_footprint")
public class Foot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "footprint_id")
	private int footId;
	@Column(name = "region_id")
	private int regionId;
	@Column(name = "footprint_ownner")
	private int ownnerId;
	@Column(name = "footprint_permission")
	private String permission;
	@Column(name = "footprint_trip_data")
	private Date date;
	@OneToOne(fetch = FetchType.EAGER, optional = false, mappedBy = "footId")
	@PrimaryKeyJoinColumn
	private FootDtl footDtl;
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
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getOwnnerId() {
		return ownnerId;
	}
	public void setOwnnerId(int ownnerId) {
		this.ownnerId = ownnerId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public FootDtl getFootDtl() {
		return footDtl;
	}
	public void setFootDtl(FootDtl footDtl) {
		this.footDtl = footDtl;
	}
	
}
