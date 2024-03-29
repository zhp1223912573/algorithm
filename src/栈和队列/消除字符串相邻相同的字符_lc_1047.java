package 栈和队列;

import java.util.Stack;

/**
 * @author zhp
 * @date 2021-11-16 11:42
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
 * 消除字符串相邻相同的字符
 */
public class 消除字符串相邻相同的字符_lc_1047 {
    public String removeDuplicates(String s) {
      //方法一
        return doublePointer(s);

    }

    /**
     *
     * @param s
     * @return
     * 利用stringbuilder模仿栈 同样用top记录最后元素位置
     *
     */
    public String stringbuilder(String s){
        StringBuilder stack = new StringBuilder();
        int top=-1;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(top>=0&&stack.charAt(top)==ch){
                stack.deleteCharAt(top);
                top--;
            }else{
                stack.append(ch);
                top++;
            }
        }
        return  stack.toString();
    }



    /**
     *
     * @param s
     * @return
     * 数组.双指针 使用top指向不被消除的字符串的最后一个字符位置
     * 遍历原字符串 若出现无法消除的字符（相邻字符不匹配） 则添加到数组中
     * 若出现可消除的字符时 直接将top向前移动 时原先字符在后续被覆盖或者直接忽略
     */
    public String doublePointer(String s){
        int top=-1;
        char ch[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(top==-1||ch[top]!=ch[i]){
                ch[++top]=ch[i];
            }else{
                top--;
            }
        }

        return String.valueOf(ch,0,top+1);
    }

    /**
     * 基于栈
     * @param s
     * @return
     */
    public String removeDuplicates1(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            boolean flag = false;
            while(!stack.isEmpty()&&stack.peek()==ch){
                stack.pop();
                flag = true;
                break;
            }
            if(flag) continue;
            stack.push(ch);

        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
