public class flood_fill {
    static int[][] graph = { { 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1 }, };

    public static void main(String[] args) {
        System.out.println(flood());
    }

    public static int flood() {
        int regions = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (graph[i][j] == 0) {
                    dfs(i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    public static void dfs(int x, int y) {
        graph[x][y] = 1;
        check(x + 1, y);
        check(x - 1, y);
        check(x, y + 1);
        check(x, y - 1);

    }

    public static void check(int x, int y) {
        if (x < 5 && x >= 0 && y < 5 && y >= 0 && graph[x][y] == 0) {
            dfs(x, y);
        }
    }
}
