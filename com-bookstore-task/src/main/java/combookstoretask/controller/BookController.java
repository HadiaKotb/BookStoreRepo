package combookstoretask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import combookstoretask.entities.Book;
import combookstoretask.request.BookRequest;
import combookstoretask.services.IBook;

@RestController
public class BookController {
	
	@Autowired
	IBook bookService;
	
	@GetMapping("/browsebook")
	ResponseEntity<List<Book>> browseBooksByCategory( @RequestParam(name = "bookName", required = false) String bookName,
    @RequestParam(name = "bookCategory", required = false) String bookCategory,
    @RequestParam(name = "bookAuthor", required = false) String bookAuthor) {
		
		return ResponseEntity.ok(bookService.browseBooksByCategory(bookName, bookCategory, bookAuthor));
		
	}
	
	@GetMapping("/bookdetails/{id}")
	ResponseEntity<String> viewBookDetails(@PathVariable Integer id) {
		
		return ResponseEntity.ok(bookService.viewBookDetails(id).getBookDetails());
		
	}
	
	
	@PostMapping("adminaddbook/{customerId}")
	ResponseEntity<List<Book>> addBookForAdmin(@PathVariable Integer customerId,@RequestBody List<BookRequest>books){
		
		List<Book>booksAdded=bookService.addBookForAdmin(customerId, books);
		
		return ResponseEntity.ok(booksAdded);	
	
	}
	
	@DeleteMapping("admindeletebook/{customerId}/{bookId}")
	ResponseEntity<Void> deleteBookForAdmin(@PathVariable Integer customerId,@PathVariable Integer bookId){
		bookService.deleteBookForAdmin(customerId, bookId);
		return ResponseEntity.status(HttpStatus.OK).build();
		
		
	}
	
	
	

}
