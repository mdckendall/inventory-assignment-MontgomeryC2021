import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  
  //CUSTOM CODE START
  private ArrayList<Item> items = new ArrayList<Item>();
  public Scanner scan = new Scanner(System.in);
  public Inventory(){}
  
  public void printMenu(){
      
    System.out.println(
        "Press 1 to add an item.\n" +
        "Press 2 to delete an item.\n" +
        "Press 3 to update an item.\n" +
        "Press 4 to show all the items.\n" +
        "Press 5 to quit the program."  
    );
    
  }

  public boolean select(int selection){

    switch(selection){
      case 1: { this.addItem(); return true;}
      case 2: { this.deleteItem(); return true;}
      case 3: { this.updateItem(); return true;}
      case 4: { this.showItems(); return true;}
      default: {return false;}
    }

  }

  private void addItem(){

    Item item = new Item();
    System.out.println("Enter the name:");
    item.name = this.scan.nextLine();

    System.out.println("Enter the serial number:");
    item.serial = this.scan.nextLine();

    System.out.println("Enter the value in dollars (while number):");
    item.value = Integer.valueOf( this.scan.nextLine() );
    this.items.add(item);
    
  }

  private void deleteItem(){

    System.out.println("Enter the serial number of the item to delete:");
    String search = this.scan.nextLine();
    for (Item item : this.items){
      if (item.serial.equals(search))
      { items.remove(item); }
    }
    
  }

  private void updateItem(){

    System.out.println("Enter the serial number of the item to change:");
    String search = this.scan.nextLine();
    
    for (Item item : this.items)
    {
    
      if (item.serial.equals(search))
      {
        System.out.println("Enter the new name:");
        item.name = this.scan.nextLine();

        System.out.println("Enter the new value in dollars (whole number):");
        item.value = Integer.valueOf( this.scan.nextLine() );
      }
      
    }
    
  }

  private void showItems(){
    for (Item item : this.items)
    { System.out.println(item.name + "," + item.serial + "," + item.value); }
  }
  
  //CUSTOM CODE END
}

//CUSTOM CODE START

class Item {
  String name = "";
  String serial = "";
  int value = 0;
  public Item(){};
}

//CUSTOM CODE END

class Main {
	public static void main(String[] args) {

    //CUSTOM CODE START
    Inventory inv = new Inventory();
    boolean run = true;
    while (run)
    {
      inv.printMenu();
      int n = Integer.valueOf( inv.scan.nextLine() );//scan.nextInt() Causes Bugs
      run = inv.select(n);
    }
    //CUSTOM CODE END
    
	}
}
