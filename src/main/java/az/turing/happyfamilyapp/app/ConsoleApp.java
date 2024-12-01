package az.turing.happyfamilyapp.app;

import az.turing.happyfamilyapp.controller.FamilyController;
import az.turing.happyfamilyapp.dao.CollectionFamilyDao;
import az.turing.happyfamilyapp.dao.FamilyDao;
import az.turing.happyfamilyapp.entity.human.*;
import az.turing.happyfamilyapp.entity.pet.Dog;
import az.turing.happyfamilyapp.entity.pet.Pet;
import az.turing.happyfamilyapp.entity.pet.Species;
import az.turing.happyfamilyapp.service.FamilyService;

import java.util.*;

public class ConsoleApp {
    private final FamilyDao familyDao = new CollectionFamilyDao();
    private final FamilyService familyService = new FamilyService(familyDao);

    private final FamilyController familyController = new FamilyController(familyService);

    public void run() {
        boolean flag = true;

        while (flag) {
            int menu = getInteger("""
                    1.Write families to memory
                    2.Display All Families
                    3.Enter the Family Count and Display Families larger than the number you entered
                    4.Enter the Family Count and Display Families less than the number you entered
                    5.Enter the Family Count and Display Families same the count you entered
                    6.Create new Family
                    7.Delete Family due family index
                    8.Edit Family
                    9.Exit
                    """);
            switch (menu) {
                case 1:
                    initalizeFamily();
                    break;
                case 2:
                    familyController.displayAll();
                    break;
                case 3:
                    int biggerCount = getInteger("Enter the family count:");
                    familyController.getBiggerThan(biggerCount);
                    break;
                case 4:
                    int lessCount = getInteger("Enter the family count:");
                    familyController.getLessThan(lessCount);
                case 5:
                    int familyCount = getInteger("Enter the family count:");
                    familyController.countWithMembers(familyCount);
                case 6:
                    String motherName = getString("Enter the mother name");
                    String motherSurname = getString("Enter the mother surname");
                    String motherBirtDate = getString("Enter the birtDate (dd/MM/yyyy)");
                    int motherIQ = getInteger("Enter the mother IQ");
                    Woman woman = new Woman(motherName, motherSurname, motherBirtDate, motherIQ);
                    String fatherName = getString("Enter the father name");
                    String fatherSurname = getString("Enter the father name");
                    String fatherBirtDate = getString("Enter the birtDate (dd/MM/yyyy)");
                    int fatherIQ = getInteger("Enter the fathern IQ");
                    Man man = new Man(fatherName, fatherSurname, fatherBirtDate, fatherIQ);
                    Family family = new Family(man, woman);
                    familyDao.saveFamily(family);
                    System.out.println("Family has been created succesfully!\n");
                    break;
                case 7:
                    int familyIndex = getInteger("Enter the familyIndex you want to delete");
                    boolean deletedFamily = familyController.deleteByIndex(familyIndex);
                    if (deletedFamily) {
                        System.out.println("Family has been deleted succesfuly!");
                    }
                    break;
                case 8:
                    List<Family> familyList = familyController.getAll();
                    if (familyList.isEmpty()) {
                        System.out.println("There are not any family!");
                        break;
                    }
                    int editFamily = getInteger("Enter the family ID you want to edit family");
                    Family editfamily = familyList.get(editFamily);
                    int childMenu = getInteger("""
                            1.Burn Child
                            2.Adopt child
                            3.Back to menu
                            """);
                    switch (childMenu) {
                        case 1:
                            Human isMan = editfamily.burnChild();
                            editfamily.addChild(isMan);
                            familyDao.saveFamily(editfamily);
                            break;
                        case 2:
                            String childName = getString("Enter the mother name");
                            String childSurname = getString("Enter the mother surname");
                            String childBirtDate = getString("Enter the birtDate (dd/MM/yyyy");
                            int childIQ = getInteger("Enter the mother IQ");
                            Human adoptChild = new Human(childName, childSurname, childBirtDate, childIQ);
                            editfamily.addChild(adoptChild);
                            familyDao.saveFamily(editfamily);
                            break;
                        case 3:
                            run();
                            break;
                        default:
                            System.out.println("Invalid menu!");
                            break;
                    }
                    break;
                case 9:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input!");
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
        Woman child = new Woman("Mila", "Franckovic", "22/01/2014", 84, schedule);
        Map<DayOfWeek, String> schedule2 = new HashMap<>();
        schedule.put(DayOfWeek.THIRSDAY, "Go to the Cinema!");
        Man child2 = new Man("Alex", "Tomas", "22/01/2006", 84, schedule2);
        Map<DayOfWeek, String> schedule3 = new HashMap<>();
        schedule.put(DayOfWeek.SUNDAY, "Go to the Cinema!");
        Woman child3 = new Woman("Alisa", "Jesus", "19/09/2016", 84, schedule3);

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

    public String getString(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.print(title + ": ");
        return sc.nextLine();
    }

    public Integer getInteger(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.print(title + ": ");
        return sc.nextInt();
    }
}
