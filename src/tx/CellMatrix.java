package tx;

import java.util.Arrays;


public class CellMatrix {
    
    private int height;

    private int width;

    private int duration;

   
    private int transfromNum=0;

    
    private int[][] matrix;

    public CellMatrix(int height, int width, int duration, int transfromNum, int[][] matrix) {
        this.height = height;
        this.width = width;
        this.duration = duration;
        this.transfromNum = transfromNum;
        this.matrix = matrix;
    }

    
    public void transform(){
        int[][] nextMatrix=new int[height][width];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                nextMatrix[y][x]=0;
                int nearNum= findLifedNum(y,x);
                
                if(nearNum==3){
                    nextMatrix[y][x]=1;
                }
                
                else if(nearNum==2){
                    nextMatrix[y][x]=matrix[y][x];
                }
            }
        }
        matrix=nextMatrix;
    }



    public int findLifedNum(int y, int x){
        int num=0;
        //宸﹁竟
        if(x!=0){
            num+=matrix[y][x-1];
        }
        //宸︿笂瑙�
        if(x!=0&&y!=0){
            num+=matrix[y-1][x-1];
        }
        //涓婅竟
        if(y!=0){
            num+=matrix[y-1][x];
        }
        //鍙充笂
        if(x!=width-1&&y!=0){
            num+=matrix[y-1][x+1];
        }
        //鍙宠竟
        if(x!=width-1){
            num+=matrix[y][x+1];
        }
        //鍙充笅
        if(x!=width-1&&y!=height-1){
            num+=matrix[y+1][x+1];
        }
        //涓嬭竟
        if(y!=height-1){
            num+=matrix[y+1][x];
        }
        //宸︿笅
        if(x!=0&&y!=height-1){
            num+=matrix[y+1][x-1];
        }
        return num;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]) + "\n");
        }
        return sb.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getTransfromNum() {
        return transfromNum;
    }

    public int getDuration() {
        return duration;
    }
}
