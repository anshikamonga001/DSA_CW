class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(n,k,1,curr,ans);
        return ans;
    }
    public void helper(int n, int k, int i, List<Integer> curr, List<List<Integer>> ans){
        //base case
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>n) return;

        curr.add(i);
        helper(n,k,i+1,curr,ans);
        //backtrack
        curr.remove(curr.size()-1);
        helper(n,k,i+1,curr,ans);
    }
}