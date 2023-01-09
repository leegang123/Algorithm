import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 문제 : 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 할 때, 연산을 사용하는 횟수의 최솟값을 출력.
         * 
         * 접근 : 일단 큰 문제는 정수 N을 1로 만드는 연산의 최솟값을 구하는 문제이므로, 1부터 시작하는 바텀업 방식으로 각 숫자를 1로 만드는
         * 횟수의 최솟값을 memo배열에 저장해 놓으면 각각의 경우에 1번 계산, 2번 계산, 3번 계산의 최솟값으로 쉽게 구할 수 있다.
         * 
         */

        int N = stoi(br.readLine());
        int[] memo = new int[N + 1];

        memo[1] = 0;
        for (int i = 2; i <= N; i++) {
            int curValue = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                curValue = Math.min(curValue, memo[i / 3]);
            }

            if (i % 2 == 0) {
                curValue = Math.min(curValue, memo[i / 2]);
            }

            curValue = Math.min(curValue, memo[i - 1]);
            memo[i] = ++curValue;
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