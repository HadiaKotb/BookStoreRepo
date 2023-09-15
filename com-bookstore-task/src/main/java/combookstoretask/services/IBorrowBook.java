package combookstoretask.services;

import java.time.LocalDateTime;
import java.util.Date;

import combookstoretask.entities.BorrowBook;
import combookstoretask.request.BorrowBookRequest;

public interface IBorrowBook {
	public BorrowBook requestBorrowingABook(BorrowBookRequest borrowRequest);
	public BorrowBook updateBookAvialabiltyForAdmin(Integer customerId, Integer bookId,String bookAvailabilityStatus, LocalDateTime returnDate );


}
