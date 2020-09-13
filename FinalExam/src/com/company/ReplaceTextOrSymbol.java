package com.company;

import java.util.Scanner;

public class ReplaceTextOrSymbol {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        //Ако се търси заместване на един чар, може със String
        // Ако се търси заместване на поредица/дума ползвам StringBuilder и while цикъл


            // With char and temporary String in the end add to Builder and replace
//        case "Translate": {
//            char symbol = tokens[1].charAt(0);
//            char replacement = tokens[2].charAt(0);
//            String changeToString = transformText.toString();
//            int indexSymbol = changeToString.indexOf(symbol);
//            if (indexSymbol < 0) {
//                break;
//            }
//
//            changeToString = changeToString.replace(symbol, replacement);
//            transformText.setLength(0);
//            transformText.append(changeToString);
//            System.out.println(transformText);
//        }
//        break;



        //
        //With StringBuilder, Strings and While
//        case "Change":
//        String current = tokens[1];
//        String replacement = tokens[2];
//        int index = changeString.indexOf(current);
//        if(index <0){
//            break;
//        }
//        while(index > -1){
//            changeString.setCharAt(index,replacement.charAt(0)); //ЗАМЕСТВА И ЧАР В СЛУЧАЯ, НО МОЖЕ ДА Е ПОРЕДИЦА
//            index = changeString.indexOf(current);
//        }
//        System.out.println(changeString);
//        break;




    }
}
