package combookstoretask.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import combookstoretask.entities.BorrowBook;
import combookstoretask.reposiotry.BookReposiotry;
import combookstoretask.reposiotry.BorrowBookRepoisotry;
import combookstoretask.reposiotry.CustomerRepoisotry;
import combookstoretask.request.BorrowBookRequest;
import combookstoretask.services.IBorrowBook;

@RestController
public class BorrowRequestController {
	
	@Autowired
	IBorrowBook borrowBookService;
	@PostMapping("/borrowbook")
	ResponseEntity<BorrowBook> requestBorrowingABook(@RequestBody BorrowBookRequest borrowBookRequest) {
		
	
		
		return ResponseEntity.ok(borrowBookService.requestBorrowingABook(borrowBookRequest));
	}
	
	@PatchMapping("adminupdatebook/{customerId}/{bookId}/{bookAvailabilityStatus}/{returnDate}")
	ResponseEntity<BorrowBook> updateBookAvialabiltyForAdmin(@PathVariable  Integer customerId,@PathVariable Integer bookId,
			@PathVariable String bookAvailabilityStatus,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime returnDate ) {
		
		BorrowBook book=borrowBookService.updateBookAvialabiltyForAdmin(customerId, bookId, bookAvailabilityStatus, returnDate);
		return ResponseEntity.ok(book);
	}
}
