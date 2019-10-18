package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact implements Printable{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private Block block=new Block();
    private Street street=new Street();
    private Unit unit=new Unit();
    private PostalCode postalCode=new PostalCode();

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        block=new Block();
        street=new Street();
        unit=new Unit();
        postalCode=new PostalCode();

        String trimmedAddress = address.trim();
        block.setBlock("");
        street.setStreet("");
        unit.setUnit("");
        postalCode.setPostalCode("");
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String [] arrAddress=trimmedAddress.split(",");
        for(int i=0;i<arrAddress.length;i++){
            if(i==0)
                block.setBlock(arrAddress[0]);
            else if(i==1)
                street.setStreet(arrAddress[1]);
            else if(i==2)
                unit.setUnit(arrAddress[2]);
            else if(i==3)
                postalCode.setPostalCode(arrAddress[3]);
        }
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
        String valuetmp=block.getBlock();
        if(street.getStreet()!="")
            valuetmp+=(valuetmp=="")?street.getStreet():(","+street.getStreet());
        if(unit.getUnit()!="")
            valuetmp+=(valuetmp=="")?unit.getUnit():(","+unit.getUnit());
        if(postalCode.getPostalCode()!="")
            valuetmp+=(valuetmp=="")?postalCode.getPostalCode():(","+postalCode.getPostalCode());

        return valuetmp;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public void getPrintableString() {
        System.out.println("Address : "+toString());
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
