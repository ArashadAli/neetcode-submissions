class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, 0, 0, dp);
    }

    public int solve(String w1, String w2, int i, int j, int[][] dp) {
        if(i == w1.length() && j == w2.length()) return 0;
        if(i == w1.length()) return w2.length() - j;
        if(j == w2.length()) return w1.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(w1.charAt(i) == w2.charAt(j)) {
            return solve(w1, w2, i + 1, j + 1, dp);
        }

        else {
        int insert = solve(w1, w2, i, j + 1, dp);
        int delete = solve(w1, w2, i + 1, j, dp);
        int replace = solve(w1, w2, i + 1, j + 1, dp);

        dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
}
