import az.turing.happyfamilyapp.entity.human.*;
import az.turing.happyfamilyapp.entity.pet.Dog;
import az.turing.happyfamilyapp.entity.pet.Pet;
import az.turing.happyfamilyapp.entity.pet.Species;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyTest {
    private Human father;
    private Human mother;
    private Human child;
    private Pet pet;
    private Family family;

    @BeforeClass
    public void Family() {
        father = new Man("Alex", "Baydon", "21/05/1978", 96);
        mother = new Woman("Mila", "Baydon", "19/06/1980", 92);
        family = new Family(father, mother);
        Set<String> habbits = new HashSet<>();
        habbits.add("clever");
        habbits.add("friendly");
        pet = new Dog(Species.DOG, "Rex", 3, 60, habbits);
        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "Go to the futness!");
        child = new Human("Sia", "Baydon", String.valueOf(LocalDate.now()), 85, schedule);
    }

    @Test
    public void testAddChild() {
        family.addChild(child);
        assertEquals(1, family.getChildren().size());
    }

    @Test
    public void deleteChild() {
        family.addChild(child);
        family.deleteChild(child);
        assertEquals(0, family.getChildren().size());
    }

    @Test
    public void deleteChildIndex() {
        family.addChild(child);
        family.deleteIndexChild(0);
        assertEquals(0, family.getChildren().size());
    }

    @Test
    public void burnChild() {
        Human human = family.burnChild();
        family.addChild(human);
        assertEquals(1, family.getChildren().size());
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
