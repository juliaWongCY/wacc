package type;

public class BoolType extends Type {

    public BoolType() {

    }

    public static void main(String[] args) {
        BoolType b1 = new BoolType();
        BoolType b2 = new BoolType();
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b1));
    }

}
