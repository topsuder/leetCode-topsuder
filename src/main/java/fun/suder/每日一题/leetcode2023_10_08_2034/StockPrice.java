package fun.suder.每日一题.leetcode2023_10_08_2034;

class StockPrice {

    public int[] currentArr;

    /**
     * 第二大的价格
     */
    public int[] doubleMaximumArr;

    public int[] maximumArr;

    public int[] minimumArr;

    public StockPrice() {

    }
    
    public void update(int timestamp, int price) {

        if (maximumArr[1]<price){
            maximumArr[0]=timestamp;
            maximumArr[1]=price;
        }
        if (minimumArr[1]>price){
            minimumArr[0]=timestamp;
            minimumArr[1]=price;
        }


    }
    
    public int current() {
        return currentArr[1];
    }
    
    public int maximum() {
        return maximumArr[1];
    }
    
    public int minimum() {
        return minimumArr[1];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */