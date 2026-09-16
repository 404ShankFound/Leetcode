class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            if (set.contains(n))
                return false;

            set.add(n);

            int sum = 0;

            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}
/*
class Solution {
    public boolean isHappy(int n) {
        // For any number, repeatedly calculating the sum of
        // squares of digits will eventually reach either:
        // 1  -> Happy number
        // 4  -> Unhappy number (starts an infinite cycle)
        //
        // We continue while n > 4.
        while (n > 4) {

            // Calculate the sum of squares of all digits
            // and use it as the new n.
            n = getNext(n);
        }

        // If we reach 1 or 7, the number is happy.
        //
        // 1 is directly the happy ending.
        // 7 is also happy:
        // 7 -> 49 -> 97 -> 130 -> 10 -> 1
        //
        // If we reach 4 or any other value <= 4,
        // it is not a happy number.
        if (n == 1 || n == 7)
            return true;
        else
            return false;
    }

    // Returns the sum of squares of the digits of n.
    private int getNext(int n) {

        int totalSum = 0;

        // Process every digit of n.
        while (n > 0) {

            // % 10 gives the last digit.
            // Example: 82 % 10 = 2
            int digit = n % 10;

            // Add the square of the digit.
            // Example: digit = 2 -> 2 * 2 = 4
            totalSum += digit * digit;

            // / 10 removes the last digit.
            // Example: 82 / 10 = 8
            n /= 10;
        }
        return totalSum;
    }
}
*/