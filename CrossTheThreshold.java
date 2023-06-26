public class CrossTheThreshold {

    public static void main(String[] args) {
        int n = 5;
        int[] initialEnergy = {4, 8, 7, 1, 2};
        int th = 9;

        int maxBarrier = getMaxBarrier(n, initialEnergy, th);
        System.out.println("The maximum barrier value is: " + maxBarrier);
    }

    public static int getMaxBarrier(int n, int[] initialEnergy, int th) {
      int sum = 0, maxBarrier = 0;

      while (n > 0) {
        for (int i = 0; i < initialEnergy.length; i++) {
          if (initialEnergy[i] > 0) {
            sum += initialEnergy[i];
          }
          initialEnergy[i] -= 1;
        }
        if (sum >= th) {
          maxBarrier++;
        }
        sum = 0;
        n--;
      }

      return maxBarrier;
    }
}