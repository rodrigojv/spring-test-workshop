package py.com.sodep.enums;

/**
 * Representa la clasificación de edades de una película.
 * 
 * @author rodrigo
 *
 */
public enum ContentRating {
	
	/**
	 * General Audience (para todo público)
	 */
	G("G", 0),
	
	/**
	 * Parental Guidance. Todo público con supervisión de padres.
	 */
	PG("PG", 0), 
	
	/**
	 * Mayores de 13 años
	 */
	PG_13("PG_13", 13), // Mayores de 13
	
	/**
	 * Mayores de 17 años
	 */
	R("R", 17);
	
	private final String value;
	
	private final Integer minAge;
	
	ContentRating(String value, Integer minAge) {
		this.value = value;
		this.minAge = minAge;
	}
	
	public String value() {
		return this.value;
	}
	
	public Integer minAge() {
		return this.minAge;
	}
	
}
