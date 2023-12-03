package Q7;

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