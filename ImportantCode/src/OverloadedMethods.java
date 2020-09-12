public class OverloadedMethods {
    static int getMax(int num1, int num2, int num3, int num4) {
        return getMax(getMax(num1, num2, num3), num4);
//        int num = getMax(num1,num2,num3);
//        int result = getMax(num,num4);
//        return result;
    }
    static int getMax(int num1, int num2, int num3) {
        return getMax(getMax(num1, num2), num3);
//        int num = getMax(num1,num2);
//        int result = getMax(num,num3);
//        return result;
    }
    static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }




}
