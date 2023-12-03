package Q71;


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