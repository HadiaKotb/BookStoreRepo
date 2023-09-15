package combookstoretask.entities;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import combookstoretask.entities.enums.BookAvialabilty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BorrowBook")
public class BorrowBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer borrowId;
	
	@ManyToOne()
	
	@JoinColumn(name = "customer_Id")
	private Customer customer;
	
	@OneToOne()	
	@JoinColumn(name = "book_id")
	private Book book;
	private LocalDateTime  borrowDate;
	
	private LocalDateTime  returnDate;
	
	private BookAvialabilty BookAvialabilty;

	
	
}
