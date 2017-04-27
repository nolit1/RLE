package RLE;

public class Input {

    boolean a = false;
    boolean b = false;

    public Input(String[] args) {
        for (String arg : args) {
            if (arg.equals("-z")) a = true;
            if (arg.equals("-u")) b = true;
        }
    }

    public boolean getA() {return a;}

    public boolean getB() {
        return b;
    }
}
