package cn.edu.bitzh.tp.model;
import java.util.List;
import javax.persistence.*;



/**
* 产品费用
* @author 周锦涛
* 
*/





@Entity
@Table(name="t_produce_cost")
public class ProduceCost {
	
	@Column(name="produce_id" )//产品id
	private int produceId;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cost_id")
	private int costId;//费用id
	
	//@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
   // @JoinColumn(name="cost_id")
	//private List<CostContent> CostContent;//产品费用内容列表
	
	
	
	//public List<CostContent> getCostContent() {
		//return CostContent;
	//}
	//public void setCostContent(List<CostContent> costContent) {
		//CostContent = costContent;
	//}
	public int getProduceId() {
		return produceId;
	}
	public void setProduceId(int produceId) {
		this.produceId = produceId;
	}
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	public ProduceCost(int produceId, int costId) {
		super();
		this.produceId = produceId;
		this.costId = costId;
	}
	public ProduceCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
