/*
let :-
a = 1010 = 10
b = 0010 = 2

carry = 0100
a = 1000

carry = 0000
a = 1100 = 12


- a & b gives carry and it should be added in next bit so <<1

1. simple logic get carry by (a&b) shift to next bit by <<1
2. add simply without carry = a^b
3. add carry until get new carry if its not zero add again and repeat
4. repeat until carry is non zero 
5. return the result
*/

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
