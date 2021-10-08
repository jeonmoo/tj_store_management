package discard;

import java.time.LocalDateTime;

public class Dtodiscard {

	private int discardId;
	private int merchandiseId;
	private String category;
	private String name;
	private int quantity;
	private int price;
	private LocalDateTime discardDatetime;
	
	public Dtodiscard(int discardId, int merchandiseId, String category, String name, int quantity, int price,
			LocalDateTime discardDatetime) {
		super();
		this.discardId = discardId;
		this.merchandiseId = merchandiseId;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.discardDatetime = discardDatetime;
	}
	public Dtodiscard() {
		super();
	}
	public int getDiscardId() {
		return discardId;
	}
	public void setDiscardId(int discardId) {
		this.discardId = discardId;
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
	public void setCategory(String categori) {
		this.category = categori;
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
	public LocalDateTime getDiscardDatetime() {
		return discardDatetime;
	}
	public void setDiscardDatetime(LocalDateTime discardDatetime) {
		this.discardDatetime = discardDatetime;
	}
	@Override
	public String toString() {
		return "폐기목록 [폐기번호 : " + discardId + ", 품번 : " + merchandiseId + ", 제품분류 : " + category
				+ ", 제품명 : " + name + ", 수량 : " + quantity + ", 가격 : " + price + "원, 폐기시간 : " + discardDatetime
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
