package combookstoretask.mapper;

import combookstoretask.entities.Book;
import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.Customer;
import combookstoretask.entities.enums.BookAvialabilty;
import combookstoretask.request.BorrowBookRequest;

public class BorrowBookRequestToEntityMapper {
	
	public static BorrowBook mapBorrowRequestToEntity(BorrowBookRequest borrowRequest, Customer customer, Book book) {
		BorrowBook borrowBook=new BorrowBook();
		borrowBook.setCustomer(customer);
		borrowBook.setBook(book);
		borrowBook.setBorrowDate(borrowRequest.getBorrowDate());
		borrowBook.setReturnDate(borrowRequest.getReturnDate());
		borrowBook.setBookAvialabilty(BookAvialabilty.PENDING);
		return borrowBook;
	}


}
