package combookstoretask.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import combookstoretask.entities.enums.CustomerRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	 @Enumerated(EnumType.STRING)
	 private CustomerRole customerRole;
	 
	 private String firstName;
	 
	 private String lastName;
	 
	// @OneToMany(mappedBy = "cutomer", cascade = CascadeType.ALL)
	//private Set<Book> Books;
	 @JsonIgnore
	 @OneToMany(mappedBy = "customer")
	 private Set<BorrowBook> borrowBooks;
	 
	

}
