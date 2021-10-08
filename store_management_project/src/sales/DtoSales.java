package sales;

import java.time.LocalDateTime;

public class DtoSales {

	private int salesId;
	private int merchandise_Id;
	private String category;
	private String name;
	private int quantity;
	private int price;
	private LocalDateTime salesDateTime;
	
	public DtoSales(int salesId, int merchandise_Id, String category, String name, int quantity, int price,
			LocalDateTime salesDateTime) {
		super();
		this.salesId = salesId;
		this.merchandise_Id = merchandise_Id;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.salesDateTime = salesDateTime;
	}
	public DtoSales() {
		super();
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public int getMerchandise_Id() {
		return merchandise_Id;
	}
	public void setMerchandise_Id(int merchandise_Id) {
		this.merchandise_Id = merchandise_Id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int puantity) {
		this.quantity = puantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getSalesDateTime() {
		return salesDateTime;
	}
	public void setSalesDateTime(LocalDateTime salesDateTime) {
		this.salesDateTime = salesDateTime;
	}
	@Override
	public String toString() {
		return "판매목록 [판매번호 : " + salesId + ", 품번 : " + merchandise_Id + ", 제품분류 : " + category
				+ ", 제품명 : " + name + ", 수량 : " + quantity + ", 가격 : " + price + "원, 판매시간 : " + salesDateTime
				+ "]";
	}
	
	
}
