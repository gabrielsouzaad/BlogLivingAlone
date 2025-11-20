package util;

public class ConsolePrinter {
    public void println(String s) {
        System.out.println(s);
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void printf(String fmt, Object... args) {
        System.out.printf(fmt, args);
    }
}
