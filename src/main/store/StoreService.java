package petstore.store;

import org.springframework.stereotype.Service;

@Service
public class StoreService {

	StoreRepository storeRepository;

	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	public StoreModel add(StoreModel stm) {
		return storeRepository.addOrderInfo(stm);
	}

	public StoreModel searchByOrderId(Long orderId) {
		return storeRepository.orderIdSearch(orderId);
	}

	public StoreModel delete(Long orderId) {
		return storeRepository.deleteOrderInfo(orderId);
	}
}
