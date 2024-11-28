package az.turing.happyfamilyapp;

import az.turing.happyfamilyapp.entity.human.*;
import az.turing.happyfamilyapp.entity.pet.Dog;
import az.turing.happyfamilyapp.entity.pet.Pet;
import az.turing.happyfamilyapp.entity.pet.Species;

public class FamilyApp {
    public static void main(String[] args) {

        Human mother = new Woman("Mila", "Baydon", "1978/11/25");
        Human father = new Man("Alex", "Baydon", "1974/04/16");
        Pet pet = new Dog(Species.DOG, "Rex", 3, 60, new String[]{"clever,friendly"});

        String[][] schedule = new String[1][2];
        schedule[0][0] = DayOfWeek.MONDAY.name();
        schedule[0][1] = "Go to the fitness!";
        Human child = new Human("Sia", "Baydon", "2020/02/05", 85, schedule);
        // Human child1 = new Human("Ayxan", "Baydon", "2021/02/05", 85, schedule);
        Family family = new Family(father, mother);
        family.addChild(child);
        family.setPet(pet);
        System.out.println(family);

    }
}
