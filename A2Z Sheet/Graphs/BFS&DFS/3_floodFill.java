class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor = image[sr][sc];    // original pixel color

        if(ogColor == color){   // avoid infinite recursion
            return image;
        }

        dfs(sr, sc, image, ogColor, color);
        return image;
    }

    private void dfs(int row, int col, int image[][], int ogColor,int color){
        image[row][col] = color;

        // directions: up right down left
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

             if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length &&
               image[newRow][newCol] == ogColor){

                dfs(newRow, newCol, image, ogColor, color);
            }
        }
    }
}


