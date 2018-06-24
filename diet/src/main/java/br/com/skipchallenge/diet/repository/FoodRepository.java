package br.com.skipchallenge.diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.skipchallenge.diet.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
