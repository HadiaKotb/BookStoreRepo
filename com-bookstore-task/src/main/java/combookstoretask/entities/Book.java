package combookstoretask.entities;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column(unique=true)
	private String bookName;
	
	private String bookCategory;
	
	private String bookAuthor;
	
	private String bookDetails;
	
	
	
	@JsonIgnore
    @OneToOne(mappedBy = "book")
	private BorrowBook borrowBook;
	
	
	
	
	
	
	
}
