package az.turing.happyfamilyapp;

import az.turing.happyfamilyapp.entity.*;

public class FamilyApp {
    public static void main(String[] args) {

//        Human mother = new Human("Mila", "Baydon", "1978/11/25");
//        Human father = new Human("Alex", "Baydon", "1974/04/16");
//        Pet pet = new Pet(Species.DOG, "Rex", 3, 60, new String[]{"clever,friendly"});
//
//        String[][] schedule = new String[1][2];
//        schedule[0][0] = DayOfWeek.MONDAY.name();
//        schedule[0][1] = "Go to the fitness!";
//        Human child = new Human("Sia", "Baydon", "2020/02/05", 85, schedule);
//        Human child1 = new Human("Ayxan", "Baydon", "2021/02/05", 85, schedule);
//        Family family = new Family(father, mother);
//        family.addChild(child);
//        family.addChild(child1);
//        family.setPet(pet);
//        System.out.println(family);
//        family.removeChild(child);
//        System.out.println(family);
        for (int i = 0; i < 100000; i++) {
            Family family = new Family(new Human("Father", "Lastname"), new Human("Mother", "Lastname"));
        }
        System.gc();
    }
}
