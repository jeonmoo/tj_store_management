package order;

public class DtoOrder {

	//order_id, merchandise_id, category, name, quantity, price
	private int orderId;
	private int merchandiseId;
	private String category;
	private String name;
	private int quantity;
	private int price;
	
	public DtoOrder() {
		super();
	}

	public DtoOrder(int orderId, int merchandiseId, String category, String name, int quantity, int price) {
		super();
		this.orderId = orderId;
		this.merchandiseId = merchandiseId;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(int merchandiseId) {
		this.merchandiseId = merchandiseId;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "발주목록 [발주번호 : " + orderId + ", 품번 : " + merchandiseId + ", 제품분류 : " + category
				+ ", 제품명 : " + name + ", 수량 : " + quantity + ", 가격 : " + price + "원]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
