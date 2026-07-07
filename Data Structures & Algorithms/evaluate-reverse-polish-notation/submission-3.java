class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++) {
            String ch = tokens[i];
            if(ch.equals("+")) {
                int sum = 0;
                int pcount = 0;
                while(pcount < 2 && !st.isEmpty()) {
                    int val = st.pop();
                    sum += val;
                    pcount++;
                }
                st.push(sum);
            }
            else if(ch.equals("-")) {
                int right = st.pop();
                int left = st.pop();
                st.push(left - right);
            }
            else if(ch.equals("*")) {
                int res = 1;
                int pcount = 0;
                while(pcount < 2 && !st.isEmpty()) {
                    res *= st.pop();
                    pcount++;
                }
                st.push(res);
            }
            else if(ch.equals("/")) {
                int right = st.pop(); // 1st pop is right divisor
                int left = st.pop();  // 2nd pop is left dividend
                st.push(left / right);
            }
            else{
                int val = Integer.parseInt(ch);
                st.push(val);
            }
        }
        return st.pop();
    }
}
