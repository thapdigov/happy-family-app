package az.turing.happyfamilyapp.entity.human;

import az.turing.happyfamilyapp.entity.pet.Pet;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Integer IQ;
    private Map<DayOfWeek, String> schedule;
    private Family family;
    private Pet pet;

    public Human() {
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, String birthDate, Integer IQ) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.IQ = IQ;
    }

    public Human(String name, String surname, String birthDate, Integer IQ, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.IQ = IQ;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public void setbirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getIQ() {
        return IQ;
    }

    public void setIQ(Integer IQ) {
        this.IQ = IQ;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name) && surname.equals(human.surname) &&
                Objects.equals(birthDate, human.birthDate) &&
                Objects.equals(IQ, human.IQ);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthDate, IQ);
        result = 31 * result;
        return result;
    }

    public String describeAge() {
        Period age = Period.between(getbirthDate(), LocalDate.now());
        return String.format("age=%d ,month=%d ,day=%s", age.getYears(), age.getMonths(), age.getDays());
    }

    public void greetPet() {
        System.out.printf("Hello ,%s", pet.getNickName());
    }

    public void describePet(int sly) {
        String petSly = sly > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s is %d years old,he is %s.", pet.getSpecies(), pet.getAge(), petSly);
    }

    public boolean feedPet(boolean isItTimeForFeeding) {
        if (pet == null) {
            System.out.println("There is no pet to feed.");
            return false;
        }
        if (isItTimeForFeeding) {
            System.out.printf("Hm... I will feed %s's %s.", name, pet.getSpecies());
            return true;
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            if (pet.getTrickLevel() > randomNumber) {
                System.out.printf("Hm... I will feed %s's %s.", name, pet.getSpecies());
                return true;
            } else {
                System.out.printf("I think %s is not hungry.%n", name);
                return false;
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is being removed!: " + this.toString());
        super.finalize();
    }

    @Override
    public String toString() {
        return "name=" + getName() + " ,surname=" + getSurname() +
                " ,birthDate=" + getbirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ,IQ=" + getIQ() +
                " ,schedule=" + schedule;
    }
}
