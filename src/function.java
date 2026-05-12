import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class function {

    String molecula = "H2O";

    public static void parse_molecule(String formula){
        Map<String, Integer> atoms = new HashMap<>();
        Stack<Integer> pocket = new Stack<>();

        int multiplier = 1;
        int currentNumber = 0;
        int decimalFactor = 1;
        String lowerCase = "";


        for (int i = formula.length() - 1; i >= 0; i--) {
            char c = formula.charAt(i);
            System.out.println(c);
        }
    }
}
