public class updateIthBit {
    // Function to update ith bit of number n to newValueOfBit (0 or 1)
    public static int updateIthBitValue(int n, int i, int newValueOfBit){
       if(newValueOfBit == 0){
           int bitMask = ~(1 << i);
           return n & bitMask;
       } else {
           int bitMask = 1 << i;
           return n | bitMask;
       }
    }   

    public static void main(String[] args) {
        int n = 10;  // binary: 1010
        int i = 1;   // update 1st bit (0-indexed from right)
        
        // Case 1: Update bit to 1
        System.out.println("Original number: " + n);
        System.out.println("After updating bit " + i + " to 1: " + updateIthBitValue(n, i, 1));

        // Case 2: Update bit to 0
        System.out.println("After updating bit " + i + " to 0: " + updateIthBitValue(n, i, 0));
    }
}
