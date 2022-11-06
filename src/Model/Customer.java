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

    public void addCar(Car c){
        repo.addCar(c);
    }

    public void deleteCar(Car c){
        repo.deleteCar(c);
    }
}
