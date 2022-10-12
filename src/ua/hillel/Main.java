package ua.hillel;

import ua.hillel.coffee.order.CoffeeOrderBoard;

import java.util.Random;

public class Main {
    private final static String[] NAMES = {"George", "John", "Thomas", "James", "Abraham", "Andrew", "Ulysses",
            "Martin", "William", "Chester", "Grover", "Benjamin", "Zachary", "Grover", "Millard", "Franklin",
            "Theodore", "Lyndon", "Woodrow", "Richard", "Warren", "Gerald", "Calvin", "Herbert", "Ronald",
            "George", "Harry", "Dwight", "Barack", "Donald", "Joe"};

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        Random random = new Random();

        for (int i = 0; i < NAMES.length; i++) {
            int randomInt = random.nextInt(NAMES.length);
            coffeeOrderBoard.add(NAMES[randomInt]);
        }

        for (int i = 0; i < 10; i++) {
            coffeeOrderBoard.deliver();
            int randomInt = random.nextInt(NAMES.length);
            coffeeOrderBoard.deliver(randomInt);
        }

        coffeeOrderBoard.draw();
    }
}