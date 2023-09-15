package combookstoretask.services;

import java.time.LocalDateTime;
import java.util.List;

import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.Customer;
import combookstoretask.request.CustomerRequest;
import combookstoretask.response.BorrowHistoryResponse;

public interface ICustomer {
	
	 Customer save(CustomerRequest customerRequest );
	
	 List<BorrowHistoryResponse>  viewBorrowingHistoryForCustomer(Integer id);
	 

}
