import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] a = new long[n + 1];
        long[] prefixSum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        long total = 0;

        for (int l = 1; l <= n; l++) {
            for (int r = l; r <= n; r++) {
                long sum = prefixSum[r] - prefixSum[l - 1];
                long parts = (sum + s - 1) / s; // Эквивалентно округлению вверх
                total += parts;
            }
        }

        System.out.println(total);
        scanner.close();
    }
}