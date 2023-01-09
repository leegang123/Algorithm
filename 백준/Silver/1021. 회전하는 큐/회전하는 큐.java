import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int N = stoi(split[0]);
        int M = stoi(split[1]);
        Deque<Integer> deque = new ArrayDeque<>();

        int result = 0;

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int tmp = stoi(split[i]);

            int tmpIdx = 0;
            for (int j : deque) {
                if (tmp == j) {
                    break;
                } else {
                    tmpIdx++;
                }
            }

            if (tmpIdx <= deque.size() / 2) {
                while (true) {
                    if (deque.peekFirst() == tmp) {
                        deque.pollFirst();
                        break;
                    } else {
                        deque.addLast(deque.pollFirst());
                        result++;
                    }
                }
            } else {
                while (true) {
                    if (deque.peekFirst() == tmp) {
                        deque.pollFirst();
                        break;
                    } else {
                        deque.addFirst(deque.pollLast());
                        result++;
                    }
                }
            }
        }

        sb.append(result + "\n");

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