package Model.Repository;

import Model.Customer;
import Model.Mechanic;

import java.util.ArrayList;
import java.util.List;

public class InMemoMechanics {
    private List<Mechanic> mechanics;

    public InMemoMechanics(){this.mechanics=new ArrayList<>();}

    public List<Mechanic> getMechanics(){return this.mechanics;}

    public void addMechanic(Mechanic mechanic){this.mechanics.add(mechanic);}

    public void removeCustomer(Mechanic mechanic){this.mechanics.remove(mechanic);}
}
