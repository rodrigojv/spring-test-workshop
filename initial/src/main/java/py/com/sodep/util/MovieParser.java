package py.com.sodep.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieParser {

	private MovieParser() {
		throw new RuntimeException("No debe ser instanciado");
	}
	
	public static List<String> parse(String movies) {
		return Arrays.asList(movies.split(","));
	}
	
	public static String toString(List<String> movies) {
		return movies.stream().collect(Collectors.joining(","));
	}
}
