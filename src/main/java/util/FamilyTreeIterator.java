package util;

import model.Person;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Person> {
    private List<Person> members;
    private int index;

    public FamilyTreeIterator(List<Person> members) {
        this.members = members;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public Person next() {
        return members.get(index++);
    }
}

