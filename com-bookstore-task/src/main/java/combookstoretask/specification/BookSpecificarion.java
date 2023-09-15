package combookstoretask.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import combookstoretask.entities.Book;
import jakarta.persistence.criteria.Predicate;

public interface BookSpecificarion {
	
	public static Specification<Book> createBookSpecification(String bookName, String bookCategory, String bookAuthor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (bookName != null) {
				predicates.add(cb.and(cb.equal(root.get("bookName"), bookName)));
			}

			if (bookCategory != null) {
				predicates.add(cb.and(cb.equal(root.get("bookCategory"), bookCategory)));
			}

			if (bookAuthor != null) {
				predicates.add(cb.and(cb.equal(root.get("bookAuthor"), bookAuthor)));
			}

			
			return cb.and(predicates.toArray(Predicate[]::new));
		};
		
	}

}
