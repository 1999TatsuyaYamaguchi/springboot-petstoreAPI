package pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PetRepository {

	List<PetModel> petList = new ArrayList<>();
	Long count = 1L;

	public List<PetModel> showPetList() {
		return petList;
	}

	public PetModel addPetInfo(PetModel pet) {
		pet.setId(count);
		count++;
		petList.add(pet);
		return pet;
	}

	public PetModel updatePetInfo(Long id, PetModel pet) {
		PetModel ptm = idSearch(id);
		if (ptm.equals(null)) {
			System.out.println("指定したIDが存在しません");
			return null;
		}
		ptm.setName(pet.getName());
		ptm.setStatus(pet.getStatus());
		ptm.setPhotoUrl(pet.getPhotoUrl());
		return ptm;
	}

	public List<PetModel> statusSearch(String status) {
		List<PetModel> statusList = new ArrayList<>();
		for (PetModel pmdStatus : petList) {
			if (pmdStatus.getStatus().equals(status)) {
				statusList.add(pmdStatus);
			}
		}
		return statusList;
	}

	public PetModel idSearch(Long id) {
		for (PetModel pmdId : petList) {
			if (pmdId.getId().equals(id)) {
				return pmdId;
			}
		}
		return null;
	}

	public PetModel deletePetInfo(Long id) {
		for (int i = 0; i < petList.size(); i++) {
			if (petList.get(i).getId().equals(id)) {
				return petList.remove(i);
			}
		}
		return null;
	}
}
