import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import devtools.util.Reader;
import devtools.util.Sequence;
import devtools.io.Data;
import devtools.ui.Application;
import devtools.ui.Menu;
import devtools.util.CollectionUtils;

public class ManagementSystem implements Serializable {

    @Data
    public List<Vehicle> vehicles = new ArrayList<>();

    @Data
    public Sequence sequence = new Sequence(1, 1_000_000, "V");

    public static void main(String[] args) {
        Application.start(ManagementSystem.class);
    }
    //Add a vehicle
    @Menu(command = "V", description = "Add new vehicle", id = 0, subMenuIDs = {1, 2})
    //Add a car
    @Menu(command = "C", description = "Add a new car", id = 1)
    public void createCar() {
        String ma = Reader.readName("Enter make:");
        String mo = Reader.readName("Enter model:");
        Integer y = Reader.readInt("Enter year:");
        GearboxType gearboxType = Reader.readEnum("Gearbox Type:", GearboxType.class);
        String cl = Reader.readName("Enter colour of vehicle:");
        Integer mi = Reader.readInt("Enter current mileage:");
        String vin = Reader.readLine("Enter VIN:");
        Enum bodyType = Reader.readEnum("Is this vehicle a Saloon, Estate, Hatchback or SUV?", BodyType.class);
        String id = sequence.next();
        Car c = new Car(ma, mo, y, gearboxType, cl, mi, vin);
        vehicles.add(c);
        System.out.println("Car added to system:" + vin);
    }
    //Add a motorbike
    @Menu(command = "M", description = "Add a new Motorbike", id = 2)
    public void createMotorbike() {
        String ma = Reader.readName("Enter make:");
        String mo = Reader.readName("Enter model:");
        Integer y = Reader.readInt("Enter year:");
        GearboxType gearboxType = Reader.readEnum("Gearbox Type:", GearboxType.class);
        String cl = Reader.readName("Enter colour of vehicle:");
        Integer mi = Reader.readInt("Enter current mileage:");
        String vin = Reader.readLine("Enter VIN:");
        Enum lb = Reader.readEnum("Does this motorbike have a luggage box?", LugaggeBox.class);
        String id = sequence.next();
        Motorbike m = new Motorbike(ma, mo, y, gearboxType, cl, mi, vin);
        vehicles.add(m);
        System.out.println("Car added to system:" + vin);
    }
    //List all vehicles
    @Menu(command = "L", description = "List all vehicles:", id = 3)
    public void listVehicles () {
        Collections.sort(vehicles);
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
    //Search for a vehicle
    private Vehicle search () {
        String key = Reader.readLine("Enter VIN to search for vehicle:");
        Collection<Vehicle> search = CollectionUtils.search(key, vehicles);
        Vehicle v = Reader.readObject("Choose a vehicle", search);
        return v;
    }
    @Menu(command = "S", description = "Search for a vehicle", id = 4, global = true)
    public void searchAndDisplay() {
        Vehicle v = search();
        if (v != null) {
            System.out.println(v); }
        else {
                System.out.println("No vehicle was found!");
        }
    }
    //Update vehicle details
    @Menu(command = "U0", description = "Update", id = 8, subMenuIDs = {5,7})
    @Menu(id = 5, command = "U", description = "Update Vehicle details")
    public void updateVehicle() {
        Vehicle v = search();
        if (v == null) {
            System.out.println("No vehicle was found!");
            return;
        }
        boolean updated = false;
        if (Reader.readBoolean("Update make?")) {
            v.setMake(Reader.readName("Enter make:"));
            updated = true;
        }
        if (Reader.readBoolean("Update model?")) {
            v.setModel(Reader.readName("Enter model:"));
            updated = true;
        }
        if (Reader.readBoolean("Update year?")) {
            v.setYear(Reader.readInt("Enter year:"));
            updated = true;
        }
        if (Reader.readBoolean("Update gearbox type?")) {
            v.setGearbox(Reader.readEnum("Gearbox Type:", GearboxType.class));
            updated = true;
        }
        if (Reader.readBoolean("Update colour?")) {
            v.setColour(Reader.readName("Enter colour:"));
            updated = true;
        }
        if (Reader.readBoolean("Update mileage?")) {
            v.setMileage(Reader.readInt("Enter mileage:"));
            updated = true;
        }
        if (updated) {
            System.out.println("Vehicle record successfully updated!");
        } else {
            System.out.println("No change has been made!");
        }
    }
        //Delete a vehicle record
        @Menu(command = "D", description = "Delete vehicle record", id = 6)
        public void deleteVehicle() {
            Vehicle v = search();
            if (v == null) {
                System.out.println("No vehicle was found!");
                return;
            } else {
                System.out.println(v);
            }

            if (Reader.readBoolean("Do you want to delete this vehicle record?")) {
                vehicles.remove(v);
                System.out.println("Vehicle record has been deleted!");
            } else {
                System.out.println("Deletion aborted!");
            }
        }
        //Modify Vehicle - Optional Add-Ons


        }

























































