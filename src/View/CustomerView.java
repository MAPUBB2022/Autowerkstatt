package View;

import Model.*;

import java.util.List;

public class CustomerView {
    /**
     * the following functions are used to display various objects
     * @param cars parameters from each function are the entities to be displayed
     */
    public void printAllCars(List<Car> cars){
        if(cars.isEmpty()){
            System.out.println("No cars available in our System"+"\n");
            return;
        }
        for(Car car: cars){
            System.out.println(car.stringCar());
        }
        System.out.println("\n");
    }

    public void printOldestCar(Car car){
        System.out.println(car.stringCar());
    }

    public void printMechanics(List<Mechanic> mechanics) {
        for (Mechanic m : mechanics) {
            System.out.println(m.stringMechanic());
        }
    }

    public void printRatings(List<Rating> ratings){
        for(Rating r:ratings){
            System.out.println(r.stringRating());
        }
    }

}
