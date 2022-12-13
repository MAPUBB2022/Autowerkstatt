package View;

import Model.*;

import java.util.List;

public class CustomerView {
    public void printAllCars(List<Car> cars){
        if(cars.isEmpty()){
            System.out.println("No cars available in our System"+"\n");
            return;
        }
        for(Car car: cars){
            System.out.println(car.stringCar()+"\n");
        }
        System.out.println("\n");
    }

    public void printOldestCar(Car car){
        System.out.println(car.stringCar()+"\n");
    }

    public void printMechanics(List<Mechanic> mechanics) {
        for (Mechanic m : mechanics) {
            System.out.println(m.stringPerson());
        }
    }

}
