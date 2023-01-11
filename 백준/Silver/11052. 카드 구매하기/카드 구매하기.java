import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 문제 : 구매하려고 하는 카드의 개수 N과 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 지불해야 하는 금액의 최댓값을
         * 구하는 프로그램 작성.
         * 
         * 접근 : N개의 카드를 구매할 때의 지불해야 하는 금액의 최댓값은 반복문 변수 i를 카드팩 안에 들어있는 카드의 개수로 지정하고 반복문을
         * 돌리게 되면 N개의 카드를 구매하는데 드는 비용의 최댓값은 n-i 개를 구매하는데 필요한 비용의 최댓값과 i개를 구매하는데 드는 비용의 최댓값을 더하면 된다는 것만 확실하면
         * 점화식이 성립한다.
         */

        int N = stoi(br.readLine());
        int[] arr = new int[N + 1];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i + 1] = stoi(split[i]);
        }

        int[] memo = new int[N + 1];
        memo[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            memo[i] = arr[i];
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(memo[i - j] + memo[j], memo[i]);
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