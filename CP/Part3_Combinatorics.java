public class Part3_Combinatorics {
    public static int pow(int a, int b, int m) {
        if (b == 0) {
            return a % m;
        }
        if (b % 2 == 0) {
            int temp = pow(a, b / 2, m);
            return (temp * temp % m);
        } else {
            int temp = pow(a, (b - 1) / 2, m);
            temp = (temp * temp) % m;
            return a * temp % m;
        }
    }

    static int n = 1000000;
    static int fact[] = new int[n];
    static int invFact[] = new int[n];
    static int p = 1000000007;

    public static void storeFactorials(int n) {
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i % p;
        }

        invFact[n - 1] = pow(fact[n - 1], p - 2, p);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % p;
        }
    }

    public static int ncr(int n, int r) {
        if (r > n || n < 0 || r < 0) {
            return 0;
        }
        return fact[n] * invFact[r] % p * invFact[n - r] % p;
    }

    public static void main(String[] args) {
        // Revise school level
        // nCr

        // n! / r! (n - r!)

        // instead of calculating n! r! every single time, see constraint and store an
        // array of factorials
        // 1 2 4... -> O(n)
        // also store inverse of factorial
        // 1!inv 2!inv 3!inv ... n!inv
        // n!inv -> (n - 1)!inv

        // 1 1
        // - = ----------
        // n n * (n - 1)!

        // multiply by n both side, n cancels out in right side denominator
        // (n - 1)! inv = n * invFact(n) -> O(1) each
        System.out.println(ncr(4, 2));
    }
}
