package Model;

import Interfaces.MechanicInterface;
import Model.Repository.InMemoCars;
import Model.Repository.InMemoRatings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mechanic extends Person implements MechanicInterface<Car> {
    private float earnings;
    private float rating;
    private List<Car> carList;
    private InMemoCars repo;
    private InMemoRatings ratings;

    public Mechanic(String firstName, String lastName, float earnings) {
        super(firstName, lastName);
        this.earnings = earnings;
        this.rating = 0;
        this.carList = new ArrayList<>();
    }

    public List<Car> getRepo() {
        List<Car> cars = new ArrayList<>();
        for(Car c:this.repo.getCarList()) {
            cars.add(c);
        }
        return cars;
    }

    public float getEarnings() {
        return earnings;
    }

    public float getRating() {
        return rating;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public void setRating() {
        float sum=0;
        int ct=0;
        for(Rating r: this.ratings.getRatings()){
            if(Objects.equals(r.getMech().getFirstName(), this.getFirstName()) && Objects.equals(r.getMech().getLastName(), this.getLastName())){
                sum=sum+r.getValue();
                ct+=1;
            }
        }
        this.rating=sum/ct;
    } //trebuie apelata de fiecare data cand un customer da un rating

    public void setCarList(){
        for(Car c:this.repo.getCarList()){
            for(Person p:c.getAssigned()){
                if(Objects.equals(this.getFirstName(), p.getFirstName()) && Objects.equals(this.getLastName(), p.getLastName())){
                    this.carList.add(c);
                }
            }
        }
    }

    public void addCar(Car car) {
        boolean found = false;
        for (Car c:this.repo.getCarList()){
            if(c.getId() == car.getId()) {  //doesn't get used here
                found = true;
                throw new IllegalArgumentException("Already exists");
            }
        }
        if(!found){
            this.repo.addCar(car);
        }
    }

    public void deleteCar(Car car) {
        boolean deleted = false;
        for (Car c : this.repo.getCarList()) {
            if (c.getId() == car.getId()){  //doesn't get used here
                this.repo.deleteCar(car);
                deleted = true;
            }
        }
        if (!deleted)
            throw new IllegalArgumentException("Not found");
    }
    @Override
    public void updateCar(Car car){
        this.repo.updateCar(car);
    }
}