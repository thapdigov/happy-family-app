package az.turing.happyfamilyapp.entity;

import java.util.Random;

public class Human {
    String name;
    String surname;
    String dateOfYear;
    Integer IQ;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, String dateOfYear) {
        this.name = name;
        this.surname = surname;
        this.dateOfYear = dateOfYear;
    }

    public Human(String name, String surname, String dateOfYear, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.dateOfYear = dateOfYear;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, String dateOfYear, Integer IQ, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.dateOfYear = dateOfYear;
        this.IQ = IQ;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public void greetPet() {
        System.out.printf("Hello ,%s", pet.nickName);
    }

    public void describePet(int sly) {
        String petSly = sly > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s is %d years old,he is %s.", pet.species, pet.age, petSly);
    }

    public boolean feedPet(boolean isItTimeForFeeding) {
        if (pet == null) {
            System.out.println("There is no pet to feed.");
            return false;
        }
        if (isItTimeForFeeding) {
            System.out.printf("Hm... I will feed %s's %s.", name, pet.species);
            return true;
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            if (pet.trickLevel > randomNumber) {
                System.out.printf("Hm... I will feed %s's %s.", name, pet.species);
                return true;
            } else {
                System.out.printf("I think %s is not hungry.%n", name);
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Human{ " + "name=%s ,surname=%s ,year=%s,i q=%d".formatted(name, surname, dateOfYear, IQ) +
                " ,mother=%s %s".formatted(mother.name, mother.surname) + " ,father=%s %s".formatted(father.name, father.surname) +
                " ,pet=%s" + pet;
    }
}
