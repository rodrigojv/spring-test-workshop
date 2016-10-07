package py.com.sodep.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class MovieParserTest {

	@Test
	public void shouldParseCommaSeparetedStringIntoArray() {
		List<String> list = MovieParser.parse("superman,one direction the MOVIE,conjuro");
		
		assertThat(list.size()).isEqualTo(3);
		assertThat(list).contains("superman", "one direction the MOVIE", "conjuro");
	}
	
	@Test
	public void shouldSupportCommaSeparatedStringWithSpaces() {
		List<String> list = MovieParser.parse("superman, one direction the MOVIE, conjuro");
		
		assertThat(list.size()).isEqualTo(3);
		assertThat(list).contains("superman", "one direction the MOVIE", "conjuro");
	}
	
	@Test
	public void shouldSupportPipeSeparatedStringWithSpaces() {
		List<String> list = MovieParser.parse("superman|one direction the MOVIE|conjuro");
		
		assertThat(list.size()).isEqualTo(3);
		assertThat(list).contains("superman", "one direction the MOVIE", "conjuro");
	}
	
	@Test
	public void shouldConvertListToCommaSeparetedString(){
		String movies = MovieParser.toString(Arrays.asList("superman", "one direction the MOVIE", "conjuro"));
		
		assertThat(movies).isEqualTo("superman,one direction the MOVIE,conjuro");
	}
	
}
