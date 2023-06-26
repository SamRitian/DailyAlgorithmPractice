import java.util.Arrays;
import java.util.Comparator;

class Call {
  int start, end, duration, volume;
  
  Call(int start, int duration, int volume) {
    this.start = start;
    this.duration = duration;
    this.end = start + duration;
    this.volume = volume;
  }
}

public class MaximumOrderVolue {
  public static void main(String[] args) {
    int[] start = new int[]{1, 2, 1};
    int[] duration = new int[]{2, 2, 2};
    int[] volume = new int[]{4, 1, 3};

    System.out.println("Maximum Order Volume: " + phoneCalls(start, duration, volume));
  }

  public static int phoneCalls(int[] start, int[] duration, int[] volume) {
    int n = start.length; // number of calls
    Call[] calls = new Call[n];

    // create call objects for each call and store them in an array
    for (int i = 0; i < n; i++) {
      calls[i] = new Call(start[i], duration[i], volume[i]);
    }

    // sort the calls array by the end time of each call
    Arrays.sort(calls, Comparator.comparingInt(a -> a.end));

    // initialize dp array
    int[] dp = new int[n];
    dp[0] = calls[0].volume;

    // iterate through the calls
    for (int i = 1; i < n; i++) {
      // find the index of the last non-confliting call
      int nonConflicting = binarySearch(calls, i);

      // calculate the order volume if the current call is included
      int include = calls[i].volume;
      if (nonConflicting != -1) include += dp[nonConflicting];

      // compare the order volume if the current call is included or excluded;
      dp[i] = Math.max(include, dp[i - 1]);
    }

    // the maximum order volume is the last element in the dp array
    return dp[n - 1];
  }

  private static int binarySearch(Call[] calls, int index) {
    int left = 0, right = index - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (calls[mid].end <= calls[index].start) {
        if (calls[mid + 1].end < calls[index].start) {
          left = mid + 1;
        } else {
          return mid;
        }
      } else {
        right = mid - 1;
      }
    }
    
    return -1;
  }
}

