package az.turing.happyfamilyapp;

import az.turing.happyfamilyapp.entity.Human;
import az.turing.happyfamilyapp.entity.Pet;

public class FamilyApp {
    public static void main(String[] args) {

        Human mother = new Human("Mila", "Baydon", "1978/11/25");
        Human father = new Human("Alex", "Baydon", "1974/04/16");
        Pet pet = new Pet("Dog", "Rex", 3, 60, new String[]{"clever,friendly"});
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Monday";
        schedule[0][1] = "Go to the fitnes";
        Human child = new Human("Sia", "Baydon", "2020/02/08", 85,
                pet, mother, father, schedule);
        System.out.println(child);
    }
}
