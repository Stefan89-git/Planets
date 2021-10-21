package project.planets;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import project.planets.model.Planet;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PropertyTest {

	@Autowired
	private TestRestTemplate restTepmlate;
	
	@Test
	void testPlanetServiceNotFound() throws Exception{
		assertThat(this.restTepmlate.getForObject("http://localhost:8080/api/planets/1", Planet.class))
		.hasFieldOrProperty("satellites").hasFieldOrProperty("id").hasFieldOrProperty("name");
	}

}
