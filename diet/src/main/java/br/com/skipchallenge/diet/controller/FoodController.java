package br.com.skipchallenge.diet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.skipchallenge.diet.exception.ResourceNotFoundException;
import br.com.skipchallenge.diet.model.Food;
import br.com.skipchallenge.diet.repository.FoodRepository;

@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	FoodRepository foodRepository;
	
	//Get all food
	// podia ter usado @RequestMapping(value="/foods", method=RequestMethod.GET)
	@GetMapping("/foods")
	public List<Food> getAllFoods(){
		return foodRepository.findAll();
	}
	
	//Create a new food
	@PostMapping("/foods")
	public Food createFood(@Valid @RequestBody Food food) {
		return foodRepository.save(food);
	}
	
	//Get a single food
	@GetMapping("/foods/{id}")
	public Food getFoodById(@PathVariable(value = "id") Long id) {
		return foodRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Food", "id", id));
	}
	
	//Update a Food
	@PutMapping("foods/{id}")
	public Food updateFood(@PathVariable(value = "id") Long id, @Valid @RequestBody String name, @Valid @RequestBody Long calorias) {
		Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id));
		food.setNome(name);
		food.setCalories(calorias);
		Food updateFood = foodRepository.save(food);
		return updateFood;
	}
	
	//Delete a Food
	@DeleteMapping("/foods/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id){
		Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id));
		foodRepository.delete(food);
		return ResponseEntity.ok().build();
}
}
