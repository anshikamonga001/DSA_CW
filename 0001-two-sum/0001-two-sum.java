class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int needed = target - nums[i];
            if(!mp.containsKey(needed)){
                mp.put(nums[i],i);
            }
            else if(mp.containsKey(needed)){
                return new int[]{mp.get(needed),i};
            }
        }
        return new int[]{};
    }
}