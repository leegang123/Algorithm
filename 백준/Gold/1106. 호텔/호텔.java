import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int C = stoi(split[0]);
        int N = stoi(split[1]);

        int[] arr = new int[100001];
        int[] dp = new int[100001];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            int idx = stoi(split[0]);
            int val = stoi(split[1]);

            arr[idx] = Math.max(arr[idx], val);
        }

        for (int i = 1; i <= 100000; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] == 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
            if (dp[i] >= C) {
                bw.write(i + "\n");
                break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}