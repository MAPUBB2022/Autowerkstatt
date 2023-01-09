package Model.Repository;

import Model.Car;
import Exceptions.CustomIncorrectArgument;

import java.util.ArrayList;
import java.util.List;

public class InMemoCars{
    private List<Car> carList;

    public InMemoCars() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void addCar(Car c){
        this.carList.add(c);
    }

    public void deleteCar(Car c) {
        this.carList.remove(c);
    }

    public void updateCar(Car c){
        for(Car car:this.carList){
            if(car.getId() == c.getId()){
                car.setRepaired(c.isRepaired());
                car.setAssigned(c.getAssigned());
            }
        }
    }
}
