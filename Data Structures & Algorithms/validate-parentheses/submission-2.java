class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') stack.add(chars[i]);
            else if ((chars[i] == ')') && (stack.isEmpty() || stack.pop() != '(')) return false;
            else if ((chars[i] == '}') && (stack.isEmpty() || stack.pop() != '{')) return false;
            else if ((chars[i] == ']') && (stack.isEmpty() || stack.pop() != '[')) return false;
        }
        if (!stack.isEmpty()) return false;
        stack = null;
        System.gc();
        return true;
    }
}
