class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        // while (coins > 0 && i < costs.length) { 
        /*
        while (coins >= costs[i] && i < costs.length)
        still has a problem because Java evaluates conditions from left to right.
        Suppose:
        costs = [1,2]
        coins = 10
        After buying both ice creams:
        i = 2
        Now the condition becomes:
        coins >= costs[2] && 2 < 2
        But costs[2] does not exist, so the program crashes before even checking 2 < 2
        */
        while (i < costs.length && coins >= costs[i]) { 
            coins -= costs[i];
            i++;
        }
        return i;
    }
}