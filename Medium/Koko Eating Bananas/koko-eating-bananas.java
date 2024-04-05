//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int h) {
        int max = piles[0];
        // to get the max element of array to set as right limit for binary search
        for (int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        // The maximum number of bananas Koko can eat in one hour is the maximum number
        // of bananas from all piles
        // minimum speed of eating must be 1
        int left = 1, right = max;

        while (left < right) {
            // can eat mid number of bananas per hour
            int mid = left + (right - left) / 2;

            // if finished all piles in that given hour then no need to check
            // further because if it can be finished with mid speed then it can be finished
            // with mid +1 speed also but since we need min eating speed so discarding all
            // other values next to mid setting right as mid
            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                // If cant finish bananas in given
                // hours, then increase the speed
                left = mid + 1;
            }
        }
        return right;
    }

    static boolean canEatAll(int piles[], int mid, int h) {
        int actualHour = 0;
        // checking for each hour a pile completed or not
        for (int i : piles) {
            actualHour += i / mid;

            if (i % mid != 0) {
                actualHour++;
            }
        }
        // if acutal hour less than given hour send true otherwise
        // Koko will get caught
        return actualHour <= h;

    }
}
        
