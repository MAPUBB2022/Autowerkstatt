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

    public double getRating() {
        return model.getRating();
    }

    public List<Car> getCarList() {
        return model.getCarList();
    }

    public void setEarnings(float earnings) {
        model.setEarnings(earnings);
    }

    public void setRating(){model.setRating();}

    public void setCarList(){model.setCarList();}

    public void updateCar(Car c){
        try {
            model.updateCar(c);
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    /**
     * @param year
     * @return all cars with manufacture year smaller than the given parameter
     */
    public List<Car> filterByYear(int year){
        List<Car> cars= new ArrayList<>();
        for(Car car:this.getCars()){
            if(car.getManufactureYear()<year){
                cars.add(car);
            }
        }
        return cars;
    }


    /**
     * the following are functions using View-Structure to print given entities
     */
    public void viewGetCars(){
        this.view.printAllCars(this.getCars());
    }

    public void viewEarnings(){
        this.view.printEarnings(this.getEarnings());
    }

    public void viewRating(){
        this.view.printRating(this.getRating());
    }

    public void viewCarList(){this.view.printAllCars(this.getCarList());}

    public void viewFilterByYear(int year){
        this.view.printAllCars(this.filterByYear(year));
    }

}
