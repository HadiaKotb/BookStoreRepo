package combookstoretask.reposiotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import combookstoretask.entities.Book;
import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.enums.BookAvialabilty;

public interface BorrowBookRepoisotry extends JpaRepository<BorrowBook, Integer> {

	@Query("SELECT bb FROM Book b " +
			"JOIN b.borrowBook bb " +
			"WHERE bb.book.bookId = :bookId")
	Optional<BorrowBook> findBorrowBookFromBook(@Param("bookId") Integer bookId);
	

}
