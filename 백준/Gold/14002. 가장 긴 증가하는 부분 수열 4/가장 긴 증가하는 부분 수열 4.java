import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
         * 문제 : 수열의 크기 N과 수열을 이루고 있는 원소들이 주어졌을 때, 가장 긴 증가하는 부분 수열의 길이를 출력하고, 가장 긴 증가하는
         * 부분 수열을 출력하는 프로그램 작성.
         * 
         * 접근 : 일단 수열이 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 것은 이미 풀었으므로 넘어가고, 가장 긴 증가하는 부분 수열을
         * 구해야 하는데,
         * 이 과정에서는 역추적을 해야 한다.
         * 역추적을 하는 방법은 배열을 하나 생성하고, 문제에서 원하는 조건에 맞아 답에 새로운 원소가 추가되면 원래 있던 배열의 마지막 원소의
         * 인덱스에 1을 더해주면 결국에는
         * 문제에서 요구하는 답의 순서가 나오게 된다.
         */

        int N = stoi(br.readLine());
        int[] arr = new int[N];
        int[] memo = new int[N];
        int[] idx = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(split[i]);
        }

        memo[0] = 1;

        for (int i = 1; i < N; i++) {
            int curVal = 0; // 현재 원소까지의 가장 긴 증가하는 부분 수열의 길이를 담아줄 임시변수
            int curIdx = -1; // 현재 원소의 가장 긴 증가하는 부분 수열에서의 위치(인덱스)를 담아줄 임시변수 길이는 최솟값이 1이기 때문에 0으로 잡았지만, 인덱스는
                             // 최솟값이 -1이므로 0으로 설정.
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { // 문제에서 구하라는 것이 가장 긴 증가하는 부분 수열이므로 현재 원소가 그 전 원소보다 큰 경우에만 가장 긴 증가하는 부분 수열이 성립한다.
                    curVal = Math.max(curVal, memo[j]);
                    curIdx = Math.max(curIdx, idx[j]);
                }
            }

            memo[i] = ++curVal;
            idx[i] = ++curIdx;
        }

        // 역추적은 무조건 뒤에서부터!
        // 스택을 사용하여 역추적

        // 최장 길이를 담을 변수.
        int result = Arrays.stream(memo).max().getAsInt();

        // 경로를 역추적 하기 위해서 현재 찾고자하는 인덱스를 표현해줄 임시변수.
        int value = result - 1;

        // 실제 역추적한 값을 담아줄 스택(스택을 사용한 이유는 후입선출이기 때문에 지금 뒤에서부터 역추적해 들어간 값이 반대로 나와야하기 때문.)
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            if (value == idx[i]) {
                stack.push(arr[i]);
                value--;
            }
        }

        sb.append(result + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();

    }

    public static int stoi(String str) {
        return Integer.valueOf(str);
    }

    public static long stol(String str) {
        return Long.valueOf(str);
    }
}