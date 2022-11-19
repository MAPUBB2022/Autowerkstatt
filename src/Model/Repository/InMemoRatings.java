package Model.Repository;

import Model.Car;
import Model.Rating;

import java.util.ArrayList;
import java.util.List;

public class InMemoRatings {
    private List<Rating> ratings;

    public InMemoRatings() {
        this.ratings = new ArrayList<>();
    }

    public List<Rating> getRatings(){return this.ratings;}

    public void addRating(Rating r){
        this.ratings.add(r);
    }

    public void deleteRating(Rating r){
        this.ratings.remove(r);
    }

    public void updateRating(Rating r){
        boolean updated = false;
        for(Rating rt:this.ratings){
            if(rt.getCust()==r.getCust() && rt.getMech()==r.getMech()){
                updated = true;
                rt.setValue(r.getValue());
            }
        }
        if(!updated)
            throw new IllegalArgumentException("Does not exist");

    }
}
