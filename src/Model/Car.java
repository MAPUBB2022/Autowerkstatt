package Model;

import java.util.List;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int manufactureYear;
    private String chassisSeries;
    private boolean repaired;
    private Customer owned;
    private List<Mechanic> assignedCar;


    public Car(int id, String brand, String model, int manufactureYear, String chassisSeries, boolean repaired, Customer owned, List<Mechanic> assignedCar) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.chassisSeries = chassisSeries;
        this.repaired = repaired;
        this.owned = owned;
        this.assignedCar = assignedCar;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getChassisSeries() {
        return chassisSeries;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public Customer getOwned() {
        return owned;
    }

    public List<Mechanic> getAssignedCar() {
        return assignedCar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public void setChassisSeries(String chassisSeries) {
        this.chassisSeries = chassisSeries;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public void setOwned(Customer owned) {
        this.owned = owned;
    }

    public void setAssignedCar(List<Mechanic> assignedCar) {
        this.assignedCar = assignedCar;
    }
}
