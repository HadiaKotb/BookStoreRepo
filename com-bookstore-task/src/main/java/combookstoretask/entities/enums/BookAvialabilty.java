package combookstoretask.entities.enums;

public enum BookAvialabilty {
	AVAILABLE,
	PENDING,
    APPROVED,
    REJECTED,
    RETURNED;
    
    
    public static BookAvialabilty fromString(String input) {
        if (input != null) {
            for (BookAvialabilty bookAvialabilty : BookAvialabilty.values()) {
                if (bookAvialabilty.name().equalsIgnoreCase(input)) {
                    return bookAvialabilty;
                }
            }
        }
        throw new IllegalArgumentException("Invalid Book Avilabilty : " + input);

    }
	

}
