package spring.boot.first.rest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.first.rest.api.entities.Book;
import spring.boot.first.rest.api.service.BookService;

@RestController
public class HomeController {

	@Autowired
	private BookService bookService;

//	This handler is used to fetch all data from database to client.
//	If it doesn't find any it simply returns the status codes 
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> books() {
		List<Book> list = this.bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

//	This is for getting only required data from database.
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> book(@PathVariable int id) {
		Book book = this.bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

//	This is used for sending the data from client to database.
	@PostMapping("/books")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		Book bk = null;
		try {
			bk = this.bookService.addBook(book);
			System.out.println(bk);
			return ResponseEntity.of(Optional.of(bk));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

//	This is used to delete the specific data from database 
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deletion Failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

//	This is used to update/modify a specific data.
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable int id) {
		try {
			this.bookService.updateBook(book, id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Updation Failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
