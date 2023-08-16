import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class threeSum {
    HashSet<List<Integer>> solution = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        // some important observations
        // 1) we don't need to track index, only actual number so we can sort
        // 2) problem essentially reduces to two sum with target being each index
        // we'll structure it like that -- go through each index and then two sum on rest of array

        // -1, 0, 1, 2, 3
        Arrays.sort(nums);
        int count = 0;
        for(int i:nums){
            if(count > 0 && nums[count] == nums[count-1]){
                count++;
                continue;
            }
            twoSum(nums,-i,count+1);
            count++;
        }
        List<List<Integer>> ret = new ArrayList<>();
        ret.addAll(this.solution);
        return ret;
    }
    public void twoSum(int[] nums, int target, int left){
        int right = nums.length-1;
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum > target){
                right--;
                continue;
            } else if (sum < target){
                left++;
                continue;
            } else{
                ArrayList<Integer> local = new ArrayList<>();
                local.add(nums[left]);
                local.add(nums[right]);
                local.add(-target);
                local.sort(null);
                this.solution.add(local);
                left++;
            }
        }
    }
}