package spring.boot.first.rest.api.service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.first.rest.api.dao.BookRepository;
import spring.boot.first.rest.api.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

//  I commented all the previous code 
//	Creating a list  of books.
//	private static List<Book> list = new ArrayList<Book>();
//
//	static {
//		list.add(new Book(41, "Java", "Java Basic"));
//		list.add(new Book(42, "Advance Java", "Java Advance"));
//		list.add(new Book(43, "Java Spring", "Java Spring Topics"));
//	}

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
//			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e2) {
			System.out.println("No data found");
		}

		return book;
	}

	public Book addBook(Book book) {
		return this.bookRepository.save(book);
	}

	public void deleteBook(int id) {
		this.bookRepository.deleteById(id);
	}

	public void updateBook(Book book, int id) {

		book.setId(id);
		this.bookRepository.save(book);

//		list = list.stream().map(b -> {
//			if (b.getId() == id) {
//				b.setBook(book.getBook());
//				b.setDesc(book.getDesc());
//			}
//			return b;
//		}).collect(Collectors.toList());
	}

}
