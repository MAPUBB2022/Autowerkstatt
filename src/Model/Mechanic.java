package Model;

import Interfaces.MechanicInterface;
import Model.Repository.InMemoCars;

import java.util.ArrayList;
import java.util.List;

public class Mechanic extends Person implements MechanicInterface<Car> {
    private float earnings;
    private float rating;
    private List<Car> carList;
    private InMemoCars repo;

    public Mechanic(String firstName, String lastName, float earnings, float rating) {
        super(firstName, lastName);
        this.earnings = earnings;
        this.rating = rating;
        this.carList = new ArrayList<>();
    }

    public List<Car> getRepo() {
        List<Car> cars = new ArrayList<>();
        for(Car c:this.repo.getCarList()) {
            cars.add(c);
        }
        return cars;
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

    public void addCar(Car car) {
        boolean found = false;
        for (Car c:this.repo.getCarList()){
            if(c.getId() == car.getId()) {  //doesn't get used here
                found = true;
                throw new IllegalArgumentException("Already exists");
            }
        }
        if(!found){
            this.repo.addCar(car);
        }
    }

    public void deleteCar(Car car) {
        boolean deleted = false;
        for (Car c : this.repo.getCarList()) {
            if (c.getId() == car.getId()){  //doesn't get used here
                this.repo.deleteCar(car);
                deleted = true;
            }
        }
        if (!deleted)
            throw new IllegalArgumentException("Not found");
    }
    @Override
    public void updateCar(Car car){
        this.repo.updateCar(car);
    }
}