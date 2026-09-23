class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        solve(nums, used, new ArrayList<>(), ans);

        return ans;
    }

    // Helper function
    public void solve(int[] nums, boolean[] used,
                      List<Integer> curr,
                      List<List<Integer>> ans) {

        // Base case
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Try every element
        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (used[i]) {
                continue;
            }

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            curr.add(nums[i]);
            used[i] = true;

            // Recursive call
            solve(nums, used, curr, ans);

            // Backtrack
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}