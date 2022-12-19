package Model;

import Interfaces.CustomerInterface;
import Model.Repository.InMemoCars;
import Model.Repository.InMemoRatings;
import Exceptions.CustomIncorrectArgument;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements CustomerInterface<Car> {
    private InMemoCars repo;
    private InMemoRatings ratings;
    private List<Car> ownedCars;

    public Customer(String firstName, String lastName, InMemoCars repo) {
        super(firstName,lastName);
        this.repo = repo;
        this.ownedCars = new ArrayList<>();
    }

    public List<Car> getRepo() {
        List<Car> cars = new ArrayList<>();
        for(Car c:this.repo.getCarList()) {
                cars.add(c);
        }
        return cars;
    }

    public List<Car> getOwnedCars() {
        return ownedCars;
    }

    public void giveRating(Rating r){
        this.ratings.addRating(r);
    }

    @Override
    public void addCar(Car car) throws CustomIncorrectArgument{
        boolean found = false;
            for (Car c : this.repo.getCarList()) {
                if (c.getId() == car.getId()) {
                    found = true;
                    throw new CustomIncorrectArgument("Already exists");
                }
            }

        if(!found){
            this.repo.addCar(car);
            this.ownedCars.add(car);
        }
    }
    @Override
    public void deleteCar (Car car) throws CustomIncorrectArgument{
        boolean deleted = false;
        for (Car c : this.repo.getCarList()) {
            if (c.getId() == car.getId()){
                this.repo.deleteCar(car);
                this.ownedCars.remove(car);
                deleted = true;
            }
        }
        if (!deleted)
            throw new CustomIncorrectArgument("Not found");
    }

    public void updateCar(Car car){
        try {
            repo.updateCar(car);
        }catch (Exception error) {   //doesn't get used here
            System.out.println(error.getMessage());
        }
    }
}