package cn.edu.bitzh.tp.model;

import java.io.File;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="t_produce")

public class Produce {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//自增
		@Column(name = "produce_id")
	    private int produceID;//产品id
		
		@Column(name = "produce_title")
	 	private String produceTitle;//产品标题
		
		@Column(name = "produce_telephone")
	    private long produceTelephone;//订购电话新增
		
		@Column(name = "produce_min_price")
		private int produceMinPrice;//最低价new
		
		@Column(name = "produce_max_price")
		private int produceMaxPrice;//最高价new
		
		@Column(name = "produce_cost_day")
		private int produceCostDay;//产品花费时间new
		
		@Column(name = "produce_lindisfarne" )
		private String  produceLindisfarne;//始发地
	
		
		//@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)//一个产品对应多个产品具体费用
		//@JoinColumn(name="produce_id")//produce可以改变cost内容
		//private ProduceCost produceCost;
		
		
		
	   // @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) //一个产品对应多个图片
	   // @JoinColumn(name="produce_id")
	   // private List<GraphicIntroduction>  graphicIntroduction;
		
		
		
	    
	    
	    
		
		
	
		public void setProduceID(int produceID) {
			this.produceID = produceID;
		}
		public int getProduceID() {
			return produceID;
		}
	
		public String getProduceTitle() {
			return produceTitle;
		}
		public void setProduceTitle(String produceTitle) {
			this.produceTitle = produceTitle;
		}
		public long getProduceTelephone() {
			return produceTelephone;
		}
		public void setProduceTelephone(long produceTelephone) {
			this.produceTelephone = produceTelephone;
		}
		public int getProduceMinPrice() {
			return produceMinPrice;
		}
		public void setProduceMinPrice(int produceMinPrice) {
			this.produceMinPrice = produceMinPrice;
		}
		public int getProduceMaxPrice() {
			return produceMaxPrice;
		}
		public void setProduceMaxPrice(int produceMaxPrice) {
			this.produceMaxPrice = produceMaxPrice;
		}
		public int getProduceCostDay() {
			return produceCostDay;
		}
		public void setProduceCostDay(int produceCostDay) {
			this.produceCostDay = produceCostDay;
		}
		public String getProduceLindisfarne() {
			return produceLindisfarne;
		}
		public void setProduceLindisfarne(String produceLindisfarne) {
			this.produceLindisfarne = produceLindisfarne;
		}
		public Produce(int produceID, String produceTitle, int produceTelephone, int produceMinPrice,
				int produceMaxPrice, int produceCostDay, String produceLindisfarne) {
			super();
			this.produceID = produceID;
			this.produceTitle = produceTitle;
			this.produceTelephone = produceTelephone;
			this.produceMinPrice = produceMinPrice;
			this.produceMaxPrice = produceMaxPrice;
			this.produceCostDay = produceCostDay;
			this.produceLindisfarne = produceLindisfarne;
		}
		public Produce() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	
	
}
