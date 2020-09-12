import java.util.Scanner;

public class ArrayManipulatorTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] myNumbers = convertMyArrToNumbers(input);
        int length = myNumbers.length;

        String commands = scan.nextLine();
        while (!"end".equals(commands)) {
            String command = takeLetters(commands);

            String resultMaxMinIndex = "";

            switch (command) {
                case "exchange":
                    int index = checkForNumbersInInput(commands);

                    if (index >= 0 && index < myNumbers.length) {
                        myNumbers = exchangeArray(index, myNumbers);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "maxeven":
                    resultMaxMinIndex = findMaxEven(myNumbers);
                    System.out.println(resultMaxMinIndex);
                    break;
                case "maxodd":
                    resultMaxMinIndex = findOddMax(myNumbers);
                    System.out.println(resultMaxMinIndex);
                    break;
                case "mineven":
                    resultMaxMinIndex = findMinEvenElement(myNumbers);
                    System.out.println(resultMaxMinIndex);
                    break;
                case "minodd":
                    resultMaxMinIndex = findMinOddElement(myNumbers);
                    System.out.println(resultMaxMinIndex);
                    break;
                case "firsteven":
                    int firstEven = checkForNumbersInInput(commands);
                    if (firstEven >= 0 && firstEven <= myNumbers.length) {
                        int[] odd = giveFirstEven(firstEven, myNumbers);
                        printMyArea(odd);
                    } else {
                        System.out.println("Invalid count");
                    }

                    break;
                case "firstodd":
                    int firstOdd = checkForNumbersInInput(commands);
                    if (firstOdd > 0 && firstOdd < myNumbers.length) {
                        int[] odd = giveFirstOdd(firstOdd, myNumbers);
                        printMyArea(odd);
                    } else {
                        System.out.println("Invalid count");
                    }

                    break;
                case "lasteven":
                    int lastEven = checkForNumbersInInput(commands);
                    if (lastEven > 0 && lastEven < myNumbers.length) {
                        int[] array = giveLastEven(lastEven, myNumbers);
                        printMyArea(array);

                    }else {
                        System.out.println("Invalid count");

                    }
                    break;

                case "lastodd":
                    int lastOdd = checkForNumbersInInput(commands);
                    if (lastOdd > 0 && lastOdd <= myNumbers.length){
                        int[] array = giveLastOdd(lastOdd,myNumbers);
                        printMyArea(array);

                    }else {
                        System.out.println("Invalid count");
                    }
                    break;
            }

            commands = scan.nextLine();
        }

        printMyArea(myNumbers);
    }

    private static int [] giveLastEven(int num, int [] array){
        int[] arr = new int [num];
       // int[] currentArr ;
        int number = 0;
        int count = 0;
        int currentCount = 0;
       int index = 0;

        for (int i = array.length - 1; i >= 0 ; i--) {
            number = array[i];
            if (isEvenIsOdd(number)) {
                // if проверка
                count+=1;
                arr = new int[count];
                if (count == num){
                    break;
                }
            }

        }

        return arr;
    }
    private static int [] giveLastOdd (int num, int [] array){
        int[] arr = new int [num];

        int number = 0;
        int count = 0;
        int currentCount = 0;
        for (int i = array.length - 1; i >= 0 ; i--) {
            number = array[i];
            if (!isEvenIsOdd(number)) {
                // if проверка
                count+=1;
                currentCount+=1;
                arr = new int[count];
                arr[currentCount] += number;
                if (count == num){
                    return arr;
                }
            }

        }

            return arr;
    }
    private static int[] giveFirstEven(int num, int[] array) {
        int number = 0;
        int count = 0;
        int[] arrFirstEven = new int[num];
        for (int i = 0; i < array.length; i++) {
            number=array[i];
            if (isEvenIsOdd(number)) {
                if ( count == number){
                    break;
                }
                arrFirstEven[i] += number;
                count+=1;
            }

        }
        int [] arr = new int[count];
        for (int i = 0; i < arrFirstEven.length; i++) {
            int digit = arrFirstEven[i];
            if ( digit != 0) {
                int numb = arrFirstEven[i];
                arr[i] += numb;
                return arr;
            }
        }
        return arrFirstEven;
    }

    private static int[] giveFirstOdd(int num, int[] array) {
        int[] arrFirstOdd = new int[num];
        int number = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
                number=array[i];
            if (!isEvenIsOdd(number)) {
                arrFirstOdd[count] += number;
                count+=1;
            }
            if ( count == num){
                break;
            }
        }
        return arrFirstOdd;
    }
    private static String findMinOddElement(int[] arr) {
        String minOdd = "";
        int minIndex = arr.length - 1;
        int minNum = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!isEvenIsOdd(arr[i])) {
                if (minNum >= arr[i]) {
                    minNum = arr[i];
                    minIndex = i;
                    count++;
                }
            }
        }
        if (count != 0) {
            return minOdd = String.valueOf(minIndex);
        } else {
            return minOdd = "No matches";
        }
    }

    private static String findMinEvenElement(int[] arr) {
        String minEvenElement = "";
        int minIndex = arr.length - 1;
        int minNum = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isEvenIsOdd(arr[i])) {
                if (minNum >= arr[i]) {
                    minNum = arr[i];
                    minIndex = i;
                    count++;
                }
            }
        }
        if (count != 0) {
            return minEvenElement = String.valueOf(minIndex);
        } else {
            return minEvenElement = "No matches";
        }
    }

    private static String findOddMax(int[] arr) {
        String maxOddElement = "";
        int maxIndex = -1;
        int maxNum = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!isEvenIsOdd(arr[i])) {
                if (maxNum <= arr[i]) {
                    maxNum = arr[i];
                    maxIndex = i;
                    count++;
                }
            }
        }
        if (count > 0) {
            return maxOddElement = String.valueOf(maxIndex);
        } else {
            return maxOddElement = "No matches";
        }
    }

    private static String findMaxEven(int[] arr) {
        String maxEvenElement = "";
        int maxIndex = -1;
        int maxNum = -1;
        for (int i = 0; i < arr.length; i++) {
            if (isEvenIsOdd(arr[i])) {
                if (maxNum <= arr[i]) {
                    maxNum = arr[i];
                    maxIndex = i;
                }
            }
        }
        if (isEvenIsOdd(maxNum)) {
            return maxEvenElement = String.valueOf(maxIndex);
        } else {
            return maxEvenElement = "No matches";
        }
    }


    private static boolean isEvenIsOdd(int i) {
        if (i % 2 == 0) {
            return true;
        }
        return false;
    }


    private static void printMyArea(int[] array) {
        // boolean isEmpty = false;
        int count = 0;
        for (int num : array) {
            if (num == 0) {
                count++;
            } else {
                count = 0;
            }
        }
        if (count == array.length) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                int num = array[i];

                if (num == array[array.length - 1]) {
                    System.out.print(num + "]");
                    System.out.println();
                } else {
                    System.out.print(num + "," + " ");
                }
            }
        }

// Arrays.toString array
    }

    private static int[] exchangeArray(int a, int[] copiedArray) {

        int[] exchangedArray = new int[copiedArray.length];
        int count = 0;
        for (int i = a + 1; i < copiedArray.length; i++) {

            exchangedArray[count] = copiedArray[i];
            count += 1;
        }

        int countSecond = 0;
        for (int i = count; i < copiedArray.length; i++) {
            exchangedArray[i] = copiedArray[countSecond];
            countSecond++;
        }
        return exchangedArray;
    }

    private static String takeLetters(String commands) {
        commands = commands.replaceAll("[^a-zA-Z]", "");
        String command = commands;
        return commands;
    }

    private static int checkForNumbersInInput(String commands) {
        String toNum = commands.replaceAll("\\D", "");
        int myNum = Integer.parseInt(toNum);
        return myNum;
    }

    private static int[] convertMyArrToNumbers(String arr) {
        String[] inputChars = arr.split("\\s+");
        int[] numbersNeededArr = new int[inputChars.length];
        for (int i = 0; i < inputChars.length; i++) {
            numbersNeededArr[i] = Integer.parseInt(inputChars[i]);
        }
        return numbersNeededArr;
    }
}


