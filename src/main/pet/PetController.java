package petstore.pet;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {
	PetService service;

	public PetController(PetService service) {
		this.service = service;
	}

	@GetMapping
	public List<PetModel> getPetList() {
		try {
			return service.allPetList();
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@PostMapping
	public PetModel addPet(@RequestBody PetModel pet) {
		try {
			System.out.println("ペットを追加しました。");
			return service.add(pet);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@PutMapping("/{id}")
	public PetModel updatePet(@PathVariable Long id, @RequestBody PetModel updPet) {
		try {
			System.out.println("ペットを更新しました。");
			return service.update(id, updPet);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@GetMapping("/status/{status}")
	public List<PetModel> getPetByStatus(@PathVariable String status) {
		try {
			return service.searchPetByStatus(status);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@GetMapping("/{id}")
	public PetModel getPetById(@PathVariable Long id) {
		try {
			return service.searchPetById(id);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public PetModel deletePet(@PathVariable Long id) {
		try {
			System.out.println("ペットを削除しました。");
			return service.delete(id);
		} catch (Exception e) {
			System.out.println("エラー発生：" + e.getMessage());
			return null;
		}
	}

}
