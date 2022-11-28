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

    public void giveRating(Rating r){model.giveRating(r);}

    public void addCar(Car c){
        model.addCar(c);
    }

    public void deleteCar(Car c){
        model.deleteCar(c);
    }

    public Car findOldestCar(){
        Car oldest=null;
        int minYear= Integer.MAX_VALUE;

        for(Car car: this.getCars()){
            if(car.getManufactureYear()<minYear){
                minYear=car.getManufactureYear();
                oldest=car;
            }
        }
        return oldest;
    }

    public void viewGetCars(){
        this.view.printAllCars(this.getCars());
    }

    public void viewGetOwnedCars(){
        this.view.printAllCars(this.getOwnedCars());
    }

    public void viewOldestCar(){
        this.view.printOldestCar(this.findOldestCar());
    }

    public void viewPrintMechanics(List<Person> persons){this.view.printMechanics(persons);}  //aici mai trebuie posibil inca o functie
}