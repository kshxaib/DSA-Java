class Solution {
    public List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int greatest = nums[n - 1];
        list.add(greatest);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > greatest) {
                greatest = nums[i];
                list.add(greatest);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

// Time: O(n)
// Space: O(n)