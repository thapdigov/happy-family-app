package az.turing.happyfamilyapp.service;

import az.turing.happyfamilyapp.dao.FamilyDao;
import az.turing.happyfamilyapp.entity.human.Family;
import az.turing.happyfamilyapp.entity.human.Human;
import az.turing.happyfamilyapp.entity.human.Man;
import az.turing.happyfamilyapp.entity.human.Woman;
import az.turing.happyfamilyapp.entity.pet.Pet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class FamilyService {

    private final FamilyDao familyDao;


    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> familyList = familyDao.getAllFamilies();
        for (Family family : familyList) {
            System.out.println(family.prettyFormat());
        }
    }

    public Optional<List<Family>> getFamiliesBiggerThan(int count) {
        if (count > 0 || familyDao.getAllFamilies().stream().allMatch(family -> count < family.getCountFamily())) {
            return Optional.of(familyDao.getAllFamilies().stream()
                    .filter(family -> family.getCountFamily() > count).collect(Collectors.toList()));
        }
        return Optional.empty();
    }

    public Optional<List<Family>> getFamiliesLessThan(int count) {
        if (count > 0 || familyDao.getAllFamilies().stream().allMatch(family -> count < family.getCountFamily())) {
            return Optional.of(familyDao.getAllFamilies().stream()
                    .filter(family -> family.getCountFamily() < count).collect(Collectors.toList()));
        }
        return Optional.empty();
    }

    public Long countFamiliesWithFamilyMembers(int count) {
        return familyDao.getAllFamilies().stream().filter(family -> family.getCountFamily() == count).count();
    }

    public Family createFamily(Human father, Human mother) {
        Family family = new Family(father, mother);
        return familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamilyByIndex(index);
    }

    public void burnChild(Family family, String masculine, String feminine) {
        boolean isMan = new Random().nextBoolean();
        String childName = isMan ? masculine : feminine;
        int childIQ = (family.getFather().getIQ() + family.getMother().getIQ()) / 2;
        Human burnChild = isMan ? new Man(childName, family.getFather().getSurname(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), childIQ) : new Woman(childName, family.getFather().getSurname(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), childIQ);
        family.addChild(burnChild);
        familyDao.saveFamily(family);
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        LocalDateTime now = LocalDateTime.now();
        List<Family> familyList = familyDao.getAllFamilies();
        for (Family family : familyList) {
            List<Human> children = family.getChildren().stream().
                    filter(child -> now.getYear() - child.getbirthDate().getYear() < age).toList();
            family.setChildren(children);
            familyDao.saveFamily(family);
        }
    }

    public int getFamiliesCount() {
        return familyDao.getAllFamilies().size();
    }

    public Optional<Family> getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public void addPet(int familyIndex, Pet pet) {
        Family family = familyDao.getFamilyByIndex(familyIndex).get();
        if (pet != null) {
            family.setPet(pet);
            familyDao.saveFamily(family);
        }
    }
}

