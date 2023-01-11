import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 문제 : 구매하려고 하는 카드의 개수 N이 주어졌을 때, N개의 카드를 구매하기 위해 지불해야 하는 금액의 최솟값을 구하는 프로그램을
         * 작성하시오.
         * 
         * 접근 : N개의 카드를 구매하기 위해 지불해야 하는 금액의 최솟값을 구하려고 생각을 하면, 결국에 다이나믹 프로그래밍으로 작은 문제(1개의
         * 카드를 사는 최소 비용, 2,3,4,....,N)를 풀면
         * N개의 카드를 구매하기 위해서는 N-1개를 사는 비용 + 1개를 사는 비용, N-2개를 사는 비용 + 2개를 사는 비용.... 이런 식으로
         * 가다보면 문제를 풀 수 있을 것 같다.
         */

        int N = stoi(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i + 1] = stoi(split[i]);
        }

        int[] memo = new int[N + 1];
        memo[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            memo[i] = arr[i];
            for (int j = 1; j < i; j++) {
                memo[i] = Math.min(memo[i - j] + memo[j], memo[i]);
            }
        }

        sb.append(memo[N]);

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