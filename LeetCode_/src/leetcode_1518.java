class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles;
        int empty = 0;
        int count = numBottles;
        while(true){
            if(numBottles < numExchange)
                break;
            n = numBottles/numExchange;
            empty = numBottles - n*numExchange;
            count += n;
            numBottles = empty + n;
        }
        return count;
    }
}