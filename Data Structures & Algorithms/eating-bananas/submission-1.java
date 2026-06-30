class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;

            if (canEat(mid, piles, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    boolean canEat(int speed, int[] piles, int h) {
        int hrs = 0;

        for (int pile : piles) {
            hrs += (pile + speed - 1) / speed;
            if (hrs > h) return false;
        }

        return true;
    }
}