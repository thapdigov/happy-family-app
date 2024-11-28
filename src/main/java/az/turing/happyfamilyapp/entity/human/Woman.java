package az.turing.happyfamilyapp.entity.human;

public final class Woman extends Human {
    public Woman(String name, String surname) {
        super(name, surname);
    }

    public Woman(String name, String surname, String dateOfYear) {
        super(name, surname, dateOfYear);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello  my friend!,%s", getPet().getNickName());
    }

    public void makeUp() {
        System.out.println("Women are valuable to men");
    }
}
