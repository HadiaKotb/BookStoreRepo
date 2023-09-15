package combookstoretask.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum CustomerRole {
	USER("USER"),
	ADMIN("ADMIN");
	String name;
	
	  CustomerRole(String name) {
		// TODO Auto-generated constructor stub
		  this.name=name;
	}

	public String getName(){
		  return this.name;
		  }

  @JsonCreator
    public static CustomerRole fromString(String input) {
        if (input != null) {
            for (CustomerRole customerRole : CustomerRole.values()) {
                if (customerRole.name().equalsIgnoreCase(input)) {
                    return customerRole;
                }
            }
        }
        throw new IllegalArgumentException("Invalid CustomerRole: " + input);

    }
  @Override
  public String toString() {
      return this.name();
  }
	
}
