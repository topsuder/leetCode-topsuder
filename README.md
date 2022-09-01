# leetCode-topsuder
〈力扣个人刷题代码仓库〉👾👾👾
## 记录耗时图

> 1470. 重新排列数组
```xpath2
src/main/java/fun/suder/leetcode2022_08_29/Solution.java
```
![img.png](src/main/resources/img/2022_08_29.jpg)

>【1475. 商品折扣后的最终价格】2022-09-01 每日一题
```xpath2
src/main/java/fun/suder/leetcode2022_09_01/Solution.java
```
```java
import java.util.Arrays;

class Solution {
    public int[] finalPrices(int[] prices) {
        final int pricesLength = prices.length;
        int[] ans = new int[pricesLength];
        for (int i = 0; i < pricesLength; i++) {
            int discount = 0;
            for (int j = i+1; j < pricesLength; j++) {
                if (prices[i]>=prices[j]){
                    discount = prices[j];
                    break;
                }
            }

            ans[i]=prices[i]-discount;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10,1,1,6};
        System.out.println(Arrays.toString(new Solution().finalPrices(ints)));
    }
}
```
![img.png](src/main/resources/img/2022_09_01.png)