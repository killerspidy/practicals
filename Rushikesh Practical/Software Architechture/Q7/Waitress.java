package Q7;

import java.util.*;
public class Waitress {
Menu pancakeHouseMenu;
Menu dinnerMenu;
Menu coffeeMenu;
public Waitress(Menu pancakeHouseMenu, Menu dinnerMenu,
Menu coffeeMenu) {
this.pancakeHouseMenu = pancakeHouseMenu;
this.dinnerMenu = dinnerMenu;
this.coffeeMenu = coffeeMenu;
}
public void printMenu(){
Iterator pancakeHouseIterator =
pancakeHouseMenu.createIterator();
Iterator dinnerIterator = dinnerMenu.createIterator();
Iterator coffeeIterator = coffeeMenu.createIterator();
System.out.println("Menu\n=====Breakfast==start======");
printMenu(pancakeHouseIterator);
System.out.println("Menu\n=====Breakfast===end=====");
System.out.println("Menu\n=====Lunch==start======");
printMenu(dinnerIterator);
System.out.println("Menu\n=====Lunch===end=====");
System.out.println("Menu\n=====Coffee==start======");
printMenu(coffeeIterator);
System.out.println("Menu\n=====Coffee===end=====");
}
private void printMenu(Iterator iterator){
while (iterator.hasNext()){
MenuItem menuItem = (MenuItem)iterator.next();
System.out.println(menuItem.getName()+", ");
System.out.println(menuItem.getPrice()+", ");
System.out.println(menuItem.getDesc());
}
}
}