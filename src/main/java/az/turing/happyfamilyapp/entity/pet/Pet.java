package az.turing.happyfamilyapp.entity.pet;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private Species species;
    private String nickName;
    private Integer age;
    private Integer trickLevel;
    String[] habbits;

    public Pet() {
    }

    public Pet(Species species, String nickName) {
        this.species = species;
        this.nickName = nickName;
    }

    public Pet(Species species, String nickName, Integer age, Integer trickLevel, String[] habbits) {
        this.species = species;
        this.nickName = nickName;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habbits = habbits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabbits() {
        return habbits;
    }

    public void setHabbits(String[] habbits) {
        this.habbits = habbits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species.equals(pet.species) && nickName.equals(pet.nickName) && age.equals(pet.age) && trickLevel.equals(pet.trickLevel) && Arrays.equals(habbits, pet.habbits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickName, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habbits);
        return result;
    }

    public void eat() {
        System.out.println("I am eating!");
    }

    public abstract void respond();
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is being removed!: " + this.toString());
        super.finalize();
    }

    @Override
    public String toString() {
        return species.name() + " " + species + "{nickName=" + nickName + " ,age=" + age + "  ,trickLevel=" + trickLevel +
                " ,habbits=" + Arrays.toString(habbits);
    }

}


