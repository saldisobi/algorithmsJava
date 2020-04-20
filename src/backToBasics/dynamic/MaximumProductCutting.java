package backToBasics.dynamic;

public class MaximumProductCutting {
	public void maxProductCutting(int n) {
		int[] MPC = new int[n + 1];
		MPC[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			int mp = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				mp = Math.max(mp, Math.max(j * MPC[i - j], j * (i - j)));
			}
			MPC[i] = mp;
		}
		System.out.println("Dynamic Programming: Maximum product cutting in "
				+ n + " is: " + MPC[n]);
	}

	public static void main(String[] args) throws java.lang.Exception {
		MaximumProductCutting i = new MaximumProductCutting();
		i.maxProductCutting(10);
	}
}