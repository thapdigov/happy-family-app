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


    /*

Implement inheritance from the Human class:
create class inheritors of the Human class: Man, Woman; prohibit the inheritance of these classes.
redefine the Human greetPet method for each subclass (the text can be selected at your discretion).
Describe each subclass's unique method of choice (e.g. makeup for women and repairCar for men).
Non-obligatory task with advanced complexity:
Create the HumanCreator interface and specify a bornChild() method, which creates a new instance of the Human class (child).
Implement the HumanCreator interface in one of the existing project classes. The implementation should
 return a new object Man or Woman with references to the current family, father's name, random name
 (you need to create a list of names in advance), and average IQ (from father and mother).
 The sex of the child is defined casually with the 50%/50% probability.
     */
}
