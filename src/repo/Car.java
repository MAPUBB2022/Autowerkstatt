package repo;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int manufactureYear;
    private String chassisSeries;
    private boolean repaired;
    //private Customer owned;
    //private List<Mechanic> assigned;


    public Car(int id, String brand, String model, int manufactureYear, String chassisSeries, boolean repaired) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.chassisSeries = chassisSeries;
        this.repaired = repaired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getChassisSeries() {
        return chassisSeries;
    }

    public void setChassisSeries(String chassisSeries) {
        this.chassisSeries = chassisSeries;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }
}
