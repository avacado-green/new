package model;

import util.FamilyTreeIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

public class FamilyTree implements Iterable<Person> {
    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.members.add(person);
    }

    public Person findPersonByName(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getDescendants(Person person) {
        List<Person> descendants = new ArrayList<>();
        getDescendantsHelper(person, descendants);
        return descendants;
    }

    private void getDescendantsHelper(Person person, List<Person> descendants) {
        for (Person child : person.getChildren()) {
            descendants.add(child);
            getDescendantsHelper(child, descendants);
        }
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<Person> iterator() {
        return new FamilyTreeIterator(members);
    }
}

