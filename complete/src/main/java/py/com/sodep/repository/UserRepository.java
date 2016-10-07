package py.com.sodep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.sodep.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
