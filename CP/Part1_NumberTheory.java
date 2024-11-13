import java.util.Arrays;

public class Part1_NumberTheory {
    // sqrt n time
    public static int findDivisors(int n) {
        int count = 0;
        System.out.print("Divisors of " + n + ": ");
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                count++;
                if (i != n / i) {
                    System.out.print(n / i + " ");
                }
            }
        }
        System.out.println();
        return count;
    }

    public static void isPrime(int n) {
        int numOfDivisors = findDivisors(n);
        if (numOfDivisors > 2) {
            System.out.println(n + " is not prime");
        } else {
            System.out.println(n + " is prime");
        }
    }

    // Time complexity
    // n/1 + n/2 + n/3 ... + n/n = does not exceed O(nlogn) and logn << nrootn
    // its better to iterate over multiples instead of divisors
    public static void numOfDivisors(int n) {
        int divisors[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                divisors[j]++;// i is divisor of j
            }
        }

        // number of divisors of 100 numbers
        for (int i = 1; i <= n; i++) {
            System.out.println("Number of divisors of " + i + " : " + divisors[i]);
        }
    }

    // Sieve of Eratos thenes TC: O(nlog(logn)) -> very fast -> almost linear
    // cp-algorithms.com/algebra/prime-sieve-linear.html -> This is O(N) code
    public static void sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (prime[i])
                System.out.print(i + " ");
        }
    }

    // Euclidean algorithm -> O(log(max(a, b)))
    // gcd(a, b) = gcd(a, b - 1)
    // gcd(a, b) = gcd(b % a, a);
    // gcd(8, 18) = gcd(8, 10)

    //coprime numbers -> gcd(a, b) = 1
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int n = 100;
        // close to n root n time complexity
        // for (int i = 1; i <= n; i++) {
        // isPrime(i);
        // }

        // numOfDivisors(n);

        sieveOfEratosthenes(n);

        System.out.println(gcd(8, 18));
    }
}
