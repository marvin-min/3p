package iv.lambad;

public class Demo {
    public static void main(String[] args) {
        Run run = (oo)->System.out.println(oo);
        run.run("o------>0");
    }
}

interface Run{
    void run(String oo);
}
