package combookstoretask.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.Customer;
import combookstoretask.exception.ResourceNotFoundException;
import combookstoretask.mapper.BorrowBookToBorrowHistoryMapper;
import combookstoretask.mapper.CustomerRequestToEntityMapper;
import combookstoretask.reposiotry.CustomerRepoisotry;
import combookstoretask.request.CustomerRequest;
import combookstoretask.response.BorrowHistoryResponse;
import combookstoretask.services.ICustomer;


@Service
public class CustomerService implements ICustomer {

	@Autowired
	CustomerRepoisotry customerRepo;
	@Override
	public Customer save(CustomerRequest customerRequest) {
		// TODO Auto-generated method stub
			
			return customerRepo.save(CustomerRequestToEntityMapper.mapBorrowRequestToEntity(customerRequest));
		
		
	}
	@Override
	public List<BorrowHistoryResponse> viewBorrowingHistoryForCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("No Customer Found with  id: " + customerId));
		return BorrowBookToBorrowHistoryMapper.mapListBorrowBookToBorrowHistory(customerRepo.findBorrowBookForCustomer(customerId));
	}

}
