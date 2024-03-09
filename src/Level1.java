public class Level1 {
    public static int ConquestCampaign(int N, int M, int L, int[] battalion) {

        int x = 0;
        int y = 1;


        int[][] matrix = new int[N][M];

        for (int z = 0; z < matrix.length; z++)
            for (int c = 0; c < matrix[x].length; c++) {
                matrix[x][y] = 0;
            }

        for (int f = 0; f < L; f++) {
            matrix[battalion[x] - 1][battalion[y] - 1] = 1;
            x += 2;
            y += 2;
        }

        int day = 1;
        int flag = 1;
        int amt = 0;
        boolean complete = false;
        while (!complete) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == flag) {
                        if (i != (matrix.length - 1) && matrix[i + 1][j] == 0) {
                            matrix[i + 1][j] = flag + 1;
                            amt++;
                        }
                        if (i != 0 && matrix[i - 1][j] == 0) {
                            matrix[i - 1][j] = flag + 1;
                            amt++;
                        }
                        if (j != (matrix[i].length - 1) && matrix[i][j + 1] == 0) {
                            matrix[i][j + 1] = flag + 1;
                            amt++;
                        }
                        if (j != 0 && matrix[i][j - 1] == 0) {
                            matrix[i][j - 1] = flag + 1;
                            amt++;
                        }
                    }

                }

            }

            if (amt > 0) day++;
            flag++;
            complete = true;
            for (int z = 0; z < matrix.length; z++) {
                for (int c = 0; c < matrix[z].length; c++) {
                    if (matrix[z][c] == 0) {
                        complete = false;
                        amt = 0;
                    }
                }
            }
        }
        return day;
    }


}



