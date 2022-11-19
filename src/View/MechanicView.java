package View;

import Model.*;

import java.util.List;

public class MechanicView {
    public void printAllCars(List<Car> cars){
        if(cars.isEmpty()){
            System.out.println("No cars available"+"\n");
            return;
        }
        for(Car car: cars){
            System.out.println(car.stringCar()+"\n");
        }
        System.out.println("\n");
    }

    public void printEarnings(float earnings){
        System.out.println("Earnings:"+earnings+"\n");
    }

    public void printRating(float rating){
        System.out.println("Rating:"+rating+"\n");
    }
}
