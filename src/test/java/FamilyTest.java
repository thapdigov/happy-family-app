import az.turing.happyfamilyapp.entity.human.Family;
import az.turing.happyfamilyapp.entity.human.Human;
import az.turing.happyfamilyapp.entity.human.Man;
import az.turing.happyfamilyapp.entity.human.Woman;
import az.turing.happyfamilyapp.entity.pet.Dog;
import az.turing.happyfamilyapp.entity.pet.Pet;
import az.turing.happyfamilyapp.entity.pet.Species;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyTest {
    private Human father;
    private Human mother;
    private Human child;
    private Pet pet;
    private Family family;

    @BeforeClass
    public void Family() {
        father = new Man("Alex", "Baydon");
        mother = new Woman("Mila", "Baydon");
        family = new Family(father, mother);
        pet = new Dog(Species.DOG, "Rex", 3, 60, new String[]{"clever", "friendly"});
        child = new Human("Sia", "Baydon", "2020/02/05", 85, new String[][]{{"MONDAY", "Go to fitness!"}});
    }

    @Test
    public void testAddChild() {
        family.addChild(child);
        assertEquals(1, family.getChildren().length);
    }

    @Test
    public void deleteChild() {
        family.addChild(child);
        family.deleteChild(child);
        assertEquals(0, family.getChildren().length);
    }

    @Test
    public void deleteChildIndex() {
        family.addChild(child);
        family.deleteIndexChild(0);
        assertEquals(0, family.getChildren().length);
    }

    @Test
    public void burnChild() {
        Human human = family.burnChild();
        family.addChild(human);
        assertEquals(1, family.getChildren().length);
    }

    @Test
    public void countFamily() {
        family.addChild(child);
        assertEquals(3, family.getCountFamily());
    }

    @Test
    public void toStringFamily() {
        family.addChild(child);
        family.setPet(pet);
        assertEquals(family.toString(), "  Family:\n" +
                "                father=Alex Baydon ,mother=Mila Baydon\n" +
                "                ,children=[name=Sia ,surname=Baydon ,dateOfYear=2020/02/05 ,IQ=85 ,schedule=[[MONDAY, Go to the fitness!]]\n" +
                "                ] ,pet=DOG canFly=false, numberOfLegs=4, hasfur=true{nickName=Rex ,age=3  ,trickLevel=60 ,habbits=[clever,friendly]");

    }


}
