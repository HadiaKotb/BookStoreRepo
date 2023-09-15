package combookstoretask.reposiotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.Customer;

@Repository
public interface CustomerRepoisotry extends JpaRepository<Customer, Integer> {

	@Query("SELECT bb FROM Customer c " +
			"JOIN c.borrowBooks bb " +
			"WHERE c.customerId = :customerId")
	List<BorrowBook> findBorrowBookForCustomer(@Param("customerId") Integer customerId);
	
}
