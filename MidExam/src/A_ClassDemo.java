public class A_ClassDemo {
    public static void main(String[] args) {

        //Обхождане на масив неопределен брой пъти до определен елемент
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        int[] numbersTwo = new int[]{1, 2, 3, 4, 5};

        System.out.println(5 % 6);

        int num1 = 0;
        int num3 = 0 % 3;
        System.out.println("asdasdasdasd" + num3);
        for (int i = 0; i < 8; i++) {
            num1 =  i % numbersTwo.length ;

        }
        System.out.println(num1);// index found за дължина 8;

        for (int i = numbersTwo.length -1 ; i >= 0 ; i--) {
            num1 =  i % numbersTwo.length ;
        }
        System.out.println(num1);


        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        int index = 0;
        for (int i = 0; i < 7 ; i++) {
            if(i==arr.length){
                index =  0 ;
            }
           // System.out.println(arr[index]);
            index++;

        }





    }
}
