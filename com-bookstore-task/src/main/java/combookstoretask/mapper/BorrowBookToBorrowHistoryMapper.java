package combookstoretask.mapper;

import java.util.List;
import java.util.stream.Collectors;

import combookstoretask.entities.Book;
import combookstoretask.entities.BorrowBook;
import combookstoretask.request.BookRequest;
import combookstoretask.response.BorrowHistoryResponse;

public class BorrowBookToBorrowHistoryMapper {
	
	public static List<BorrowHistoryResponse> mapListBorrowBookToBorrowHistory(List<BorrowBook>borrowBooks){
		
		return borrowBooks.stream().map(borrowBook-> mapBorrowBookToBorrowHistory(borrowBook)).collect(Collectors.toList());
		
	}
	
	
	public static BorrowHistoryResponse mapBorrowBookToBorrowHistory(BorrowBook BorrowBook) {
		BorrowHistoryResponse borrowHistoryResponse= new BorrowHistoryResponse();
		borrowHistoryResponse.setBookAuthor(BorrowBook.getBook().getBookAuthor());
		borrowHistoryResponse.setBookAvialabilty(BorrowBook.getBookAvialabilty());
		borrowHistoryResponse.setBookCategory(BorrowBook.getBook().getBookCategory());
		borrowHistoryResponse.setBookDetails(BorrowBook.getBook().getBookDetails());
		borrowHistoryResponse.setBookId(BorrowBook.getBook().getBookId());
		borrowHistoryResponse.setBookName(BorrowBook.getBook().getBookName());
		borrowHistoryResponse.setBorrowDate(BorrowBook.getBorrowDate());
		borrowHistoryResponse.setReturnDate(BorrowBook.getReturnDate());

	
		return borrowHistoryResponse;
	}

}
