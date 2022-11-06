package Controller;

import Model.Car;
import Model.Mechanic;
import Model.Repository.InMemoCars;

import java.util.List;

public class MechanicController {
    private Mechanic model;

    public MechanicController(Mechanic model) {
        this.model = model;
    }

    public InMemoCars getRepo(){
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
}
