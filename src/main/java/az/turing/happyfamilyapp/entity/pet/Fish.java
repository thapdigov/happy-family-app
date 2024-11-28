package az.turing.happyfamilyapp.entity.pet;

public class Fish extends Pet {
    @Override
    public void respond() {
        System.out.printf("Hello,owner. I am %s.I miss you!", Species.FISH.name());
    }
}
