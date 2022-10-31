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
        boolean found=false;
        for(Car c : this.cars){
            if(car==c){
                found=true;
                throw new RuntimeException();
            }
        }
        if(!found)
            this.cars.add(car);
    }

    public void removeCar(Car car){
        boolean found=false;
        for(Car c : this.cars){
            if(car==c){
                this.cars.remove(car);
                found=true;
            }
        }
        if(!found)
            throw new RuntimeException();
    }

    public void updateCar(Car car){
        boolean found=false;
        for(Car c : this.cars){
            if(c.getId()==car.getId()){
                c.setRepaired(car.isRepaired());
                found=true;
            }
        }
        if(!found)
            throw new RuntimeException();
    }
}
