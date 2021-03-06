package br.com.skipchallenge.diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.skipchallenge.diet.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
