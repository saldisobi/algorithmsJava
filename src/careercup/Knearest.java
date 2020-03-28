package careercup;

import java.util.ArrayList;
import java.util.List;

public class Knearest {
    int minDiff = Integer.MAX_VALUE;

    int minDiffPos = 0;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {



        List<Integer> closestList = new ArrayList<>();
        int itemPosition = binarySearch(arr, x, 0, arr.length - 1);

        System.out.print("item pos "+itemPosition);
        closestList.add(arr[itemPosition]);

        int left = itemPosition - 1;
        int right = itemPosition + 1;
        int d = 1;

        while (d < k) {


            if (left < 0) {
                closestList.add(arr[right]);
                right++;
                d++;
            } else if (right > arr.length - 1) {
                closestList.add(0, arr[left]);
                left--;
                d++;
            } else if (Math.abs(x - arr[left]) <Math.abs(x - arr[right])) {
                closestList.add(0, arr[left]);
                left--;
                d++;
            }else if (Math.abs(x - arr[left]) ==Math.abs(x - arr[right])) {
                closestList.add(0, arr[left]);
                left--;
                d++;
            } else {
                closestList.add(arr[right]);
                right++;
                d++;
            }
        }


        return closestList;
    }




    private int binarySearch(int[] arr, int x, int start, int end) {

        if (start == end || start > end) {
            return minDiffPos;
        } else {
            int median = (start + end) / 2;
            if (x == arr[median]) {
                return median;
            } else if (x < arr[median]) {
                if (Math.abs(x - arr[median]) < minDiff) {
                    minDiff = x - arr[median];
                    minDiffPos = median;
                }
                return binarySearch(arr, x, start, median - 1);
            } else {
                if (Math.abs(x - arr[median]) < minDiff) {
                    minDiff = x - arr[median];
                    minDiffPos = median;
                }
                return binarySearch(arr, x, median + 1, end);
            }
        }

    }

    public static void main(String args[]) {
        System.out.print(new Knearest().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }
}
