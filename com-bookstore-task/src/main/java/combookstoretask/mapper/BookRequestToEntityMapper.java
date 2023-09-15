package combookstoretask.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import combookstoretask.entities.Book;
import combookstoretask.request.BookRequest;

public class BookRequestToEntityMapper {
	
	
	public static List<Book> mapListBookRequestToEntity(List<BookRequest>bookRequests){
		
		return bookRequests.stream().map(book-> mapBookRequestToEntity(book)).collect(Collectors.toList());
		
	}
	
	
	public static Book mapBookRequestToEntity(BookRequest bookRequest) {
		Book book=new Book();
		book.setBookAuthor(bookRequest.getBookAuthor());
		book.setBookCategory(bookRequest.getBookCategory());
		book.setBookDetails(bookRequest.getBookDetails());
		book.setBookName( bookRequest.getBookName());
	
		return book;
	}


}
