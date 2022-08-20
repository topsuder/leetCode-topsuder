package fun.suder.leetcode2022_07_05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <span>Form File</span>
 * <p>Description</p>
 * <p>Copyright: Copyright (c) 2022 版权</p>
 * <p>Company:QQ 752340543</p>
 *
 * @author topsuder
 * @version v1.0.0
 * @DATE 2022/7/6-09:18
 * @Description
 * @see fun.suder.leetcode2022_07_05 leetCode-topsuder
 */
public class Lisp语法解析 {
    Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();
    int start = 0;

    public int evaluate(String expression) {
        return innerEvaluate(expression);
    }

    /** 
     * 方法注释: <br>
     * 〈〉
     * @param	expression	
     * @return int
     * @author topsuder 🌼🐇
     * @date 2022/8/20 10:19
     */ 
    public int innerEvaluate(String expression) {
        if (expression.charAt(start) != '(') { // 非表达式，可能为：整数或变量
            if (Character.isLowerCase(expression.charAt(start))) {
                String var = parseVar(expression); // 变量
                return scope.get(var).peek();
            } else { // 整数
                return parseInt(expression);
            }
        }
        int ret;
        start++; // 移除左括号
        if (expression.charAt(start) == 'l') { // "let" 表达式
            start += 4; // 移除 "let "
            List<String> vars = new ArrayList<String>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(start))) {
                    ret = innerEvaluate(expression); // let 表达式的最后一个 expr 表达式的值
                    break;
                }
                String var = parseVar(expression);
                if (expression.charAt(start) == ')') {
                    ret = scope.get(var).peek(); // let 表达式的最后一个 expr 表达式的值
                    break;
                }
                vars.add(var);
                start++; // 移除空格
                int e = innerEvaluate(expression);
                scope.putIfAbsent(var, new ArrayDeque<Integer>());
                scope.get(var).push(e);
                start++; // 移除空格
            }
            for (String var : vars) {
                scope.get(var).pop(); // 清除当前作用域的变量
            }
        } else if (expression.charAt(start) == 'a') { // "add" 表达式
            start += 4; // 移除 "add "
            int e1 = innerEvaluate(expression);
            start++; // 移除空格
            int e2 = innerEvaluate(expression);
            ret = e1 + e2;
        } else { // "mult" 表达式
            start += 5; // 移除 "mult "
            int e1 = innerEvaluate(expression);
            start++; // 移除空格
            int e2 = innerEvaluate(expression);
            ret = e1 * e2;
        }
        start++; // 移除右括号
        return ret;
    }

    public int parseInt(String expression) { // 解析整数
        int n = expression.length();
        int ret = 0, sign = 1;
        if (expression.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        while (start < n && Character.isDigit(expression.charAt(start))) {
            ret = ret * 10 + (expression.charAt(start) - '0');
            start++;
        }
        return sign * ret;
    }

    public String parseVar(String expression) { // 解析变量
        int n = expression.length();
        StringBuffer ret = new StringBuffer();
        while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
            ret.append(expression.charAt(start));
            start++;
        }
        return ret.toString();
    }
}
