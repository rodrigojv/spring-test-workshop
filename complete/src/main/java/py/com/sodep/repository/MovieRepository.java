package py.com.sodep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.sodep.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Movie findByTitle(String title);

}
