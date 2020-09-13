//package com.company;
//
//import java.util.*;
//
//public class battlemanager {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        Map<String, List<Integer>> records = new HashMap<>();
//
//        String input = scan.nextLine();
//        while (!"Results".equals(input)) {
//            String[] tokens = input.split(":");
//            String command = tokens[0].trim();
//            String username = tokens[1].trim();
//            switch (command) {
//
//                case "Add":
//                    int health = Integer.parseInt(tokens[2]);
//                    if (records.containsKey(username)) {
//                        int currentHealth = records.get(username).get(0);
//                        int updateHealth = health + currentHealth;
//                        records.get(username).set(0, updateHealth);
//                    } else {
//                        int energy = Integer.parseInt(tokens[3]);
//                        records.put(username, new ArrayList<>());
//                        records.get(username).add(0, health);
//                        records.get(username).add(1, energy);
//                    }
//                    break;
//                case "Attack":
//                    String defender = tokens[2];
//                    int damage = Integer.parseInt(tokens[3].trim());
//
//                    if (records.containsKey(username) && records.containsKey(defender)) {
//                        //defender
//                        int defenderCurrHealth = records.get(defender).get(0);
//                        int afterHealth = defenderCurrHealth - damage;
//
//                        if (afterHealth <= 0) {
//                            records.remove(defender);
//                            System.out.printf("%s was disqualified!\n", defender);
//                        } else {
//                            records.get(defender).set(0, afterHealth);
//                        }
//                        //attacker reduce energy
//                        int attackerCurrEnergy = records.get(username).get(1);
//                        int afterEnergy = attackerCurrEnergy - 1;
//                        // TODO: 21/03/2020   if it reaches 0, only ?
//                        if (afterEnergy <= 0) {
//                            records.remove(username);
//                            System.out.printf("%s was disqualified!\n", username);
//                        } else {
//                            records.get(username).set(1, afterEnergy);
//                        }
//                    }
//                    break;
//                case "Delete":
//                    if (username.equals("All")) {
//                        records.clear();
//                      for (String user : records.keySet()) {
//////                          records.get(user).remove(0); махам стойности по index
//////                          records.get(user).remove(0);
////                      }
//                    } else {
////                      records.get(username).remove(0);
////                      records.get(username).remove(0);
//                        records.remove(username);
//                    }
//                    break;
//            }
//            input = scan.nextLine();
//        }
//        System.out.println("People count: " + records.keySet().size());
//
//        records.entrySet().stream()
//                .sorted((a, b) -> {
//                    int h1 = a.getValue().get(0);
//                    int h2 = b.getValue().get(0);
//                    int comp = h2 - h1;
//                    if (comp == 0) {
//                        comp = a.getKey().compareTo(b.getKey());
//                    }
//                    return comp;
//                })
//                .forEach(a -> {
//                    System.out.print(a.getKey() + " - ");
//                    System.out.printf("%d - %d%n", a.getValue().get(0), a.getValue().get(1));
//                });
//
//    }
//}
