package Vehicle;

import places.Warehouse;
import things.Driver;
import things.Item;

import java.util.ArrayList;

public class Truck {

    private Driver driver;
    private Item[] items;

    public Truck(Driver driver, int loadCapacity) {

        // LOOK AT THIS
        // what is going on
        this.driver = driver;
        driver.setAssignedTruck(this);

        // MAKE SURE YOU KNOW WHAT IS GOING ON HERE
        items = new Item[loadCapacity];
    }

    public void loadTruck(Warehouse warehouse, int numberOfItemsToLoad) {

        // STEP 10
        // THIS IS TRICKY

        // RULE THAT NEED TO BE CODED
        // numberOfItemsToLoad large then what the truck if
        // if it is print to the console
        // "Sorry cannot load this many item in to truck -> over truck capacity";
        // not not load any item into truck
        // Hint: Use a if else



        // RULE THAT NEED TO BE CODED
        // numberOfItemsToLoad large then what the truck if is not empty
        // if it is print to the console
        // "Sorry cannot load this many item in to truck -> over truck capacity by: " +  overCapicity
        // here overCapacity the number over the truck capacity when try to load numberOfItemsToLoad many items
        // not not load any item into truck




                    // RULE THAT NEED TO BE CODED
                    // load the first numberOfItemsToLoad number item from the warehouse into truck and remove them from the warehouse
                    // BE CAREFUL HERE TRUCK MAY NOT BE EMPTY YOU HAVE TO DEAL WITH THIS
                    // THIS IS TRICKY
                    // hint for loops are good here use two for loop to make it easier
                    // one to add the item to the truck and the other to remove the loaded items from the warehouse



    }


    public void unloadTruck(Warehouse warehouse){
        //STEP 12
        // WRITE YOUR CODE BELOW THIS LINE

    }

    public void display(){
        System.out.println();
        System.out.printf("Truck Driver: \t\t\t\t %s %s \n", driver.getFirstName(), driver.getLastName());
        System.out.printf("Truck Capacity: \t\t\t %d \n", items.length);

        int lastFullIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                lastFullIndex++;
            } else {
                i = items.length;
            }//end if-else
        }//end for

        System.out.printf("Trucks remaining Capacity: \t %d \n", items.length - lastFullIndex);
    }


    public void displayCargo() {

        display();

        System.out.println("Truck's Cargo:");
        // STUDY THIS

        if (items[0] == null) {
            System.out.println("\t\t\t\t\t\t\t " + "Empty");
        } else {
            int counter;
            for (int i = 0; i < Item.getClassification().length; i++) {
                String classification = Item.getClassification()[i];
                counter = 0;

                for (Item currentItem : items) {
                    String[] tokens = currentItem.getId().split("-");

                    if (tokens[1].equals(classification)) {
                        System.out.println("\t\t\t\t\t\t\t " + currentItem.getId());
                        counter++;
                    }//end if
                }//end for
            }//end for
        }//end if-else

    }

}// end class
