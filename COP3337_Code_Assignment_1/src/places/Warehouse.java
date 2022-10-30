package places;

import java.util.ArrayList;

import things.Address;
import things.Item;

public class Warehouse {

    //-------------------------------------
    // class variables
    //-------------------------------------
    private static int numberOfWareHouses = 0;

    //-------------------------------------
    // instance variables
    //-------------------------------------
    private ArrayList<Item> items;
    private Address address;



    //-------------------------------------
    // constructors
    //-------------------------------------
    public Warehouse(Address address) {
        this.address = address;
        items = new ArrayList<>();
        numberOfWareHouses++;
    }
    //------------------------------------------------

    public Warehouse(ArrayList<Item> items, Address address) {
        this.items = items;
        this.address = address;
        numberOfWareHouses++;
    }
    //------------------------------------------------

    public static int getNumberOfWareHouses() {
        return numberOfWareHouses;
    }
    //------------------------------------------------

    public static void setNumberOfWareHouses(int numberOfWareHouses) {
        Warehouse.numberOfWareHouses = numberOfWareHouses;
    }
    //------------------------------------------------

    public ArrayList<Item> getItems() {
        return items;
    }
    //------------------------------------------------

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    //------------------------------------------------

    public Address getAddress() {
        return address;
    }
    //------------------------------------------------

    public void setAddress(Address address) {
        this.address = address;
    }

    //------------------------------------------------

    public void displayAddress(){
        System.out.println();
        System.out.println(address.getAddressName() );
        System.out.println(address.getStreetAddress() );
        System.out.println(address.getCity() + ", " + address.getState() + " " + address.getZipCode() ) ;
        System.out.println();
    }

    //------------------------------------------------
    public void displayInfo(){
        displayAddress();
        // STEP 7
        // WRITE YOUR CODE BELOW THIS LINE
        System.out.println("Item count:\t" + this.items.size());
        for (String classification : Item.getClassification()) {
            int count = 0;
            for (Item item : items) {
                if (item.getId().contains("-"+classification+"-")) {
                    System.out.println("\t\t"+item.getId());
                    count++;
                }
            }
            System.out.println("\tclassification "+classification+" count: "+count);
        }




    }
    //------------------------------------------------
}//end class
