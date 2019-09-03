public class Generics {
    public static void main(String[] args){
        Box<String> box = new Box<>();

        box.setItme("Item1");
        box.getItem();
        box.setItme("Item2");
        box.getItem();
    }
}

class Box<T>{

    T item;

    T getItem(){
        System.out.println(this.item);
        return this.item;
    }

    void setItme(T item){
        this.item = item;
    }
}