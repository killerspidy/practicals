package Q7;

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