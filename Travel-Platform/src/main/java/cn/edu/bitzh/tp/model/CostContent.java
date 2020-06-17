package cn.edu.bitzh.tp.model;

import javax.persistence.*;

@Entity
@Table(name="t_cost_content")

public class CostContent {
	@Id
	@Column(name="cost_id")
	private int costId;//费用id
	
	
	//@Column(name="produce_cost_type")
	//private int produceCostType;//产品费用类型 0-餐食费用，1-住宿费用，2景点门票，3往来交通  4导游服务
	
	//@Column(name="cost_Status")
	//private int costStatus;//产品费用详情 0-不包含，1-全包含 2.部分包含
	@Column(name="meals_cost")
	private int mealsCost;//餐食花费 产品费用详情 0-不包含，1-全包含 2.部分包含
	
	@Column(name="accommodation_fee")
	private int accommodationFee;//住宿费用 产品费用详情 0-不补房差，1-补偿房差 
	
	@Column(name="landmark_ticket")
	private int landmarkTicket;//景点门票 产品费用详情 0-只含门票，1-含娱乐项目
	
	@Column(name="car_fare")
	private int carFare;//往来交通 产品费用详情 0-不包含，1-全包含 2.含单程返程
	
	
	@Column(name="guide_fee")
	private int guideFee;//导游服务 产品费用详情 0-不含讲解，1-含景点讲解 
	
	
	
	
	
	public int getCostId() {
		return costId;
	}
	
	
	
	
	public void setCostId(int costId) {
		this.costId = costId;
	}




	public int getMealsCost() {
		return mealsCost;
	}




	public void setMealsCost(int mealsCost) {
		this.mealsCost = mealsCost;
	}




	public int getAccommodationFee() {
		return accommodationFee;
	}




	public void setAccommodationFee(int accommodationFee) {
		this.accommodationFee = accommodationFee;
	}




	public int getLandmarkTicket() {
		return landmarkTicket;
	}




	public void setLandmarkTicket(int landmarkTicket) {
		this.landmarkTicket = landmarkTicket;
	}




	public int getCarFare() {
		return carFare;
	}




	public void setCarFare(int carFare) {
		this.carFare = carFare;
	}




	public int getGuideFee() {
		return guideFee;
	}




	public void setGuideFee(int guideFee) {
		this.guideFee = guideFee;
	}




	public CostContent(int costId, int mealsCost, int accommodationFee, int landmarkTicket, int carFare, int guideFee) {
		super();
		this.costId = costId;
		this.mealsCost = mealsCost;
		this.accommodationFee = accommodationFee;
		this.landmarkTicket = landmarkTicket;
		this.carFare = carFare;
		this.guideFee = guideFee;
	}




	public CostContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
