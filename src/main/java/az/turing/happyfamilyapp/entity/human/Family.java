package az.turing.happyfamilyapp.entity.human;

import az.turing.happyfamilyapp.entity.pet.Pet;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private Human father;
    private Human mother;
    private Human[] children;
    private Pet pet;
    public int index = 0;

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        father.setFamily(this);
        mother.setFamily(this);
        children = new Human[index];
    }

    public Family(Human father, Human mother, Human[] children, Pet pet) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pet = pet;
    }

    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[newChildren.length - 1] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        int index = -1;
        for (int i = 0, j = 0; i < children.length; i++) {
            if (children[i].equals(child)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        getChildren(index);
        child.setFamily(null);
        return true;
    }

    public boolean deleteIndexChild(int index) {
        if (!(index >= 0 && index < children.length)) {
            return false;
        }
        getChildren(index);
        return true;
    }

    private void getChildren(int index) {
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
    }

    public int getCountFamily() {
        return 2 + children.length;
    }

    @Override
    public Human burnChild() {
        String[] manName = {"Jon", "Alex", "Muller"};
        String[] womanName = {"Jon", "Alex", "Muller"};
        boolean isMan = new Random().nextBoolean();
        String name = isMan ? manName[new Random().nextInt(2)] : womanName[new Random().nextInt(2)];
        Human child = isMan ? new Man(name, getFather().getSurname(), "2024/11/28") :
                new Woman(name, getFather().getSurname(), "2024/11/28");
        child.setFamily(this);
        return child;
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
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
        return father.equals(family.father) && mother.equals(family.mother) && Arrays.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(father, mother);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Family: \nfather=%s %s ,mother=%s %s \n,children=%s ,pet=%s", father.getName(), father.getSurname()
                , mother.getName(), mother.getSurname(),
                Arrays.toString(children), pet);
    }
}
