package Q71;


// MenuTestDrive class
public class MenuTestDrive {
    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();

        // Uncomment and implement LunchMenu and DinnerMenu as needed
        // LunchMenu lunchMenu = new LunchMenu();
        // DinnerMenu dinnerMenu = new DinnerMenu();

        printMenu(breakfastMenu.createIterator());
        // printMenu(lunchMenu.createIterator());
        // printMenu(dinnerMenu.createIterator());
    }

    private static void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println("Item: " + menuItem.getName() + ", Price: $" + menuItem.getPrice());
        }
    }
}
