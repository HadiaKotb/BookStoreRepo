package combookstoretask.mapper;


import combookstoretask.entities.Customer;

import combookstoretask.entities.enums.CustomerRole;

import combookstoretask.request.CustomerRequest;

public class CustomerRequestToEntityMapper {
	
	public static Customer mapBorrowRequestToEntity(CustomerRequest customerRequest) {
		Customer customer=new Customer();
		customer.setCustomerRole(CustomerRole.fromString(customerRequest.getCustomerRole()));
		customer.setFirstName(customerRequest.getFirstName());
		customer.setLastName(customerRequest.getLastName());
		return customer;
	}


}
