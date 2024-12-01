package az.turing.happyfamilyapp.entity.human;

import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname) {
        super(name, surname);
    }

    public Man(String name, String surname, String dateOfYear, Integer IQ) {
        super(name, surname, dateOfYear, IQ);
    }

    public Man(String name, String surname, String birthDate, Integer IQ, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, IQ, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello ,%s", getPet().getNickName());
    }

    public void repairCar() {
        System.out.println("A man's car is cleaner than a woman's house!");
    }
}
