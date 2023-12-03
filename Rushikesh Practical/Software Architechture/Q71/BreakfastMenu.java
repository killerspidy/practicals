package Q71;


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