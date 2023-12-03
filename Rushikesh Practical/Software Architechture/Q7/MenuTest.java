package Q7;

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