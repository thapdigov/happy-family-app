package az.turing.happyfamilyapp.entity.pet;

public class Dog extends Pet implements FoulPet {
    public Dog(Species species, String nickName, Integer age, Integer trickLevel, String[] habbits) {
        super(species, nickName, age, trickLevel, habbits);
    }

    @Override
    public void respond() {
        System.out.printf("Hello,owner. I am %s.I miss you!", Species.DOG.name());
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up!");
    }
}
