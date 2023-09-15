package combookstoretask.services.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import combookstoretask.entities.Book;
import combookstoretask.entities.Customer;
import combookstoretask.entities.enums.CustomerRole;
import combookstoretask.exception.PremessionException;
import combookstoretask.exception.ResourceNotFoundException;
import combookstoretask.mapper.BookRequestToEntityMapper;
import combookstoretask.reposiotry.BookReposiotry;
import combookstoretask.reposiotry.CustomerRepoisotry;
import combookstoretask.request.BookRequest;
import combookstoretask.services.IBook;
import combookstoretask.specification.BookSpecificarion;


@Service
public class BookService implements IBook {
	@Autowired
	BookReposiotry bookReposiotry;
	@Autowired
	CustomerRepoisotry customerReposiotry;
	
	
	@Override
	public List<Book> browseBooksByCategory(String bookName, String bookCategory, String bookAuthor) {
		// TODO Auto-generated method stub
		Specification<Book> bookSpecificarion;

		bookSpecificarion = BookSpecificarion.createBookSpecification(bookName,bookCategory,bookAuthor);
		

		return bookReposiotry.findAll(bookSpecificarion);
		
	}

	@Override
	public Book viewBookDetails(Integer bookId) {
		// TODO Auto-generated method stub
		return bookReposiotry.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("No Customer Found with  id: " + bookId));
	}


	@Override
	public List<Book> addBookForAdmin(Integer customerId,List<BookRequest>books) {
		// TODO Auto-generated method stub
		Customer customer= customerReposiotry.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("No Customer Found with  id: " + customerId));
		if(CustomerRole.ADMIN.name().equalsIgnoreCase(customer.getCustomerRole().name())) {
			
			return bookReposiotry.saveAll(BookRequestToEntityMapper.mapListBookRequestToEntity(books));
			
		}else {
			throw new PremessionException("You are not allowed to add Books");
		}
			
			
	
	}

	@Override
	public void deleteBookForAdmin(Integer customerId, Integer bookId) {
		// TODO Auto-generated method stub
		
		Customer customer= customerReposiotry.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("No Customer Found with  id: " + customerId));
		if(CustomerRole.ADMIN.name().equalsIgnoreCase(customer.getCustomerRole().name())) {
			if(bookReposiotry.findBorrowBookFromBook(bookId)==null) {
			
				bookReposiotry.deleteById(bookId);
			}else {
				throw new PremessionException("You are not allowed to delete Books already Bokked");
			}
			
		}else {
			throw new PremessionException("You are not allowed to delete Books");
		}
		
	}

	
	


	
	
}
