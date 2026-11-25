
import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int x : matchsticks) {
            sum += x;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        
        int target = sum / 4;
        int n = matchsticks.length;

        int[] sides = new int[4];

        return solve(matchsticks, n - 1, sides, target);
    }

    private boolean solve(int[] nums, int index,
                          int[] sides, int target) {

        if (index < 0) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + nums[index] <= target) {

                sides[i] += nums[index];

                if (solve(nums, index - 1, sides, target)) {
                    return true;
                }

                sides[i] -= nums[index];
            }

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}
