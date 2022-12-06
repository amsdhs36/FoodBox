package com.foodbox.spring.app.controller;

import java.io.IOException;
import java.util.List;

import com.foodbox.spring.app.model.Food;
import com.foodbox.spring.app.repository.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "foods")
public class FoodController {
	private byte[] bytes;
@Autowired
private FoodRepository foodRepository;
@GetMapping("/get")
public List<Food> getFoods() {
	return foodRepository.findAll();
}
@PostMapping("/upload")
public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
	this.bytes = file.getBytes();
}

@PostMapping("/add")
public void createBook(@RequestBody Food food) throws IOException {
	food.setPicByte(this.bytes);
	foodRepository.save(food);
	this.bytes = null;
}
@PutMapping("/update")
public void updateBook(@RequestBody Food food) {
	foodRepository.save(food);
}

@DeleteMapping(path = { "/{id}" })
public Food deleteFood(@PathVariable("id") long id) {
	@SuppressWarnings("deprecation")
	Food food = foodRepository.getOne(id);
	foodRepository.deleteById(id);
	return food;
}

}
