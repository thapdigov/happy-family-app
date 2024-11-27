package az.turing.happyfamilyapp.entity;

import java.util.Arrays;

public class Pet {
    String species;
    String nickName;
    Integer age;
    Integer trickLevel;
    String[] habbits;

    public Pet() {
    }

    public Pet(String species, String nickName) {
        this.species = species;
        this.nickName = nickName;
    }

    public Pet(String species, String nickName, Integer age, Integer trickLevel, String[] habbits) {
        this.species = species;
        this.nickName = nickName;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habbits = habbits;
    }

    public void eat() {
        System.out.println("I am eating!");
    }

    public void respond() {
        System.out.printf("Hello,owner. I am %s.I miss you!", nickName);
    }

    public void foul() {
        System.out.println("I need to cover it up!");
    }

    @Override
    public String toString() {
        return species + "{nickName=" + nickName + " ,age=" + age + "  ,trickLevel=" + trickLevel +
                " ,habbits=" + Arrays.toString(habbits);
    }

}


