class Solution {
    public int findDuplicate(int[] arr) {
        int fast=0;
        int slow=0;
        while(true) {
            slow = arr[slow];
            fast = arr[arr[fast]];

            if(slow == fast) {
                break;
            }
        }
        fast=0;
        while(fast!=slow){
            fast = arr[fast];
            slow = arr[slow];
        }
        return fast;
    }
}

//The one big idea is: arr[i] acts like i.next
/*class Solution {
    public int findDuplicate(int[] arr) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = arr[slow];
            fast = arr[arr[fast]];

            if (slow == fast) {
                break;
            }
        }

        fast = 0;

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}
*/