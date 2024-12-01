package az.turing.happyfamilyapp.entity.human;

import az.turing.happyfamilyapp.entity.pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private Human father;
    private Human mother;
    private List<Human> children;
    private Pet pet;
    public static int count = 1;


    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        father.setFamily(this);
        mother.setFamily(this);
        children = new ArrayList<>();
    }

    public Family(Human father, Human mother, List<Human> children, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pet = pet;
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        child.setFamily(null);
        return children.remove(child);

    }

    public boolean deleteIndexChild(int index) {
        Human removeChild = children.remove(index);
        if (removeChild != null) {
            removeChild.setFamily(null);
            return true;
        }
        return false;
    }

    public int getCountFamily() {
        return 2 + children.size();
    }

    @Override
    public Human burnChild() {
        String[] manName = {"Jon", "Alex", "Muller"};
        String[] womanName = {"Jon", "Alex", "Muller"};
        boolean isMan = new Random().nextBoolean();
        Integer IQ = (getFather().getIQ() + getMother().getIQ()) / 2;
        String name = isMan ? manName[new Random().nextInt(2)] : womanName[new Random().nextInt(2)];
        Human child = isMan ? new Man(name, getFather().getSurname(), "29/11/2024", IQ) :
                new Woman(name, getFather().getSurname(), "29/11/2024", IQ);
        child.setFamily(this);
        return child;
    }

    @Override
    public int hashCode() {
        return Objects.hash(father, mother, children);
    }

    public String prettyFormat() {
        StringBuilder st = new StringBuilder();
        List<Human> children = getChildren();
        String isMan = null;
        for (Human child : children) {
            if (child instanceof Man) {
                isMan = "boy:";
            } else {
                isMan = "girl:";
            }
        }
        st.append("Family ").append(count).append("\n").append("\tmother: {").append(getMother()).append("},\n").append("\tfather: {")
                .append(getFather()).append("},\n").append("\tchildren:\n").append("\t\t").append(isMan)
                .append(children).append("\n").append("\tpets: ").append(getPet());
        count++;
        return st.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is being removed!: " + this.toString());
        super.finalize();
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
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
        Family family = (Family) o;
        return father.equals(family.father) && mother.equals(family.mother);
    }

    @Override
    public String toString() {
        return String.format("Family: \nfather=%s %s ,mother=%s %s \n,children=%s ,pet=%s", father.getName(),
                father.getSurname(), mother.getName(), mother.getSurname(),
                children, pet);
    }
}
