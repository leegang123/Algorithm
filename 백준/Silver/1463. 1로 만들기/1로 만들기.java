import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int size = 1000000;
        int[] dp = new int[size+1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= size; i++) {
            dp[i] = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3], dp[i]);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i]);
            }

            dp[i] = Math.min(dp[i-1], dp[i]);
            dp[i]++;
        }

        int N = stoi(br.readLine());

        sb.append(dp[N] + "\n");

        br.close();
        System.out.println(sb);
    }

    public static int stoi(String str) {return Integer.valueOf(str);}
    public static long stol(String str) {return Long.valueOf(str);}
}