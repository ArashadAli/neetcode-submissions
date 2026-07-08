class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double[][] cars = new double[len][2];
        //In cars 2-d array we store the position of the car and also the time that is taken while covering the destination

        for(int i = 0; i < len; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        //sort the cars based upon the starting point because it matter in this problem

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int carFleet = 0;
        double prevTime = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(cars[i][1] > prevTime) {
            carFleet++;
            prevTime = cars[i][1];
            }
        }
        return carFleet;
    }
}