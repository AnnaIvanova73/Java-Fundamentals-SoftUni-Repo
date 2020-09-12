package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int numbers = Integer.parseInt(scan.nextLine());
        int[] arr = new int[numbers];



        for (int i = 0; i <arr.length ; i++) {
            arr[i]=scan.nextInt();
        }
        int[] arr2 = arr;

        arr= new int[]{1,2,3};


        for (int num:arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num:arr) {
            System.out.print(num + " ");
        }
    }
}
