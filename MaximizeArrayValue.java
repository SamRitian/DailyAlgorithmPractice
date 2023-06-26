/*
 Given an array arr[] consisting of N ranges of the form [L, R], 
 the task is to determine the size of the smallest set that 
 contains at least 2 integers within each interval.

 Input: arr[] = { {1, 3}, {2, 5}, {1, 4} }
  Output: 2
  Explanation: Interval [1, 3] contains the numbers 1, 2, 3.
  Interval [2, 5] contains the numbers 2, 3, 4, 5.
  Interval [1, 4] contains the numbers 1, 2, 3, 4.
  Selecting set {2, 3} would be the smallest set covering all intervals.  

  Input: arr[] = { {3, 6}, {2, 4}, {0, 2}, {4, 7} }
  Output: 4
  Explanation: Possible Sets are

  [0, 2], [4, 5] = 5
  [1, 2], [4, 5] = 4
  [0, 2], [4, 6] = 6
  [1, 2], [4, 6] = 5
 */

class MaximizeArrayValue {
  public static void main(String args[]) {

  }

  public soluction() {
    /* 
    - Sort the array according to their endpoint in ascending order, AND if two 
    intervals have the same end, sort them according to their start point in descending order.
    
    - If there is no number in this interval being chosen before, we pick up the 2 biggest 
    number in this interval (the biggest number have the most possibility to be used by the next interval).
    
    - If there is one number in this interval being chosen before, we pick up the biggest number in this interval.
    
    - If there are already two numbers in this interval being chosen before, we can skip this interval 
    since the requirement has been fulfilled.
    */
  }
}