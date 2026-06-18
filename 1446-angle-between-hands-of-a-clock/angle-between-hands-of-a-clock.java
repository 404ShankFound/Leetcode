class Solution {
    public double angleClock(int hour, int minutes) {
        double minh = minutes*(360/60);
        double hourh = hour*(360/12)+minutes*(0.5);
        double angle = Math.max(minh, hourh)-Math.min(minh, hourh);
        double angle2 = Math.abs(360-angle);
        return Math.min(angle,angle2);
    }
}