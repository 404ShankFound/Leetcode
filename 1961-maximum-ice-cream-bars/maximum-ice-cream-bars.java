class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        // while (coins > 0 && i < costs.length) { 
        while (i < costs.length && coins >= costs[i]) { 
            coins -= costs[i];
            i++;
        }
        return i;
    }
}