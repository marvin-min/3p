package lj.td.single;

public class Eager {
    private Eager(){}
    private final static Eager INSTANCE =  new Eager();

    public static Eager getInstance(){
        return INSTANCE;
    }

}
