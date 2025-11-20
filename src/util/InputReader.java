package util;

import java.util.Scanner;

public class InputReader {
    private final Scanner sc;

    public InputReader() {
        this.sc = new Scanner(System.in);
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public int readInt(String prompt) {
        for (;;) {
            String line = readLine(prompt).trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número válido.\n");
            }
        }
    }

    public int readIntInRange(String prompt, int min, int max) {
        for (;;) {
            int value = readInt(prompt);
            if (value < min || value > max) {
                System.out.printf("Valor inválido. Digite um número entre %d e %d.%n", min, max);
                continue;
            }
            return value;
        }
    }
}
