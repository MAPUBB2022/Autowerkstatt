package Model.Repository;

import Model.Car;
import java.util.List;

public class InMemoCars{
    private List<Car> carList;

    public InMemoCars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCar(Car c){
        boolean found = false;
        for (Car car:this.carList){
            if(car.getId() == c.getId()) {
                found = true;
                throw new RuntimeException();
            }
        }
        if(!found){
            this.carList.add(c);
        }
    }

    public void deleteCar(Car c) {
        boolean deleted = false;
        for (Car car : this.carList) {
            if (car.getId() == c.getId()){
                this.carList.remove(c);
                deleted = true;
            }
        }
        if (!deleted)
            throw new RuntimeException();
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
            throw new RuntimeException();
    }
}
