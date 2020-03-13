import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplication {
    static int[][] mA =
            {{1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}};

    static int[][] mB =
            {{1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}};

    static int m = mA.length;
    static int n = mB[0].length;
    static int o = mB.length;
    static int[][] res = new int[m][n];

    static void multiply(int start1, int start2, int start3, int m, int n, int o) {
        for (int i = start1; i < m; i++) {
            for (int j = start2; j < n; j++) {
                for (int k = start3; k < o; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int x = 0; x < m; x++)
            for (int y = 0; y < n; y++) {
                final int row = x, col = y;
                // TODO: need to change parameters in calling function
                executor.submit(() -> multiply(0,0,0,m,n,o));
            }
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        }catch(InterruptedException e){
            System.out.println(e);
        }


        // TODO: print result matrix
    }
}
