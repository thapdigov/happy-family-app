package az.turing.happyfamilyapp.entity.pet;

import java.util.Set;

public class Fish extends Pet {

    public Fish(Species species, String nickName, Integer age, Integer trickLevel, Set<String> habbits) {
        super(species, nickName, age, trickLevel, habbits);
    }

    @Override
    public void respond() {
        System.out.printf("Hello,owner. I am %s.I miss you!", Species.FISH.name());
    }
}
