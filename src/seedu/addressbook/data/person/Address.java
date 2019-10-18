package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String [] arrAddress=trimmedAddress.split(" ");
        System.err.println("Imprimiendo direccion  "+trimmedAddress);
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
class Block{
	private String valueBlock;

	public String getBlock() {
    		return valueBlock;
  	}

  
  	public void setBlock(String newBlock) {
    		this.valueBlock = newBlock;
  	}
}
class Street{
    private String valueStreet;

    public String getStreet(){
    	return valueStreet;
    }

    public void setStreet(String newStreet){
    	this.valueStreet = newStreet;
    }
}

class Unit{
    private String valueUnit;

    public String getUnit(){
    	return valueUnit;
    }

    public void setUnit(String newUnit){
    	this.valueUnit = newUnit;
    }
}
class PostalCode{
    private String valuePostalCode;

    public String getPostalCode(){
    	return valuePostalCode;
    }

    public void setPostalCode(String newPostalCode){
    	this.valuePostalCode = newPostalCode;
    }
}
