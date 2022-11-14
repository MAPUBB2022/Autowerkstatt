package Model;

import Interfaces.ICrud;
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

    public InMemoCars getRepo() { return repo; }

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

    public void addCar(Car car) {
        repo.addCar(car);
    }

    public void deleteCar(Car car) {
        repo.deleteCar(car);
    }

    public void updateCar(Car car){
        repo.updateCar(car);
    }
}