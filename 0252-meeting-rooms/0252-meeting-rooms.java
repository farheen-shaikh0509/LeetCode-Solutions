class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        // Sort meetings by start time

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {

            // Current meeting starts before previous meeting ends

            if (intervals[i][0] < intervals[i - 1][1]) {

                return false;

            }

        }

        return true;

    }
    }
