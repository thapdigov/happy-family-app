package az.turing.happyfamilyapp.entity.pet;

public class RobotCat extends Pet {
    @Override
    public void respond() {
        System.out.printf("Hello,owner. I am %s.I miss you!", Species.ROBOTCAT.name());
    }
}
