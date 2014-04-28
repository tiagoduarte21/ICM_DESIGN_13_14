package pt.ua.icm_design_13_14;

public class News {

	private String title;
	private int image;
	private String description;
	
	

	public News(String title, int image, String description) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
