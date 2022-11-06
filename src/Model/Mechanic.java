package Model;

import Interfaces.MechanicInterface;
import Model.Repository.InMemoCars;
import java.util.List;

public class Mechanic extends Person implements MechanicInterface<Car> {
    private float earnings;
    private float rating;
    private List<Car> carList;
    private InMemoCars repo;

    public Mechanic(String firstName, String lastName, float earnings, float rating, List<Car> carList) {
        super(firstName, lastName);
        this.earnings = earnings;
        this.rating = rating;
        this.carList = carList;
    }

    public float getEarnings() {
        return earnings;
    }

    public float getRating() {
        return rating;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void updateCar(Car c){
        repo.updateCar(c);
    }
}
