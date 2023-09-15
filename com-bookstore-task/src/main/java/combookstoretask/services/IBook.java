package combookstoretask.services;

import java.util.Date;
import java.util.List;

import combookstoretask.entities.Book;
import combookstoretask.entities.BorrowBook;
import combookstoretask.request.BookRequest;

public interface IBook {
	
	public List<Book> browseBooksByCategory(String bookName, String bookCategory, String bookAuthor);
	
	public Book viewBookDetails(Integer bookId);
	
	//public void requestBorrowingABook(Integer bookId, Integer customerId,Date requestedDate);
	
	public  List<Book> addBookForAdmin(Integer customerd, List<BookRequest> book);	
	
	public  void deleteBookForAdmin(Integer customerd, Integer bookId);
	
	//public  BorrowBook   updateBookAvialabiltyForAdmin(Integer customerId, Integer bookId,String bookAvailabilityStatus, Date returnDate);
	
	
}
