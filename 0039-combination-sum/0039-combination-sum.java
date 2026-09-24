class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> list,
                           List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            list.add(candidates[i]);
            backtrack(candidates,
                      target - candidates[i],
                      i,
                      list,
                      ans);
            list.remove(list.size() - 1);
        }
    }
}