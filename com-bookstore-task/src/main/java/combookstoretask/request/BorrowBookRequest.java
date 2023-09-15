package combookstoretask.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BorrowBookRequest {

	
	
	private Integer customerId;
	

	private Integer bookId;
	private LocalDateTime  borrowDate;
	
	private LocalDateTime  returnDate;
	
}
