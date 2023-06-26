
-------------------------------------------------------------

We are given N items where each item has some weight and profit associated with it. We are also given a bag with capacity W, 
[i.e., the bag can hold at most W weight in it]. 
The target is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 
Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].


weightArr = [5, 2, 3, 4, 5]

ProfitArr = [10, 9, 6, 4, 1]

Given a capacity of bag is N  --> N = 10

maximize the profit ??

void knacksack(int[] weigthArr, int[] profictArr, int capacity);



Int[][] mem = new int[2][2];
[
    [0, 0],
    [0, 0]
]

Integer[][] mem = new Integer[2][2]
[
    [null, null],
    [null, null]
]



Soluction {

    private Integer[][] mem; // O(2^n) -> O(n*m) 

    int knacksack(int[] weigthArr, int[] profictArr, int capacity) {
        int n = weightArr.length;
        mem = new Integer[capacity][n];

        return findMaxProfit(weightArr, profictArr, capacity, 0);

    }

    int findMaxProfit(int[] weigthArr, int[] profictArr, int currentCapacity, int currentItemIdx) {
        if (currentItem == weightArr.length) return 0;

        if（mem[currentCapacity][currentItemIdx] != null) return mem[currentCapacity][currentItemIdx];


        int max = Integer.MIN_VALUE;

        // choose currentItemIdx
        if (currentCapacity - weigthArr[currentItemIdx] >= 0) {
            max = Math.max(max, profictArr[currentItemIdx] + findMaxProfit(int[] weigthArr, int[] profictArr, currentCapacity - weigthArr[currentItemIdx], currentItemIdx + 1)); // O(2 ^ n) -> memorization 
        }
        

        // not choose currentItemIdx
        max = Math.max(max, findMaxProfit(int[] weigthArr, int[] profictArr, int currentCapacity, currentItemIdx + 1));

        mem[currentCapacity][currentItemIdx] = max;
        return max;
    }
}






e.g 1) 

findMaxProfit([5, 2, 3, 4, 5], [10, 9, 6, 4, 10] 10) ->



动态规划

1) brute force 暴力解 recursion, loop
2) overlap subproblem 



1）可性解
2） 最大化、最小化解
3） 多少种方式



面试方式

如果你在面试中卡住， 主动一点要 hint



1) Communication/Collaboration
    1) clarication:
        0/1 knacksack       -> item not reuseable         
        complete knacksack  -> item resuable 

    requirement:
     -  item not reusable -> 0/1

    2) unit test
    findMaxProfit([5, 2, 3, 4, 5], [10, 9, 6, 4, 10], 0) -> 0);
    
    3) throw the algorithm 
    My naive thought to this question is by using brute force 

    DP -> brute Force -> Optimize runtime 

2) answer the question, code style, coding solution complexity, algorithm complexity O(n*m) where n is size of capacity, m is number of items 
45 mins 

3)
10 MINS asking questions

1) How's a typical day as data engineer 
2) What technology stack,



case 1
[ i1   ]
   [ i2     ]


case 2
[   i1  ]
  [ i2 ]

i1 = arr[1]
i2 = arr[2]

overlapping interval = Math.max(arr[1][0], arr[2][0]),  Math.min(arr[1][1], arr[2][1])
if ( Math.max(arr[1][0], arr[2][0]) < Math.min(arr[1][1], arr[2][1]) { overlapping}



case2 
[i1] [i2]

overlapping interval = Math.max(arr[1][0], arr[2][0]),  Math.min(arr[1][1], arr[2][1])
if ( Math.max(arr[1][0], arr[2][0]) > Math.min(arr[1][1], arr[2][1]) {no overlapping}



int findInterval(int[][] intervals) {
    if (intervals.length == 0) return -1;
    if (intervals.length == 1) return intervals[0][1] - intervals[0][0];

    int n = intervals.length;

    int[] prev = intervals[0];

    for (int i = 1; i < n; i++) {
        int[] cur = intervals[i];

        prev[0] = Math.max(prev[0], cur[0]);  
        prev[1] = Math.min(prev[1], cur[1]);
        if (Math.max(prev[0], cur[0]) > Math.min(prev[1], cur[1]) {
            return -1;
        }
    }

    return prev[1] - prev[0];
}



// bruce force

// loop though all the len of substring 


76. Minimum Window Substring

public String minWindow(String s, String t) {

    Map<Character, Integer> targetCount = new HashMap();
    for (char c : t) {
        if (map.contains(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }   

    String ans = "";
    int minLength = Integer.MAX_VALUE;

    for (int len = 1; len <= s.length; len++) {
        for (int i = 0; i < s.length - len; i++) {
            String substring = s.substring(i, i + len);
            if (isStringContains(substring, targetCount)) {
                 if (substring.length() < minLength) {
                    ans = substring;
                    minLength = substring.length();
                 }
            }
        }

    }

    return ans;
}

publc boolean isStringContains(String substring, Map<Character, Integer> targetCount) {
    Map<Character, Integer> sourceCount = new HashMap();
    for (char c : substring) {
        if (sourceCount.contains(c)) {
            sourceCount.put(c, sourceCount.get(c) + 1);
        } else {
            sourceCount.put(c, 1);
        }
    }   

    for (Character k : targetCount.keySet()) {
        if (sourceCount.contains(k)) {
            if (!sourceCount.get(k).equals(targetCount.get(k))) return false
        } else {
            return false;
        }
    }
    return true;
}

OPTIMIAL SOLUTION
class Solution {
    
    public String minWindow(String s, String t) {
        String ans = "";
        int n = s.length();
        int[] targetCount = new int[128];
        int unique = 0;
        for (char c : t.toCharArray()) {
            if (targetCount[c] == 0) unique++;
            targetCount[c]++;
        }
        
        int[] currentWindow = new int[128];
        int matchCount = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < n; ++right) {
            char rightChar = s.charAt(right);
            currentWindow[rightChar]++;
            if (currentWindow[rightChar] == targetCount[rightChar] && targetCount[rightChar] != 0) {
                matchCount++;
            }
            while (left < n && matchCount >= unique) {
                if (right - left + 1 < min && matchCount == unique) {
                    min = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                
                
                char leftChar = s.charAt(left);
                if (currentWindow[leftChar] == targetCount[leftChar] && targetCount[leftChar] != 0) {
                    matchCount--;
                }
                currentWindow[leftChar]--;
                left++;
            }
        }
        return ans;
    }
    
    public String template1(String s, String t) {
        String ans = "";
        int n = s.length();
        int[] tt = new int[128];
        int unique = 0;
        for (char c : t.toCharArray()) {
            if (tt[c] == 0) unique++;
            tt[c]++;
        }
        
        int[] currentWindow = new int[128];
        int match = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            while (j < n && match < unique) {
                char right = s.charAt(j);
                currentWindow[right]++;
                if (currentWindow[right] == tt[right] && tt[right] != 0) {
                    match++;
                }
                j++;
            }
            
            if (j - i < min && match == unique) {
                min = j - i;
                ans = s.substring(i, j);
            }
            
            char left = s.charAt(i);
            if (currentWindow[left] == tt[left] && tt[left] != 0) {
                match--;
            }
            currentWindow[left]--;
        }
        
        
        
        return ans;
    }
}