package petstore.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {
	List<StoreModel> orderList = new ArrayList<>();
	Long orderCount = 1L;

	public StoreModel addOrderInfo(StoreModel stm) {
		stm.setOrderId(orderCount);
		orderCount++;
		orderList.add(stm);
		return stm;
	}

	public StoreModel orderIdSearch(Long orderId) {
		for (StoreModel stmId : orderList) {
			if (stmId.getOrderId().equals(orderId)) {
				return stmId;
			}
		}
		return null;
	}

	public StoreModel deleteOrderInfo(Long orderId) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderId().equals(orderId)) {
				return orderList.remove(i);
			}
		}
		return null;
	}
}
