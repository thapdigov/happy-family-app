package az.turing.happyfamilyapp.entity.human;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname) {
        super(name, surname);
    }
    public Woman(String name, String surname, String dateOfYear, Integer IQ) {
        super(name, surname, dateOfYear, IQ);
    }

    public Woman(String name, String surname, String birthDate, Integer IQ, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, IQ, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello  my friend!,%s", getPet().getNickName());
    }

    public void makeUp() {
        System.out.println("Women are valuable to men");
    }
}
