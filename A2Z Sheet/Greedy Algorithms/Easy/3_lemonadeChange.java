/*
        LEMONADE CHANGE

Definition:
At a lemonade stand:

Each lemonade costs $5.

Customers pay using:

• $5
• $10
• $20

Initially:

No money in cash register.

Return true if we can provide
correct change to every customer.

Otherwise return false.


Example 1

Input:
bills = [5,5,5,10,20]

Output:
true

Explanation:

Customer 1:
Pays $5
No change needed

Register:
5 = 1


Customer 2:
Pays $5

Register:
5 = 2


Customer 3:
Pays $5

Register:
5 = 3


Customer 4:
Pays $10

Give one $5

Register:
5 = 2
10 = 1


Customer 5:
Pays $20
Need $15 change

Give:
$10 + $5

Register:
5 = 1
10 = 0
Possible ✔


Example 2
Input:
bills = [5,5,10,10,20]

Output:
false

Explanation:
Need $15 change for $20
Only two $10 bills available
Cannot give exact change.


Greedy Idea
Always prefer:
$10 + $5

instead of
$5 + $5 + $5
for a $20 bill.

Why?
$5 bills are more valuable
for future transactions.


Time Complexity: O(n)
Single traversal

Space Complexity:cO(1)
Only two counters
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int dollar5 = 0, dollar10 = 0;

        for(int i=0; i<bills.length; i++){
            int bill = bills[i];

            if(bill == 5){
                dollar5++;
            }

            else if(bill == 10){
                dollar10++;

                if(dollar5 > 0){
                    dollar5--;
                } else {
                    return false;
                }
            }
            else {
                if(dollar5 > 0 && dollar10 > 0){
                    dollar5--;
                    dollar10--;
                }
                else if(dollar5 >= 3){
                    dollar5 -= 3;
                }
                else {
                    return false;
                }
            }
        } 

        return true;
    }
}