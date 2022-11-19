package Controller;

import Model.*;
import View.MechanicView;

import java.util.ArrayList;
import java.util.List;

public class MechanicController {
    private Mechanic model;
    private MechanicView view;

    public MechanicController(Mechanic model, MechanicView view) {
        this.model = model;
        this.view=view;
    }

    public List<Car> getCars(){
        return model.getRepo();
    }

    public float getEarnings() {
        return model.getEarnings();
    }

    public float getRating() {
        return model.getRating();
    }

    public List<Car> getCarList() {
        return model.getCarList();
    }

    public void setEarnings(float earnings) {
        model.setEarnings(earnings);
    }

    public void setRating(float rating) {
        model.setRating(rating);
    }

    public void updateCar(Car car) {model.updateCar(car);}

    public List<Car> filterByYear(int year){
        List<Car> cars= new ArrayList<>();
        for(Car car:this.getCars()){
            if(car.getManufactureYear()<year){
                cars.add(car);
            }
        }
        return cars;
    }

    public void viewGetCars(){
        this.view.printAllCars(this.getCars());
    }

    public void viewEarnings(){
        this.view.printEarnings(this.getEarnings());
    }

    public void viewRating(){
        this.view.printRating(this.getRating());
    }

    public void viewCarList(){
        this.view.printAllCars(this.getCarList());
    }

    public void viewFilterByYear(int year){
        this.view.printAllCars(this.filterByYear(year));
    }

}
