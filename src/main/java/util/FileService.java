package util;

import model.FamilyTree;

public interface FileService {
    void saveToFile(FamilyTree familyTree, String fileName);
    FamilyTree loadFromFile(String fileName);
}
