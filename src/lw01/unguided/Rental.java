package lw01.unguided;

public abstract class Rental implements Chargeable{
    private String id;
    private int days;

    protected Rental(String id, int days) {
        if(days <= 0) throw new IllegalArgumentException();
        this.id = id;
        this.days = days;
    }

    public String getID() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if(units <= 0) throw new IllegalArgumentException();
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }

    public String summary(int units) {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
