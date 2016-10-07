package py.com.sodep.exceptions;

public class MovieNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	public MovieNotFoundException(String title) {
		super("Movie with title " + title +" not found");
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

}
