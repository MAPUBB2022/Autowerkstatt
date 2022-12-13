package Model;

public class Rating {
    private Person cust;
    private Person mech;
    private double value;

    public Rating(Person cust, Person mech, double value) {
        this.cust = cust;
        this.mech = mech;
        this.value = value;
    }

    public Person getCust() {
        return cust;
    }

    public void setCust(Person cust) {
        this.cust = cust;
    }

    public Person getMech() {
        return mech;
    }

    public void setMech(Person mech) {
        this.mech = mech;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
