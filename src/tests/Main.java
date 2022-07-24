package tests;

import main.ElevatorException;
import main.ElevatorManager;
import main.Request;

public class Main {

    public static void main(String[] args) {
        ElevatorManager elevatorManager = new ElevatorManager();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            elevatorManager.setState(false);
            System.out.println("Application terminated successfully.");
        }));

        elevatorManager.setState(true);
        elevatorManager.start();

        try {

            elevatorManager.addRequest(new Request(1,2, 10));
            elevatorManager.addRequest(new Request(2,3, 31));
            elevatorManager.addRequest(new Request(3, 5, 7));
            elevatorManager.addRequest(new Request(4, 7, 12));
            elevatorManager.addRequest(new Request(5,31, 2));
            elevatorManager.addRequest(new Request(6, 27, 5));
            elevatorManager.addRequest(new Request(7, 2, 52));
            elevatorManager.addRequest(new Request(8, 47, 32));
            elevatorManager.addRequest(new Request(9, 1, 9));
            elevatorManager.addRequest(new Request(10, 3, 51));
            elevatorManager.addRequest(new Request(11, 7, 12));
            elevatorManager.addRequest(new Request(12, 12, 10));
            elevatorManager.addRequest(new Request(13, 35, 0));
            elevatorManager.addRequest(new Request(14, 27, 2));
            elevatorManager.addRequest(new Request(15, 5, 55));
            elevatorManager.addRequest(new Request(16, 55, 32));
            elevatorManager.addRequest(new Request(17, 2, 8));
            elevatorManager.addRequest(new Request(18, 4, 32));
            elevatorManager.addRequest(new Request(19, 6, 7));
            elevatorManager.addRequest(new Request(20, 9, 2));
            elevatorManager.addRequest(new Request(21, 41, 0));
            elevatorManager.addRequest(new Request(22, 33, 2));
            elevatorManager.addRequest(new Request(23, 2, 55));
            elevatorManager.addRequest(new Request(24, 49, 25));
            elevatorManager.addRequest(new Request(25, 1, 55));


        } catch (ElevatorException e) {
            System.out.println(e.getMessage());
        }

    }
}
