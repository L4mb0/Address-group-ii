package seedu.addressbook.data;

import seedu.addressbook.commands.Command;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.UniquePersonList.DuplicatePersonException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tagging;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents the entire address book. Contains the data of the address book.
 */
public class AddressBook {

    private final UniquePersonList allPersons;
    private final Set<Tagging> taggings = new HashSet<>();

    /**
     * Creates an empty address book.
     */
    public AddressBook() {
        allPersons = new UniquePersonList();
    }

    /**
     * Constructs an address book with the given data.
     *
     * @param persons external changes to this will not affect this address book
     */
    public AddressBook(UniquePersonList persons) {
        this.allPersons = new UniquePersonList(persons);
    }

    /**
     * Adds a person to the address book.
     *
     * @throws DuplicatePersonException if an equivalent person already exists.
     */
        public void addPerson(Person toAdd) throws DuplicatePersonException {
        allPersons.add(toAdd);
        ListAllPersons();
    }

    public void ListAllPersons(){
            for(Person p :allPersons)
                System.out.println(p.getName());
    }

    /**
     * Returns true if an equivalent person exists in the address book.
     */
    public boolean containsPerson(ReadOnlyPerson key) {
        return allPersons.contains(key);
    }

    /**
     * Removes the equivalent person from the address book.
     *
     * @throws PersonNotFoundException if no such Person could be found.
     */
    public void removePerson(ReadOnlyPerson toRemove) throws PersonNotFoundException {
        allPersons.remove(toRemove);
        ListAllPersons();
    }

    /**
     * Clears all persons and tags from the address book.
     */
    public void clear() {
        allPersons.clear();
    }

    /**
     * Add a new Tagging
     */
    public void setTagging(Tagging tagging) {
        taggings.add(tagging);
    }

    /**
     * Return Tagging List
     */
    public Set<Tagging> getTagging() {
        return taggings;
    }

    /**
     * Returns a new UniquePersonList of all persons in the address book at the time of the call.
     */
    public UniquePersonList getAllPersons() {
        return new UniquePersonList(allPersons);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                        && this.allPersons.equals(((AddressBook) other).allPersons));
    }


}
