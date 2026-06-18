class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12; // Because for time like 12:15 the hourh = 367.5, but should be 7.5
        double minh = minutes*(360/60);
        double hourh = hour*(360/12)+minutes*(0.5);
        double angle = Math.abs(hourh - minh);
        double angle2 = Math.abs(360-angle);
        return Math.min(angle,angle2);
    }
}