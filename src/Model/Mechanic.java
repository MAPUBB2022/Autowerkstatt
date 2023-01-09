package Model;

import Interfaces.MechanicInterface;
import Model.Repository.InMemoCars;
import Model.Repository.InMemoRatings;
import Exceptions.CustomIncorrectArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mechanic extends Person implements MechanicInterface<Car> {
    private float earnings;
    private double rating;
    private List<Car> carList;
    private InMemoCars repo;
    private InMemoRatings ratings;

    public Mechanic(String firstName, String lastName, float earnings, InMemoCars repo, InMemoRatings ratings) {
        super(firstName, lastName);
        this.earnings = earnings;
        this.rating = 0;
        this.carList = new ArrayList<>();
        this.repo=repo;
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

    public float getEarnings() {
        return earnings;
    }

    public double getRating() {
        return rating;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    /**
     * used to display the attributes in View-Layer and others
     * @return the attributes of the object
     */
    public String stringMechanic(){
        return "(FirstName:"+this.getFirstName()+", LastName:"+this.getLastName()+", Rating:"+this.getRating()+")"+"\n";
    }

    /**
     * is used to define rating attribute, by checking each rating in the repository and
     * calculating the average value from all corresponding ratings given to the mechanic
     */
    public void setRating() {
        double sum=0;
        int ct=0;
        for(Rating r: this.ratings.getRatings()){
            if(Objects.equals(r.getMech().getFirstName(), this.getFirstName()) && Objects.equals(r.getMech().getLastName(), this.getLastName())){
                sum=sum+r.getValue();
                ct+=1;
            }
        }
        this.rating=sum/ct;
    }

    /**
     * is used to define carList attribute meaning all the cars that were assigned to each mechanic to be repaired
     */
    public void setCarList(){
        List<Car> aux=new ArrayList<>();
        for(Car c:this.repo.getCarList()){
            for(Mechanic p:c.getAssigned()){
                if(Objects.equals(this.getFirstName(), p.getFirstName()) && Objects.equals(this.getLastName(), p.getLastName())){
                    aux.add(c);
                }
            }
        }
        this.carList=aux;
    }

    /**
     * doesn't get used by the mechanic
     */
    public void addCar(Car car) throws CustomIncorrectArgument{
        boolean found = false;
        for (Car c:this.repo.getCarList()){
            if(c.getId() == car.getId()) {
                found = true;
                throw new CustomIncorrectArgument("Already exists");
            }
        }
        if(!found){
            this.repo.addCar(car);
        }
    }

    /**
     * doesn't get used by the mechanic
     */
    public void deleteCar(Car car) throws CustomIncorrectArgument{
        boolean deleted = false;
        for (Car c : this.repo.getCarList()) {
            if (c.getId() == car.getId()){
                this.repo.deleteCar(car);
                deleted = true;
            }
        }
        if (!deleted)
            throw new CustomIncorrectArgument("Not found");
    }

    /**
     * updates the cars repair status
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
            }
        }
        if(!updated)
            throw new CustomIncorrectArgument("Not updated");
    }
}