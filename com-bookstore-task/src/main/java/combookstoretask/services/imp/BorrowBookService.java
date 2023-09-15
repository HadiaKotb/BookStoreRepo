package combookstoretask.services.imp;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import combookstoretask.entities.Book;
import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.Customer;
import combookstoretask.entities.enums.BookAvialabilty;
import combookstoretask.entities.enums.CustomerRole;
import combookstoretask.exception.PremessionException;
import combookstoretask.exception.ResourceNotFoundException;
import combookstoretask.mapper.BorrowBookRequestToEntityMapper;
import combookstoretask.reposiotry.BookReposiotry;
import combookstoretask.reposiotry.BorrowBookRepoisotry;
import combookstoretask.reposiotry.CustomerRepoisotry;
import combookstoretask.request.BorrowBookRequest;
import combookstoretask.services.IBorrowBook;
@Service
public class BorrowBookService implements IBorrowBook {
	@Autowired
	BookReposiotry bookReposiotry;
	@Autowired
	CustomerRepoisotry customerReposiotry;
	
	@Autowired
	BorrowBookRepoisotry borrowBookRepoisotry;
	
	@Override
	public BorrowBook requestBorrowingABook(BorrowBookRequest borrowRequest) {
		// TODO Auto-generated method stub
		Customer customer=customerReposiotry.findById(borrowRequest.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("No Customer Found with  id: " + borrowRequest.getCustomerId()));
		Book book=bookReposiotry.findById(borrowRequest.getBookId()).
				orElseThrow(() -> new ResourceNotFoundException("There is not a Book with ID " + borrowRequest.getBookId()));
		if(borrowRequest.getBorrowDate().isBefore(LocalDateTime.now())) {
			
			throw new PremessionException("You are not allowed to book in a past  date");
		}
		
		if(borrowRequest.getBorrowDate().isAfter(borrowRequest.getReturnDate())) {
			
			throw new PremessionException("return date should be after borrowing date");
		}
		
		if(book.getBorrowBook()!=null &&
				!BookAvialabilty.AVAILABLE.name().equalsIgnoreCase(book.getBorrowBook().getBookAvialabilty().name())) {
			throw new ResourceNotFoundException("The book You are trying to book is already booked");
		
		}
		
		
		return borrowBookRepoisotry.save(BorrowBookRequestToEntityMapper.mapBorrowRequestToEntity(borrowRequest, customer, book));
			
		
	}



	@Override
	public BorrowBook updateBookAvialabiltyForAdmin(Integer customerId, Integer bookId,String bookAvailabilityStatus, LocalDateTime returnDate ) {
		// TODO Auto-generated method stub
		Customer customer= customerReposiotry.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("No Customer Found with  id: " + customerId));
		if(returnDate.isBefore(LocalDateTime.now())) {
			throw new PremessionException("You cannot add a return date in the past");
		}
		if(CustomerRole.ADMIN.name().equalsIgnoreCase(customer.getCustomerRole().name())) {
			BorrowBook borrowBook=borrowBookRepoisotry.findBorrowBookFromBook(bookId).
					orElseThrow(()-> new ResourceNotFoundException("No Book is booked with id "+bookId));
			borrowBook.setBookAvialabilty(BookAvialabilty.fromString(bookAvailabilityStatus));
			borrowBook.setReturnDate(returnDate);
			return borrowBookRepoisotry.save(borrowBook);
			
		}else {
			throw new PremessionException("You are not allowed to update Books");
		}
		
		
	}

}
