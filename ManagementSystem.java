import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
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
        Application.start(ManagementSystem.class); }

    //Add a vehicle
    @Menu(command = "V", description = "Add new vehicle", id = 0, subMenuIDs = {1, 2})
    //Add a car
    @Menu(command = "C", description = "Add a new car", id = 1)
    public void createCar() {

        String ma = Reader.readName("Enter make:");
        String mo = Reader.readName("Enter model:");
        int y = Reader.readInt("Enter year:");
        GearboxType gearboxType = Reader.readEnum("Gearbox Type:", GearboxType.class);
        String cl = Reader.readName("Enter colour of vehicle:");
        int mi = Reader.readInt("Enter current mileage:");
        String vin = Reader.readLine("Enter VIN:");
        BodyType bodyType = Reader.readEnum("Is this vehicle a Saloon, Estate, " +
                "Hatchback or SUV?", BodyType.class);
        boolean satNav = Reader.readBoolean("Does this car have satNav?");
        boolean parkingSensor = Reader.readBoolean("Does this car have parking sensors?");
        boolean towbar = Reader.readBoolean("Does this car have a tow bar?");
        boolean roofrack = Reader.readBoolean("Does this car have a roof-rack?");

        //Applies to SUVs
        boolean allWheelDrive = false;
        if (bodyType == BodyType.SUV)
        {
            allWheelDrive = Reader.readBoolean("Does this car have All Wheel Drive?");
        }
        //Applies to Estates
        boolean thirdRowSeat = false;
        if (bodyType == BodyType.Estate)
        {
            thirdRowSeat = Reader.readBoolean("Does this car have a third-row seat?");
        }
        //Store car record
        String id = sequence.next();
        Car c = new Car(ma, mo, y, gearboxType, cl, mi, vin, bodyType, satNav, parkingSensor, towbar, roofrack,
                thirdRowSeat, allWheelDrive);
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
        LugaggeBox lb = Reader.readEnum("Does this motorbike have a luggage box?", LugaggeBox.class);
        //Store motorbike record
        String id = sequence.next();
        Motorbike m = new Motorbike(ma, mo, y, gearboxType, cl, mi, vin,lb);
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
    public void updateVehicle() {
        Vehicle v = search();
        if (v == null) {
            System.out.println("No vehicle was found!");
            return;
        }
        boolean updated = false;
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
        //Populate Records - Dummy Data
            @Menu(command = "P", description = "Populate Records", id = 9)
            public void populateRecords(){
            //Test Car records
            vehicles.add (new Car ("BMW","M3",2010,GearboxType.Manual, "White",100000,"BM12345",
                    BodyType.Saloon, false, false, false, false, false, false));
            vehicles.add (new Car ("BMW","M3",2012,GearboxType.Automatic, "Silver",100000,"BM23456",
                        BodyType.Saloon, false, false, false, false, false, false));
            vehicles.add (new Car ("Volkswagen","Tiguan",2012,GearboxType.Manual, "Red",90000,"VT12345",
                    BodyType.SUV, false, false, true, false, false, true));
            vehicles.add (new Car ("Volkswagen","Golf",2010,GearboxType.Manual, "Red",100000,"VG12345",
                    BodyType.Hatchback,true,true,false,false,false,false));
            vehicles.add (new Car ("Ford","Fiesta",2013,GearboxType.Automatic, "Black",97000,"FF12345",
                        BodyType.Hatchback,true,true,false,true,false,false));
            vehicles.add (new Car ("Audi","A4",2014,GearboxType.Automatic, "Blue",65000,"AU23456",
                        BodyType.Estate,true,true,true,true,true,false));
            //Test Motorbike Records
            vehicles.add (new Motorbike ("Harley Davidson","Cruiser",2018,GearboxType.Automatic, "White",120000,
                        "HD12345", LugaggeBox.Yes));
            vehicles.add (new Motorbike ("Harley Davidson","Trike",2022,GearboxType.Automatic, "Black",110000,
                        "HD23456", LugaggeBox.No));
            vehicles.add (new Motorbike ("Kawasaki","Classic",2019,GearboxType.Manual, "Red",920000,
                        "KW78910", LugaggeBox.Yes));
            vehicles.add (new Motorbike ("Kawasaki","Platinum",2018,GearboxType.Automatic, "Blue",80000,
                        "KW91011", LugaggeBox.No));
            vehicles.add (new Motorbike ("Ducati","Classic",2021,GearboxType.Automatic, "Green",111000,
                        "DC34567", LugaggeBox.Yes));
            }
    }






























































