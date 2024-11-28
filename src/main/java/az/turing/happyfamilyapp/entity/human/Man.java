package az.turing.happyfamilyapp.entity.human;

public final class Man extends Human {
    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, String dateOfYear) {
        super(name, surname, dateOfYear);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello ,%s", getPet().getNickName());
    }

    public void repairCar() {
        System.out.println("A man's car is cleaner than a woman's house!");
    }
}
