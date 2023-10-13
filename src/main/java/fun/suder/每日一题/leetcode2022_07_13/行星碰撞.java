package fun.suder.每日一题.leetcode2022_07_13;

import java.util.Arrays;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/13-09:07
 * @Description
 * @see fun.suder.每日一题.leetcode2022_07_13 leetCode-topsuder
 */
public class 行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        for (int i = 0; i < asteroids.length-1; i++) {

            //当行星向右移动
            //当thisA大于等于0的情况下说明往右走
            if (asteroids[i]>=0) {
                for (int j = i+1; j <= asteroids.length-1; j++) {
                    if (!(asteroids[j]>=0)){
                        if (Math.abs(asteroids[i])>Math.abs(asteroids[j])) {
                            //删除j
                            asteroids[j] = 0;
                        }else if (Math.abs(asteroids[i])<Math.abs(asteroids[j])) {
                            //删除i
                            asteroids[i] = 0;
                            break;
                        }else if (Math.abs(asteroids[i])==Math.abs(asteroids[j])) {
                            //删除i
                            asteroids[i] = 0;
                            asteroids[j] = 0;
                            break;
                        }
                    }else {
                        break;
                    }
                }
            }
            //反之

        }
        //去除为0的行星
        return Arrays.stream(asteroids).filter(data -> data != 0).toArray();
    }

    public static void main(String[] args) {
        行星碰撞 myCalendar = new 行星碰撞();
        int[] asteroids = {10,2, -5};
        System.out.println(Arrays.toString(myCalendar.asteroidCollision(asteroids)));
    }
}
