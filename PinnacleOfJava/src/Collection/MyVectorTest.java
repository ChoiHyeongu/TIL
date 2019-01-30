package Collection;

public class MyVectorTest {

    public static void main(String[] args){
        MyVector vector = new MyVector();

        System.out.println(vector.size);
        System.out.println(vector.capacitiy());

        vector.add("1");
        vector.add("2");
        vector.add("3");
        System.out.println(vector);

        System.out.println(vector.remove(1));
        System.out.println(vector);
    }

}
