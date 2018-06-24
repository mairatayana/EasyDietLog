package br.com.skipchallenge.diet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="foods")
public class Food {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Long calories;
	
	@NotNull
	private String unitCalories;
	
	public Food() {	}
	
	public Food(Long id) {
		this.id = id;
	}
	
	public Food(Long id, String nome, Long calories, String unitCalories) {
		this.id = id;
		this.nome = nome;
		this.calories = calories;
		this.unitCalories = unitCalories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

	public String getUnitCalories() {
		return unitCalories;
	}

	public void setUnitCalories(String unitCalories) {
		this.unitCalories = unitCalories;
	}

}
