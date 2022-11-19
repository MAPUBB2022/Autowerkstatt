package Model.Repository;

import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class InMemoCars{
    private List<Car> carList;

    public InMemoCars() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCar(Car c){
        this.carList.add(c);
    }

    public void deleteCar(Car c) {
        this.carList.remove(c);
    }

    public void updateCar(Car c){
        boolean updated = false;
        for(Car car:this.carList){
            if(car.getId() == c.getId()){
                updated = true;
                car.setRepaired(c.isRepaired());
            }
        }
        if(!updated)
            throw new IllegalArgumentException("Does not exist");
    }
}
