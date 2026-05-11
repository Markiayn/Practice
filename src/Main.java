import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primesList = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primesList.add(i);
            }
        }
        return primesList;
    }


    public static void main(String[] args) {
        int N = 10000;
        List<Integer> myPrimes = getPrimes(N);
        System.out.println("Список простих чисел до " + N + ":");
        System.out.println(myPrimes);

    }
}

