package az.turing.happyfamilyapp.entity.pet;

public enum Species {
    DOG(false, 4, true),
    DOMESTICCAT(false, 4, true),
    BIRD(true, 2, true),
    ROBOTCAT(false, 4, false),
    FISH(false, 0, false),

    UNKNOWN(false, 0, false);

    private final boolean canFly;
    private final Integer numberOfLegs;
    private final boolean hasfur;

    Species(boolean canFly, Integer numberOfLegs, boolean hasfur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasfur = hasfur;
    }

    @Override
    public String toString() {
        return "canFly=" + canFly +
                ", numberOfLegs=" + numberOfLegs +
                ", hasfur=" + hasfur;
    }
}
