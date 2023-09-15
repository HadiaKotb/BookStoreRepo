package combookstoretask.response;

import java.time.LocalDateTime;

import combookstoretask.entities.enums.BookAvialabilty;
import lombok.Data;

@Data
public class BorrowHistoryResponse {

	private Integer bookId;
	

	private String bookName;
	
	private String bookCategory;
	
	private String bookAuthor;
	
	private String bookDetails;
	
	private LocalDateTime  borrowDate;
	
	private LocalDateTime  returnDate;
	
	private BookAvialabilty BookAvialabilty;
}
