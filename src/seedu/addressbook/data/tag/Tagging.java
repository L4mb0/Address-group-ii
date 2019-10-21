package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

import java.util.Set;

public class Tagging {
    Person person;
    Tag tag;
    String operation;

    Tagging (Person person, Tag tag, String operation){
        this.person = person;
        this.tag = tag;
        this.operation = operation;
        Set<Tag> tags = person.getTags();
        if (operation.equals("add")){
            tags.add(tag);
            person.setTags(tags);
        }else if (operation.equals("remove")){
            tags.remove(tag);
            person.setTags(tags);
        }
    }

}
