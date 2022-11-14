package Model;

import Interfaces.CustomerInterface;
import Model.Repository.InMemoCars;
import java.util.List;

public class Customer extends Person implements CustomerInterface<Car> {
    private InMemoCars repo;
    private List<Car> ownedCars;


    public Customer(String firstName, String lastName, InMemoCars repo, List<Car> ownedCars) {
        super(firstName,lastName);
        this.repo = repo;
        this.ownedCars = ownedCars;
    }

    public InMemoCars getRepo() {
        return repo;
    }

    public List<Car> getOwnedCars() {
        return ownedCars;
    }

    public void addCar(Car car){
        repo.addCar(car);
    }

    public void deleteCar(Car car){
        repo.deleteCar(car);
    }

    public void updateCar(Car car) {
        repo.updateCar(car);
    }
}