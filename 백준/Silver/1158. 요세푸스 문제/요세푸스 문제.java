import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.channels.WritePendingException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        String[] split = br.readLine().split(" ");
        int N = stoi(split[0]);
        int M = stoi(split[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        /*
         * 접근 : 임시 인덱스를 하나 주고 M값만큼 큐가 빌 때 까지 포문을 돌려서 계속 하나씩 지워주는 방법이 제일 먼저 생각이 났는데 구현하려고
         * 하니까 매우 비효율적인거 같아서
         * 다른 방법을 생각해 보니 인덱스로 지워야 할 값을 판단하지 않고도 큐를 이용하면 for 문을 K번을 돌리고 K번째가 되지 않았을 경우에는
         * poll을 한 후에 다시 offer를 해줘서 그 사람을 지나친
         * 효과를 주면 될 것 같다는 생각이 들었다.
         */

        while (queue.size() > 1) {
            for (int i = 1; i <= M; i++) {
                if (i == M) {
                    sb.append(queue.poll() + ", ");
                } else {
                    queue.offer(queue.poll());
                }
            }
        }

        sb.append(queue.poll() + ">");

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