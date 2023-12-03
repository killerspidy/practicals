package Q7;

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