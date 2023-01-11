import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 문제 : N이 주어졌을 때, 길이가 N인 계단 수가 총 몇개 있는지 구하는 프로그램 작성.
         * 
         * 접근 : 일단 계단 수의 정의에 대해서 먼저 생각을 해보면, 인접한 모든 자리의 차이가 1인 수라고 했으므로 이 정의에 따라 어떻게 구해야
         * 할지 생각을 해봐야 한다.
         * 이 문제를 보면 결국 길이가 N인 계단수를 구하라는 큰 문제를 길이가 N-1, N-2, N-3, ... 1인 계단 수를 구하라는 문제로
         * 잘게 쪼개서 생각할 수 있는데,
         * 문제가 계단 수이기 때문에 중요한 점은 각각의 경우에 맨 뒤에 오는 숫자에 따라서 분류를 해주어야 한다.
         * memo배열을 memo[N][10]으로 정의를 해야 결국 계단수를 이루는 원소인 0~9까지를 모두 담아주고 작은 문제 각각의 경우에 i-1
         * 번째 계단 수를 구하는 것으로 나누어서 마지막 오는 수에 따라
         * 처리를 해 줄 수 있다.
         */

        int N = stoi(br.readLine());
        long[][] dp = new long[N + 1][10];
        dp[1][0] = 0;
        dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = dp[1][6] = dp[1][7] = dp[1][8] = dp[1][9] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            dp[i][9] = dp[i - 1][8];

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        sb.append((Arrays.stream(dp[N]).sum()) % 1000000000);

        br.close();
        System.out.println(sb);
    }

    public static int stoi(String str) {
        return Integer.valueOf(str);
    }

    public static long stol(String str) {
        return Long.valueOf(str);
    }
}