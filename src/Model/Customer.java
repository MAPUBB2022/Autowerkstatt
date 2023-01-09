package Model;

import Interfaces.CustomerInterface;
import Model.Repository.InMemoCars;
import Model.Repository.InMemoRatings;
import Exceptions.CustomIncorrectArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends Person implements CustomerInterface<Car> {
    private InMemoCars repo;
    private InMemoRatings ratings;
    private List<Car> ownedCars;

    public Customer(String firstName, String lastName, InMemoCars repo, InMemoRatings ratings) {
        super(firstName,lastName);
        this.repo = repo;
        this.ownedCars = new ArrayList<>();
        this.ratings=ratings;
    }

    /**
     * @return cars from repository
     */
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

    /**
     * is used to define ownedCars attribute, by checking owned attribute from each car in the repository
     */
    public void setOwned(){
        List<Car> list=new ArrayList<>();
        for(Car c:this.repo.getCarList()){
            if(Objects.equals(c.getOwned().getFirstName(), this.getFirstName()) && Objects.equals(c.getOwned().getLastName(), this.getLastName())){
                list.add(c);
            }
        }
        this.ownedCars=list;
    }

    /**
     * adds a rating to repository
     * @param r is the rating given to a mechanic
     * @throws CustomIncorrectArgument when Rating already exists
     */
    public void giveRating(Rating r) throws CustomIncorrectArgument{
        boolean found=false;
        for(Rating rt:this.ratings.getRatings()){
            if(rt.getCust()==r.getCust() && rt.getMech()==r.getMech() && rt.getValue()==r.getValue()){
                found=true;
                throw new CustomIncorrectArgument("Already exists");
            }
        }
        if(!found){
            this.ratings.addRating(r);
        }
    }

    /**
     * removes a rating from the repository
     * @param r is the rating given to a mechanic
     * @throws CustomIncorrectArgument when Rating isn't found
     */
    public void removeRating(Rating r) throws CustomIncorrectArgument{
        boolean deleted=false;
        for(Rating rt:this.ratings.getRatings()){
            if(rt.getCust()==r.getCust() && rt.getMech()==r.getMech() && rt.getValue()==r.getValue()){
                deleted=true;
                this.ratings.deleteRating(rt);
            }
        }
        if(!deleted){
            throw new CustomIncorrectArgument("Not found");
        }
    }

    /**
     * updates the value of a rating from the repository
     * @param r is the rating given to a mechanic
     * @throws CustomIncorrectArgument when Rating isn't found
     */
    public void updateRating(Rating r) throws CustomIncorrectArgument{
        boolean updated=false;
        for(Rating rt:this.ratings.getRatings()){
            if(rt.getCust()==r.getCust() && rt.getMech()==r.getMech()){
                updated=true;
                rt.setValue(r.getValue());
            }
        }
        if(!updated){
            throw new CustomIncorrectArgument("Not found");
        }
    }

    /**
     * adds a car to repository
     * @param car
     * @throws CustomIncorrectArgument when car already exists
     */
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

    /**
     * removes a car from repository
     * @param car
     * @throws CustomIncorrectArgument when car isn't found
     */
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

    /**
     * updates a cars repair status and list of mechanics who are meant to repair the car
     * @param car
     * @throws CustomIncorrectArgument when car isn't found
     */
    @Override
    public void updateCar(Car car) throws CustomIncorrectArgument{
        boolean updated=false;
        for(Car c:this.repo.getCarList()){
            if(c.getId()== car.getId()){
                updated=true;
                c.setRepaired(car.isRepaired());
                c.setAssigned(car.getAssigned());
            }
        }
        if(!updated)
            throw new CustomIncorrectArgument("Not updated");
    }
}