import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 문제 : 0과 1로만 이루어져 있으면서, 0으로 시작하지 않고, 11을 부분 문자열로 갖지 않는 '이친수'의 개수를 구하는 프로그램을
         * 작성하시오.
         * 
         * 접근 : N자리 이친수의 개수를 구하는 문제이므로 이 문제를 1,2,3,....,N-1개의 작은 문제들로 쪼갰을 때 문제가 풀린다면
         * 다이나믹 프로그래밍으로 해결할 수 있는 문제이다.
         * 그런데 생각을 해보니 i자리 이친수를 구하기 위해서는 i-1번째 자리에서 0 이나 1을 문제가 요구하는 조건에 맞도록 더해주면 되므로
         * 다이나믹 프로그래밍이 가능할 것 같다.
         */

        int N = stoi(br.readLine());
        long[][] dp = new long[N + 1][2];
        dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        sb.append(Arrays.stream(dp[N]).sum());

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