package petstore.pet;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PetService {

	PetRepository repository;

	public PetService(PetRepository repository) {
		this.repository = repository;
	}

	public List<PetModel> allPetList() {
		return repository.showPetList();
	}

	public PetModel add(PetModel pet) {
		return repository.addPetInfo(pet);
	}

	public PetModel update(Long id, PetModel pet) {
		return repository.updatePetInfo(id, pet);
	}

	public List<PetModel> searchPetByStatus(String status) {
		return repository.statusSearch(status);
	}

	public PetModel searchPetById(Long id) {
		return repository.idSearch(id);
	}

	public PetModel delete(Long id) {
		return repository.deletePetInfo(id);
	}
}
