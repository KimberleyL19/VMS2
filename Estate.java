// Estates Only

public class Estate extends Car {
    private boolean thirdRowSeat;

    public Estate(String make, String model, int year, GearboxType gearbox, String colour, int mileage, String VIN) {
        super(make, model, year, gearbox, colour, mileage, VIN);
    }

    public void addthirdRowSeat() {
        this.thirdRowSeat = true;
    }

    public boolean hasthirdRowSeat() {
        return thirdRowSeat;
    }
}
