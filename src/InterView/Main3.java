package InterView;

import java.util.Scanner;

public class Main3 {

    private static final int MAX = 100005;
    private static final double EPS = 1e-5;
    private static int[] rop = new int[MAX];
    private static int n, k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        double ans = 0;
        for (int i=1; i<=n; i++) {
            rop[i] = sc.nextInt();
            ans += rop[i];
        }
        double l = 0;
        double r = ans / k;
        while (l + EPS < r) {
            double kid = (l+r) / 2;
            if (okay(kid)) { l = kid; }
            else { r = kid; }
        }
        System.out.printf("%.2f", l);
    }

    public static boolean okay(double x) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            count += rop[i] / x;
        }
        if (count >= k) {return true;}
        return false;
    }

}
