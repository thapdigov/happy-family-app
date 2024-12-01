package az.turing.happyfamilyapp.app;

import az.turing.happyfamilyapp.controller.FamilyController;
import az.turing.happyfamilyapp.dao.CollectionFamilyDao;
import az.turing.happyfamilyapp.dao.FamilyDao;
import az.turing.happyfamilyapp.entity.human.*;
import az.turing.happyfamilyapp.entity.pet.Dog;
import az.turing.happyfamilyapp.entity.pet.Pet;
import az.turing.happyfamilyapp.entity.pet.Species;
import az.turing.happyfamilyapp.service.FamilyService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsoleApp {
    private final FamilyDao familyDao = new CollectionFamilyDao();
    private final FamilyService familyService = new FamilyService(familyDao);

    private final FamilyController familyController = new FamilyController(familyService);

    public void run() {
        boolean flag = true;

        while (flag) {
            int menu = InputUtil.getInteger("""
                    1.Write families to memory
                    2.Display All Families
                    3.Exit
                    """);
            switch (menu) {
                case 1 -> initalizeFamily();
                case 2 -> familyController.displayAll();
                case 3 -> flag = false;
                default -> System.out.println("Invalid input!");
            }
        }
    }


    public void initalizeFamily() {

        Man father1 = new Man("Liam", "Franckovic", "23/04/1996", 86);
        Man father2 = new Man("Muller", "Tomas", "22/06/1984", 80);
        Man father3 = new Man("Jord", "Jesus", "02/03/1978", 80);


        Woman mother1 = new Woman("Olivia", "Franckovic", "15/07/1998", 88);
        Woman mother2 = new Woman("Adelya", "Tomas", "11/02/1988", 76);
        Woman mother3 = new Woman("Ayla", "Jesus", "15/04/1980", 76);


        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "Go to school!");
        Human child = new Woman("Mila", "Franckovic", "22/01/2014", 84, schedule);
        Map<DayOfWeek, String> schedule2 = new HashMap<>();
        schedule.put(DayOfWeek.THIRSDAY, "Go to the Cinema!");
        Human child2 = new Woman("Sia", "Tomas", "22/01/2006", 84, schedule2);
        Map<DayOfWeek, String> schedule3 = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY, "Go to the Cinema!");
        Human child3 = new Woman("Alisa", "Jesus", "19/09/2016", 84, schedule3);

        Set<String> habbits = new HashSet<>();
        habbits.add("clever");
        habbits.add("friendly");
        Pet pet1 = new Dog(Species.DOG, "Rex", 5, 75, habbits);
        Set<String> habbits2 = new HashSet<>();
        habbits.add("sleep");
        habbits.add("miyau");
        Pet pet2 = new Dog(Species.DOMESTICCAT, "mestan", 2, 55, habbits2);
        Set<String> habbits3 = new HashSet<>();
        habbits.add("eat");
        habbits.add("sleep");
        Pet pet3 = new Dog(Species.DOG, "Rex", 5, 75, habbits);


        Family family1 = new Family(father1, mother1);
        family1.addChild(child);
        family1.setPet(pet1);
        familyDao.saveFamily(family1);

        Family family2 = new Family(father2, mother2);
        family2.addChild(child2);
        family2.setPet(pet2);
        familyDao.saveFamily(family2);

        Family family3 = new Family(father3, mother3);
        family3.addChild(child3);
        family3.setPet(pet3);
        familyDao.saveFamily(family3);
    }


    /*
   The application has the following hierarchical command structure:
- 1. Fill with test data (create several families and save them in the database)
- 2. Display the entire list of families (displays a list of all families with indexation starting with 1)
- 3. Display a list of families where the number of people is greater than the specified number
  - request a number one you interested in
- 4. Display a list of families where the number of people is less than the specified number
  - request a number one you interested in
- 5. Calculate the number of families where the number of members is
  - request a number one you interested in
- 6. Create a new family
  - request for the mother's name
  - request mother's last name
  - request mother's birth year
  - request mother's month of birth
  - request mother's birthday
  - request mother's iq

  - request for the father's name
  - request father's last name
  - request father's birth year
  - request father's month of birth
  - request father's birthday
  - request father's iq
- 7. Delete a family by its index in the general list
  - request identifier (ID)
- 8. Edit a family by its index in the general list
  - 1. Give birth to a baby
    - request family identifier (ID)
    - request the necessary data (what name to give the boy, what name to girl)
  - 2. Adopt a child
    - request family identifier (ID)
    - request Required data (full name, year of birth, intelligence)
  - 3. Return to main menu
- 9. Remove all children over the age of majority (all families remove children over the age of majority - let us assume they have grown up)
  - request interested age
The user selects the menu item of interest in its serial number.
Handle all possible exceptions related to incorrect data entry by the user.
Create your own exception FamilyOverflowException, inherited from RuntimeException. Drop it if the family size is larger than [any desired number] of people and the family is trying to give birth to/adopt a child. Process it in the controller.
     */
}
