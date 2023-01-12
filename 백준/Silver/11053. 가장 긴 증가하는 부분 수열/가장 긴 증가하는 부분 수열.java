import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 수열 A와 수열 A를 이루고 있는 A[i]가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
         * 
         * 접근 : 일단 다이나믹 프로그래밍이 되려면, 내가 풀고자 하는 큰 문제를 작은 문제들로 쪼갤 수 있는지 판단해야 해서 생각해보니,
         * 1,2,3,....i-1번째까지의 가장 긴 증가하는 부분 수열(각각의 인덱스는 그 수를 마지막으로 하는 증가하는 부분 수열의 길이)로
         * 저장해보면 만약 i번째 수가 j(1 <= j < i)보다 큰 경우에는
         * j번째까지의 가장 긴 증가하는 부분 수열의 길이에 1을 더해주기만 하면 된다는 사실을 알게 됨.
         */

        int N = stoi(br.readLine());
        int[] arr = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(split[i]);
        }

        int[] memo = new int[N];
        memo[0] = 1;

        for (int i = 1; i < N; i++) {
            int curVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    curVal = Math.max(curVal, memo[j]);
                }
            }

            memo[i] = ++curVal;
        }

        sb.append(Arrays.stream(memo).max().getAsInt());

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