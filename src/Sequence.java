/**
 * Program: Pattern Sequence
 * Package: Default
 * Class: Sequence
 * Author: Swapnil Patel
 * Date: 9/25/2017
 */

final class Sequence {

    private static int efficiency = 0;



    static int computeIterative(int n) {

        efficiency = 0;
        int returnValue = 0;

        if (n == 0) {
            efficiency++;
            return 0;
        } else if (n == 1) {
            efficiency++;
            return 1;
        } else {
            int last = 1;
            int secondLast = 0;
            for (int x = 2; x <= n; x++) {
                efficiency++;
                returnValue = ((3 * last) - secondLast);
                secondLast = last;
                last = returnValue;
            }
        }
        return returnValue;
    }

    static int computeRecursive(int n) {
        efficiency = 0;
        return recursiveCalc(n);
    }

    private static int recursiveCalc(int n) {

        if (n == 0) {
            efficiency++;
            return 0;
        } else if (n == 1) {
            efficiency++;
            return 1;
        } else {
            int last = 1;
            int secondLast = 0;
            efficiency++;
            return ((3 * recursiveCalc(n - 1) - recursiveCalc(n - 2)));
        }

    }

    static int getEfficiency(){return efficiency;}

}
