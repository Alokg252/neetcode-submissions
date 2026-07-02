class Solution {
    public static record Car(Integer p, Integer s) {}
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        if (n <= 1) return n;

        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        // 1. Sort cars by position in DESCENDING order (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b.p, a.p));

        Stack<Float> stack = new Stack<>();

        for (int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            // 2. Fixed Integer Division with explicit float casting
            float time = (float) (target - car.p) / car.s;
            
            // 3. If stack is not empty, stack.peek() is the fleet leader IN FRONT of us.
            // If our trailing car's time <= fleet leader's time, we will collide and join their fleet.
            // So we skip pushing our time to the stack!
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            
            // If we take MORE time, we can never catch them. We form a brand new fleet.
            stack.push(time);
        }

        return stack.size();
    }
}