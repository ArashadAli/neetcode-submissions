class Solution {
    public boolean isPalindrome(String st) {
        String str = st.toLowerCase();
        char[] ch = str.toCharArray();
        int s = 0;
        int e = ch.length - 1;
        while(s < e){
            while(s < e && !Character.isLetter(ch[s]) && !Character.isDigit(ch[s])) s++;
            while(s < e && !Character.isLetter(ch[e]) && !Character.isDigit(ch[e])) e--;
            if(ch[s] != ch[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}