package Controller;

import Model.*;
import View.CustomerView;

import java.util.List;

public class CustomerController{
    private Customer model;
    private CustomerView view;

    public CustomerController(Customer model, CustomerView view) {
        this.model = model;
        this.view=view;
    }

    public List<Car> getCars(){
        return model.getRepo();
    }

    public List<Car> getOwnedCars() {
        return model.getOwnedCars();
    }

    public void setOwnedCars(){model.setOwned();}

    public void giveRating(Rating r)
    {   try {
          model.giveRating(r);
        }catch (Exception error){
          System.out.println(error.getMessage());
        }
    }

    public void removeRating(Rating r){
        try {
            model.removeRating(r);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public void updateRating(Rating r){
        try {
            model.updateRating(r);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public void addCar(Car c){
        try {
            model.addCar(c);
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void deleteCar(Car c){
        try {
            model.deleteCar(c);
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public void updateCar(Car c){
        try {
            model.updateCar(c);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    /**
     * @return oldest car from owned cars
     */
    public Car findOldestCar(){
        Car oldest=null;
        int minYear= Integer.MAX_VALUE;

        for(Car car: this.getOwnedCars()){
            if(car.getManufactureYear()<minYear){
                minYear=car.getManufactureYear();
                oldest=car;
            }
        }
        return oldest;
    }

    /**
     * the following are functions using View-Structure to print given entities
     */
    public void viewGetCars(){
        this.view.printAllCars(this.getCars());
    }

    public void viewGetOwnedCars(){
        this.view.printAllCars(this.getOwnedCars());
    }

    public void viewOldestCar(){
        this.view.printOldestCar(this.findOldestCar());
    }

    public void viewPrintMechanics(List<Mechanic> mechanics){this.view.printMechanics(mechanics);}

    public void viewRatings(List<Rating> ratings){this.view.printRatings(ratings);}
}