package ru.geekbrains.spring.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

@SpringBootApplication
public class SpringOneApplication {
	// Домашнее задание
	// 1. Добавьте сущность Category (id, title). К каждой категории относится
	// какое-то количество товаров (Товар может относиться только к одной категории)
	// 2. В таблице с товарами отпечататейте название категории
	// 3. * Попробуйте сделать фильтр продуктов по категории
	// .../app/?category=food
	// Должен показать товары категории food

	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
	}
}
