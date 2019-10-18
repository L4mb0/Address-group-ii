package seedu.addressbook.data.person;

class Contact {
    protected String value;
    protected boolean isPrivate;

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }



}
