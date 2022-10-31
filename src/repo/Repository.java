package repo;

import java.util.List;

public class Repository {
    private List<Car> cars;

    public Repository(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getAllCars(){
        return this.cars;
    }

    public void addCar(Car car){

    }
}
