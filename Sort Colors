class Solution {
    public void sortColors(int[] nums) {
     byte zeroFreq=0;
     byte oneFreq =0;
     byte twoFreq = 0;
     for (int i:nums) {
         if (i==0) {zeroFreq++;}
         else if (i==1) {oneFreq++;}
         else if (i==2) {twoFreq++;}
     }
     for (int i = 0; i < zeroFreq; i++) {
         nums[i] = 0;

     }
     for (int i = zeroFreq; i < oneFreq + zeroFreq; i++) {
         nums[i] = 1;
     }
     for (int i = oneFreq + zeroFreq; i < twoFreq + zeroFreq + oneFreq; i++) {
         nums[i] = 2;
     }
 }
}
