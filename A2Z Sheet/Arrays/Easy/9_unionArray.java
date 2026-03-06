/*
        UNION OF TWO SORTED ARRAYS 
Definition:
The union of two arrays contains all distinct elements
present in either array.

Since both arrays are sorted, we can efficiently build
the union using the two-pointer technique.

Core Idea:
Use two pointers to traverse both arrays simultaneously.

1. Compare elements at nums1[i] and nums2[j].
2. Add the smaller element to the result if it is not
   already added.
3. Move the corresponding pointer forward.
4. If both elements are equal, add it once and move
   both pointers.

After one array finishes, add remaining elements from
the other array.

Example:
nums1 = [1,2,4,5]
nums2 = [1,3,4,6]

Process:
1 → add once
2 → add
3 → add
4 → add once
5 → add
6 → add

Result:
[1,2,3,4,5,6]

Complexities:
Time Complexity  : O(n + m)
Space Complexity : O(n + m)

Properties:
- Uses two-pointer technique
- Avoids duplicates
- Efficient because arrays are sorted

Key Interview Points:
- Works only because arrays are sorted
- If arrays were unsorted → HashSet approach needed
- Two-pointer technique reduces complexity from
  O((n+m) log(n+m)) to O(n+m)
*/

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