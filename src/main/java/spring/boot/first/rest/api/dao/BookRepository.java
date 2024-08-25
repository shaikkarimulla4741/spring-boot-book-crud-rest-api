package spring.boot.first.rest.api.dao;

import org.springframework.data.repository.CrudRepository;

import spring.boot.first.rest.api.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
