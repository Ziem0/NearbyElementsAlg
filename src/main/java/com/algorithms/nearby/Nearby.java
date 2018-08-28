package com.algorithms.nearby;


import java.util.Arrays;

public class Nearby {

    private int[][] multi;

    public Nearby() {
        this.multi = new int[][]{
                {2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
                {1, 3, 5, 7},
                {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
        };
    }

    private int[] createRowList(int x, int y) {
        return Arrays.copyOfRange(multi[x],0,multi[x].length);
    }

//    public int[] nearby(int x, int y, int range) {
//        x = x - 1;
//        y = y - 1;
//        int[] temp = createRowList(x, y);
//        int[] result;
//
//            if (y - range < 0 && y + range > temp.length) {
//                result = Arrays.copyOfRange(temp, 0, temp.length);
//            } else if (y - range < 0) {
//                result = Arrays.copyOfRange(temp, 0, y + range + 1);
//            } else if (y + range > temp.length) {
//                result = Arrays.copyOfRange(temp, y - range, temp.length);
//            } else {
//                result = Arrays.copyOfRange(temp, y - range, y + range + 1);
//            }
//
//        return result;
//    }

    public int[] nearby2(int x, int y, int range) {
        x = x - 1;
        y = y - 1;
        int[] temp = createRowList(x, y);

        int start = y - range;
        if (y - range < 0) {
            start = 0;
        }

        int end = y + range;
        if (y + range >= temp.length) {
            end = temp.length-1;
        }

        int[] result = new int[end-start];
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (i != y) {
                result[counter] = temp[i];
                counter++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Nearby n = new Nearby();
        int[] r = n.nearby2(1, 2, 50);

        for (int i : r) {
            System.out.println(i);
        }
    }
}
