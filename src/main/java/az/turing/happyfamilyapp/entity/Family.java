package az.turing.happyfamilyapp.entity;

import java.util.Arrays;
import java.util.Objects;

public class Family {
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

    public boolean removeChild(Human child) {
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
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
        child.setFamily(null);
        return true;
    }

    public int getCountFamily() {
        return 2 + children.length;
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
