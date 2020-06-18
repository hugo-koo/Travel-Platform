package cn.edu.bitzh.tp.model;

import javax.persistence.*;
@Entity
@Table(name="t_graphic_introduction")
public class GraphicIntroduction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//自增
	@Column(name = "graphic_id")
    private int graphicId;//图片id

	@Column(name="produce_id")
	private int produceId;//产品id
	
	@Column(name = "graphic_introduction_content")
	private String graphicIntroductionContent;//图片URl
	
	
	@Column(name = "graphic_type")
	private int graphicType;//0-宣传图 1-图文详情 

	
	
	public int getProduceId() {
		return produceId;
	}


	public void setProduceId(int produceId) {
		this.produceId = produceId;
	}


	public String getGraphicIntroductionContent() {
		return graphicIntroductionContent;
	}


	public void setGraphicIntroductionContent(String graphicIntroductionContent) {
		this.graphicIntroductionContent = graphicIntroductionContent;
	}


	public int getGraphicType() {
		return graphicType;
	}


	public void setGraphicType(int graphicType) {
		this.graphicType = graphicType;
	}
	
	
	public int getGraphicId() {
		return graphicId;
	}


	public void setGraphicId(int graphicId) {
		this.graphicId = graphicId;
	}


	public GraphicIntroduction(int graphicId, int produceId, String graphicIntroductionContent, int graphicType) {
		super();
		this.graphicId = graphicId;
		this.produceId = produceId;
		this.graphicIntroductionContent = graphicIntroductionContent;
		this.graphicType = graphicType;
	}


	public GraphicIntroduction() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "GraphicIntroduction [graphicId=" + graphicId + ", produceId=" + produceId
				+ ", graphicIntroductionContent=" + graphicIntroductionContent + ", graphicType=" + graphicType + "]";
	}


	
	
	
}
