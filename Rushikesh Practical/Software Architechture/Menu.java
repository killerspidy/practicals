import java.util.Iterator;

// Menu interface
interface Menu {
    Iterator<MenuItem> createIterator();
}

// MenuItem class
class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Iterator interface
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// MenuItemIterator class
class MenuItemIterator implements Iterator<MenuItem> {
    private MenuItem[] menuItems;
    private int position = 0;

    public MenuItemIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position++;
        return menuItem;
    }
}

// Concrete BreakfastMenu class
class BreakfastMenu implements Menu {
    private MenuItem[] menuItems;

    public BreakfastMenu() {
        menuItems = new MenuItem[3];
        addItem("Pancakes", 4.99);
        addItem("Omelette", 5.99);
        addItem("Bacon and Eggs", 6.49);
    }

    private void addItem(String name, double price) {
        MenuItem menuItem = new MenuItem(name, price);
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] == null) {
                menuItems[i] = menuItem;
                break;
            }
        }
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new MenuItemIterator(menuItems);
    }
}

// Similar classes for LunchMenu and DinnerMenu can be implemented.

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
