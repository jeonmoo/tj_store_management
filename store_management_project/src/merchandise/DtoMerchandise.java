package merchandise;

import java.time.LocalDateTime;


public class DtoMerchandise {
	
	private int id;
	private String category;
	private String name;
	private int quantity;
	private int price;
	private LocalDateTime expiration_date;
	
	public DtoMerchandise(int id, String category, String name, int quantity, int price, LocalDateTime expiration_date) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.expiration_date = expiration_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDateTime getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(LocalDateTime expiration_date) {
		this.expiration_date = expiration_date;
	}

	@Override
	public String toString() {
		return "재고목록 [품번 : " + id + ", 제품분류 : " + category + ", 이름 : " + name + ", 수량 : " + quantity
				+ ", 가격 : " + price + "원, 유통기한 : " + expiration_date + "]";
	}
	
	
	
	

}
