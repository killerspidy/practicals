
// Q.7) Write a Java Program to implement Iterator Pattern for Designing Menu like Breakfast, Lunch or Dinner Menu.

// MenuTest.java

public class MenuTest {
public static void main(String[] args) {
PancakeHouseMenu pancakeHouseMenu = new
PancakeHouseMenu();
DinnerMenu dinnerMenu = new DinnerMenu();
CoffeeMenu coffeeMenu = new CoffeeMenu();
Waitress waitress = new
Waitress(pancakeHouseMenu,dinnerMenu,coffeeMenu);
waitress.printMenu();
}
}

// Menu.java

import java.util.*;
public interface Menu {
public Iterator createIterator();
}

// PancakeHouseMenu.java


import java.util.*;
public class PancakeHouseMenu implements Menu {
ArrayList menuItems;
public PancakeHouseMenu() {
menuItems = new ArrayList();
addItem("kobe's pancake breakfast","pancakes with eggs",false,2.99);
addItem("lilei's pancake breakfast", "pancakes with toast", false,3.59);
}
public void addItem(String s, String s1, boolean b, double v) {
MenuItem menuItem = new MenuItem(s,s1,b,v);
menuItems.add(menuItem);
}
public Iterator createIterator(){
return menuItems.iterator();
}
}

//  MenuItem.java


public class MenuItem {
private String name;
private String desc;
private boolean vegetarian;
private double price;
public MenuItem(String name, String desc, boolean vegetarian,
double price) {
this.name = name;
this.desc = desc;
this.vegetarian = vegetarian;
this.price = price;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDesc() {
return desc;
}
public void setDesc(String desc) {
this.desc = desc;
}
public boolean isVegetarian() {
return vegetarian;
}
public void setVegetarian(boolean vegetarian) {
this.vegetarian = vegetarian;
}
public double getPrice() {
return price;
}
public void setPrice(double price) {
this.price = price;
}
}


//  DinnerMenu.java


import java.util.*;
public class DinnerMenu implements Menu {
private static final int MAX_SIZE = 6;
int numOfItems = 0;
MenuItem[] menuItems;
public DinnerMenu() {
menuItems = new MenuItem[MAX_SIZE];
addItem("Vegetarian BLT","Bacon with tomato",true,2.99);
addItem("Hot dog","With onions and cheese",false,3.05);
}
private void addItem(String s, String s1, boolean b, double v) {
MenuItem menuItem = new MenuItem(s,s1,b,v);
if(numOfItems >= MAX_SIZE){
System.err.println("sorry,menu is full!");
}else{
menuItems[numOfItems]=menuItem;
numOfItems = numOfItems + 1;
}
}
@Override
public Iterator createIterator() {
return new DinerMenuIterator(menuItems);
}
}


//  DinerMenuIterator.java


import java.util.*;
public class DinerMenuIterator implements Iterator {
MenuItem[] list;
int position = 0;
public DinerMenuIterator(MenuItem[] list) {
this.list = list;
}
@Override
public boolean hasNext() {
if(position>=list.length || list[position] == null){
return false;
}else{
return true;
}
}
@Override
public Object next() {
MenuItem menuItem = list[position];
position = position + 1;
return menuItem;
}
@Override
public void remove() {
if(position <=0){
throw new IllegalStateException("now you can not remove an item");
}
if(list[position] != null){
for(int i=position-1;i<(list.length-1);i++){
list[i] = list[i+1];
}
list[list.length-1]=null;
}
}
}

//  CoffeeMenu.java


import java.util.*;
public class CoffeeMenu implements Menu {
Hashtable menuItems = new Hashtable();
public CoffeeMenu() {
addItem("Mocha","Han Meimei order on couple of Mocha",false,3.01);
}
private void addItem(String s, String s1, boolean b, double v) {
MenuItem menuItem = new MenuItem(s,s1,b,v);
menuItems.put(menuItem.getName(),menuItem);
}
@Override
public Iterator createIterator() {
return menuItems.values().iterator();
}
}


//  Waitress.java


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