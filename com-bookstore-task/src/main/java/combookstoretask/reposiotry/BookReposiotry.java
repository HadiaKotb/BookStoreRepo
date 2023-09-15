package combookstoretask.reposiotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import combookstoretask.entities.Book;
import combookstoretask.entities.BorrowBook;

@Repository
public interface BookReposiotry extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
	
	@Query("SELECT bb FROM Book b " +
			"JOIN b.borrowBook bb " +
			"WHERE bb.book.bookId = :bookId")
	BorrowBook findBorrowBookFromBook(@Param("bookId") Integer bookId);

}
