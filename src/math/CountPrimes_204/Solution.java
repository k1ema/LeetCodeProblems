package math.CountPrimes_204;

/**
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Solution {
    // tc O(nlog(logn)), sc O(n)
    public int countPrimes(int n) {
        boolean[] marked = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (marked[i]) continue;
            for (int j = i * i; j < n; j += i) {
                marked[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!marked[i]) count++;
        }
        return count;
    }

    // tc O(n^2), sc O(1); time limit exceeded
    int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
