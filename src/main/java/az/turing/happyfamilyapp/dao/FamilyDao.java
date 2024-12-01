package az.turing.happyfamilyapp.dao;

import az.turing.happyfamilyapp.entity.human.Family;

import java.util.List;
import java.util.Optional;

public interface FamilyDao {

    List<Family> getAllFamilies();

    Optional<Family> getFamilyByIndex(int index);

    boolean deleteFamilyByIndex(int index);

    boolean deleteFamily(Family family);

    Family saveFamily(Family family);

}
