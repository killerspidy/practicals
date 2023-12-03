package Q7;

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
