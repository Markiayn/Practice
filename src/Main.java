import java.util.*;

public class Main {
    public static Map<String, Integer> parse_molecule(String formula) {
        Map<String, Integer> atoms = new HashMap<>();
        Stack<Integer> pocket = new Stack<>();

        int currentNumber = 0;
        int decimalFactor = 1;
        int multiplier = 1;
        String lowerCase = "";

        for (int i = formula.length() - 1; i >= 0; i--) {
            char c = formula.charAt(i);


            if (Character.isDigit(c)) {
                currentNumber += (c - '0') * decimalFactor;
                decimalFactor *= 10;
            }
            else if (c == ')' || c == ']' || c == '}') {
                int m = (currentNumber == 0) ? 1 : currentNumber;
                pocket.push(m);
                multiplier *= m;

                currentNumber = 0;
                decimalFactor = 1;
            }
            else if (c == '(' || c == '[' || c == '{') {
                multiplier /= pocket.pop();
            }
            else if (Character.isLowerCase(c)) {
                lowerCase = String.valueOf(c);
            }
            else if (Character.isUpperCase(c)) {
                String element = c + lowerCase;

                int count = (currentNumber == 0) ? 1 : currentNumber;
                count *= multiplier;

                atoms.put(element, atoms.getOrDefault(element, 0) + count);

                // Генеральне прибирання для наступного елемента
                currentNumber = 0;
                decimalFactor = 1;
                lowerCase = "";
            }
        }
        return atoms;
    }


    public static void main(String[] args) {
        String fremySalt = "Co1050{Au30[Fe15(C120H250O110)45]60(H2O)1500}250";
        System.out.println("fremy_salt = " + parse_molecule(fremySalt));
    }
}

