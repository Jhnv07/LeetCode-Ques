import java.util.ArrayList;
import java.util.List;

class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue;

            current.add(num);                     // Choose
            backtrack(nums, current, result);     // Explore
            current.remove(current.size() - 1);   // Unchoose (backtrack)
        }
    }
}
