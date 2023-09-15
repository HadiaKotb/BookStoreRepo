package combookstoretask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import combookstoretask.entities.BorrowBook;
import combookstoretask.entities.Customer;
import combookstoretask.request.CustomerRequest;
import combookstoretask.response.BorrowHistoryResponse;
import combookstoretask.services.ICustomer;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomer customerService;
	
	
	
	@PostMapping("/addCutomer")
	ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customerRequest) {
		
		Customer cutomer=customerService.save(customerRequest);
		
		return ResponseEntity.ok(cutomer);
	}
	
	@GetMapping("/viewborrowinghistory/{id}")
	ResponseEntity< List<BorrowHistoryResponse> > viewBorrowingHistoryForCustomer(@PathVariable Integer id) {
		
			return ResponseEntity.ok(customerService.viewBorrowingHistoryForCustomer(id));
	}
	

}
