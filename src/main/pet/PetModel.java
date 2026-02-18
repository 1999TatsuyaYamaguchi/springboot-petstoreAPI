package petstore.pet;

public class PetModel {
	Long id;
	String name;
	String status;
	String photoUrl;

	public PetModel(Long id, String name, String status, String photoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.photoUrl = photoUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
