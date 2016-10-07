package py.com.sodep.exceptions;

public class MovieAlreadyInWatchlistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private Object movieTitle;

	public MovieAlreadyInWatchlistException(String username , String movieTitle) {
		super("Movie " + movieTitle + " is already in user with username " + username + " watchlist");
		this.setUsername(username);
		this.setMovieTitle(movieTitle);
	}

	public Object getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(Object movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
