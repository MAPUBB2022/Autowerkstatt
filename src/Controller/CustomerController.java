package Controller;
import Model.Car;
import Model.Customer;
import Model.Repository.InMemoCars;

import java.util.List;

public class CustomerController {
    private  Customer model;

    public CustomerController(Customer model) {
        this.model = model;
    }

    public InMemoCars getRepo(){
        return model.getRepo();
    }

    public List<Car> getOwnedCars() {
        return model.getOwnedCars();
    }

    public void addCar(Car c){
        model.addCar(c);
    }

    public void deleteCar(Car c){
        model.deleteCar(c);
    }
}