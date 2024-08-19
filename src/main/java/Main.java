import model.FamilyTree;
import model.Person;
import service.FileServiceImpl;
import util.FileService;



public class Main {
    public static void main(String[] args) {

        Person john = new Person("John Doe", "1950-01-01", null);
        Person jane = new Person("Jane Doe", "1955-02-02", null);
        Person child1 = new Person("Child One", "1980-03-03", null);
        Person child2 = new Person("Child Two", "1982-04-04", null);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(john);
        familyTree.addPerson(jane);
        familyTree.addPerson(child1);
        familyTree.addPerson(child2);

        john.addChild(child1);
        john.addChild(child2);
        jane.addChild(child1);
        jane.addChild(child2);

        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName());
        }

        familyTree.sortByBirthDate();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthDate());
        }

        FileService fileService = new FileServiceImpl();
        fileService.saveToFile(familyTree, "family_tree.dat");

        FamilyTree loadedTree = fileService.loadFromFile("family_tree.dat");
        if (loadedTree != null) {
            for (Person person : loadedTree) {
                System.out.println(person.getName());
            }
        }
    }
}

