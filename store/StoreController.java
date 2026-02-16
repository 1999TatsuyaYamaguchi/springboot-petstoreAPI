package petstore.store;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class StoreController {

	StoreService storeService;

	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	@PostMapping
	public StoreModel addOrder(@RequestBody StoreModel stm) {
		try {
			System.out.println("アイテムを追加しました。");
			return storeService.add(stm);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@GetMapping("/{orderId}")
	public StoreModel showOrder(@PathVariable Long orderId) {
		try {
			return storeService.searchByOrderId(orderId);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@DeleteMapping("/{orderId}")
	public StoreModel deleteOrder(@PathVariable Long orderId) {
		try {
			return storeService.delete(orderId);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

}
