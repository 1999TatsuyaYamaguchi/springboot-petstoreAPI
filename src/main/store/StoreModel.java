package petstore.store;

public class StoreModel {
	Long orderId;
	String itemName;
	int quantity;

	public StoreModel(Long orderId, String itemName, int quantity) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.quantity = quantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
