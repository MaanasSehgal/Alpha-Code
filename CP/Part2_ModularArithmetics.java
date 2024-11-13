public class Part2_ModularArithmetics {

    // binary exponentiation
    // O(log b) time
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

    public static void main(String[] args) {
        // Specific Case of Modular Part2_ModularArithmetics -> %2
        // Even -> e, Odd -> O
        // Addition
        // e + e = e
        // e + o = o
        // o + o = e
        // Multiplication
        // e * e = e
        // e * o = e
        // o * o = o

        // To find (a + b) % m or (a * b) % m where it can go above range
        // (a + b) % m = ((a % m) + (b % m)) % m
        // (a * b) % m = ((a % m) * (b % m)) % m
        // (a - b) % m = ((a % m) - (b % m) + m) % m: The extra m is for not having
        // negative like 1 - 2 = -1

        // Derive:
        // a -> k1 * m + r1 (multiple of m + remainder)
        // b -> k2 * m + r2 (multiple of m + remainder)
        // (k1 + k2)m + (r1 + r2)
        // as k1 and k2 are multiples of m, k1 + k2 is multiple of m, so (k1 + k2) % m
        // leftover -> r1 + r2 which is ((a % m) + (b % m)) % m

        // Example: (43 + 57) % 4 = ((43 % 4) + (57 % 4)) % 4 = (3 + 1) % 4 = 4 % 4 = 0
        // Example: (9 * 13) % 5 = ((9 % 5) * (13 % 5)) % 5 = (4 * 3) % 5 = 12 % 5 = 2
        // Example: (7 - 2) % 3 = ((7 % 3) - (2 % 3) + 3) % 3 = (1 - 2 + 3) % 3 = (2 %
        // 3) = 2

        System.out.println(pow(3, 10, 2));

        // Now for division
        // multiplicative inverse of 2 is 3, why?
        // 2x % 5 = 1
        // x is multiplicative inverse of 2
        // 2 * 0 % m = 0
        // 2 * 1 % m = 2 % 5 = 2
        // 2 * 2 % m = 4 % 5 = 4
        // 2 * 3 % m = 6 % 5 = 1

        // (38 / 2) % 5
        // 38 % 5 -> 3
        // 2 % 5 = 2
        // multiplicative inverse of 2 is 3
        // so (3 * 2inv) % 5 = (3 * 3) % 5 = 9 % 5 = 4

        // WORKS ONLY FOR M AS PRIME

        // 2 questions arise:
        // 1) Guarentee of multiplicative inverse to even exist?
        // Ans: if gcd(b, m) == 1 : coprime

        // 2) How to find multiplicative inverse?
        // Ans: b inv = (b ^ m - 2) % m 

        // FERMAT'S LITTLE THEOREM (ONLY IF M IS PRIME)

        int a = 156, b = 4, m = 17;
        int res1 = (a / b) % m;

        a = a % m;
        int invOfB = pow(b, m - 2, m);
        int res2 = a * invOfB % m;

        System.out.println(res1 + " == " + res2);

    }
}
