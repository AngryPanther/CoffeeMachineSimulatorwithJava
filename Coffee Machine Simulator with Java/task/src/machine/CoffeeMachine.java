package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int availableWater = 400;
    static int availableMilk = 540;
    static int availableCoffeeBeans = 120;
    static int availableMoney = 550;
    static int availableCups = 9;
    static int fillWater;
    static int fillMilk;
    static int fillCoffeeBeans;
    static int fillCups;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = scanner.next();
            switch (input) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String action = scanner.next();
                    if (action.equals("back")) {
                        break;
                    } else {
                    switch (action) {
                        case "1":
                            createEspresso(1);
                            break;
                        case "2":
                            createLatte(1);
                            break;
                        case "3":
                            createCappuccino(1);
                            break;
                    }
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    fillWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    fillMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    fillCoffeeBeans = scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    fillCups = scanner.nextInt();
                    restockMachine();
                    break;
                case "take":
                    System.out.printf("I gave you $%d", availableMoney);
                    availableMoney = 0;
                    break;
                case "remaining":
                    printStats(availableWater,availableMilk,
                            availableCoffeeBeans,availableCups,availableMoney);
                    break;
            }
            System.out.println();
        }
    }

    // Prints available supplies in coffee machine
    private static void printStats(int availableWater, int availableMilk, int availableCoffeeBeans, int availableCups, int availableMoney) {
        System.out.printf("The coffee machine has:%n" +
                    "%d ml of water%n" +
                    "%d ml of milk%n" +
                    "%d g of coffee beans%n" +
                    "%d disposable cups%n" +
                    "$%d of money%n", availableWater, availableMilk,
            availableCoffeeBeans, availableCups, availableMoney);
    }

    // Method that creates an Espresso
    private static void createEspresso(int numberOfCoffee) {
        for (int i = 0; i < numberOfCoffee; i++) {
                if (availableWater >= 250 && availableCoffeeBeans >= 16) {
                    System.out.println("I have enough resources, making you a coffee!");
                    --numberOfCoffee;
                    availableWater-= 250;
                    availableCoffeeBeans-= 16;
                    availableMoney += 4;
                    --availableCups;
                } else if (availableWater < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (availableCoffeeBeans < 15) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (availableCups == 0) {
                    System.out.println("Sorry, not enough cups!");
                }
            }
        }

    // Method that creates a Latte
    private static void createLatte(int numberOfCoffee) {
        for (int i = 0; i < numberOfCoffee; i++) {
            if (availableWater >= 350 && availableMilk >= 75 && availableCoffeeBeans >= 20) {
                System.out.println("I have enough resources, making you a coffee!");
                --numberOfCoffee;
                availableWater-= 350;
                availableMilk -= 75;
                availableCoffeeBeans-= 20;
                availableMoney += 7;
                --availableCups;
            } else if (availableWater < 350) {
                System.out.println("Sorry, not enough water!");
            } else if (availableMilk < 75) {
                System.out.println("Sorry, not enough milk!");
            } else if (availableCoffeeBeans < 19) {
                    System.out.println("Sorry, not enough coffee beans!");
            } else if (availableCups == 0) {
                    System.out.println("Sorry, not enough cups!");
                }
            }
        }
    // Method that creates a Cappuccino
    private static void createCappuccino(int numberOfCoffee) {
        for (int i = 0; i < numberOfCoffee; i++) {
            if (availableWater >= 200 && availableMilk >= 100 && availableCoffeeBeans >= 12) {
                System.out.println("I have enough resources, making you a coffee!");
                --numberOfCoffee;
                availableWater-= 200;
                availableMilk -= 100;
                availableCoffeeBeans-= 12;
                availableMoney += 6;
                --availableCups;
            } else if (availableWater < 200) {
                System.out.println("Sorry, not enough water!");
            } else if (availableMilk < 100) {
                System.out.println("Sorry, not enough milk!");
            } else if (availableCoffeeBeans < 11) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (availableCups == 0) {
                System.out.println("Sorry, not enough cups!");
            }
        }
    }
    // Method that fills the supplies in the coffee machine
    private static void restockMachine() {
        availableWater += fillWater;
        availableMilk += fillMilk;
        availableCoffeeBeans += fillCoffeeBeans;
        availableCups += fillCups;
    }
}

