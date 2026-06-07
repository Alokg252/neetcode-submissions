class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        int l = nums.length, i=0,j=i+1,k=l-1;
        Arrays.sort(nums);
        while(i < l-1) {
            j=i+1;
	        k=l-1;
	        while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) k--;
                else if (sum < 0) j++;
                else {
                    Integer[] arr = {nums[i], nums[j++], nums[k]};
                    Arrays.sort(arr);
                    set.add(Arrays.asList(arr));
                }
	        }
	        i++;
        }
        return new ArrayList<>(set);
    }
}
