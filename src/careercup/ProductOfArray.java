package careercup;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArray {

    public static void products2(int[] a) {

        int n = a.length;
        int[] products = new int[n];
        int p = 1;
        for (int i = 0; i < n; ++i) {
            products[i] = p;
            p *= a[i];
        }
        System.out.println(Arrays.toString(products));
        p = 1;
        for (int i = n - 1; i >= 0; --i) {
            System.out.println("p = " + p + " i = " + i + " products[i] = " + products[i] + " new products[i] = " + p * products[i]);

            products[i] = p * products[i];
            p *= a[i];
        }

        System.out.println(Arrays.toString(products));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i = " + i);

            System.out.println("left = " + left);

            System.out.println("right = " + right);

            System.out.println("before output[i]  = " + output[i]);
            output[i] *= left;
            System.out.println("after output[i]  = " + output[i]);
            left *= nums[i];
            output[nums.length - i - 1] *= right;
            System.out.println("after 2 output[i]  = " + output[i]);
            right *= nums[nums.length - i - 1];
        }

        System.out.println(Arrays.toString(output));
        return output;
    }

    public static void main(String args[]) {
        //  new ProductOfArray().products2(new int[]{3, 4, 5, 6});
        new ProductOfArray().productExceptSelf(new int[]{3, 4, 5, 6});
    }
}
