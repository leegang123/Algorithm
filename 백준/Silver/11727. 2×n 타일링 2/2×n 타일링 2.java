import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        int N = stoi(br.readLine());
        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int stoi(String str) {
        return Integer.valueOf(str);
    }
}