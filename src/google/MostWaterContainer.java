package google;

public class MostWaterContainer {

    public int getMostWaterContainer(int[] input) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= input.length; i++) {
            for (int j = i + 1; j <= input.length; j++) {
                if (i == j)
                    continue;
                int area = Math.min(input[i - 1], input[j - 1]) * (j-i);
                if (area > max)
                    max = area;
            }
        }
        return max;

    }

    public static void main(String args[]) {
        System.out.print(new MostWaterContainer().getMostWaterContainer(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
