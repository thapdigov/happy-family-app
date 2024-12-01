package az.turing.happyfamilyapp.dao;

import az.turing.happyfamilyapp.entity.human.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionFamilyDao implements FamilyDao {

    List<Family> familyList = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Optional<Family> getFamilyByIndex(int index) {
        return index >= 0 && index < familyList.size() ? Optional.ofNullable(familyList.get(index)) : Optional.empty();
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        if (index >= 0 && index < familyList.size()) {
            familyList.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyList.contains(family) && familyList.remove(family);
    }

    @Override
    public Family saveFamily(Family family) {
        if (!(familyList.contains(family))) {
            familyList.add(family);
        }
        return family;
    }
}
