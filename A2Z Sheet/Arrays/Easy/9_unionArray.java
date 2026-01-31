class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;

        ArrayList<Integer> list = new ArrayList<>();

        while(i<n && j<m){
            if(nums1[i] == nums2[j]){
               addIfNotDuplicate(list, nums1[i]);
               i++;
               j++;
            }
            else if(nums1[i] < nums2[j]){
               addIfNotDuplicate(list, nums1[i]);
               i++; 
            } else if(nums1[i] > nums2[j]){
                addIfNotDuplicate(list, nums2[j]);
                j++;
            } 
        }

        while(i<n){
            addIfNotDuplicate(list, nums1[i]);
            i++;
        }

        while(j<m){
            addIfNotDuplicate(list, nums2[j]);
            j++;
        }

        int result[] = new int[list.size()];
        for(int k=0; k<list.size(); k++){
            result[k] = list.get(k);
        }

        return result;
    }

    private void addIfNotDuplicate(ArrayList<Integer> list, int val){
        if(list.size() == 0 || list.get(list.size() -1) != val){
            list.add(val);
        }
    }
}

// Time: O(n + m)
// Space: O(n + m)