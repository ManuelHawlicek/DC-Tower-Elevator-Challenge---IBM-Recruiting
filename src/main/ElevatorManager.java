package main;

import java.util.concurrent.atomic.AtomicBoolean;

public class ElevatorManager {
    private final ElevatorPool elevatorPool = new ElevatorPool();
    private final RequestPool requestPool = new RequestPool();
    private AtomicBoolean state = new AtomicBoolean(false);

    public ElevatorManager() {

    }


    public AtomicBoolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state.set(state);
    }

    public void start() {
        Thread thread = new Thread(() -> {
            while (state.get()) {
                workRequest();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    public void addRequest(Request request) throws ElevatorException {
        requestPool.add(request);
    }


    private void workRequest() {
        Thread thread = new Thread(() -> {
            if (elevatorPool.hasFreeElevator() && requestPool.hasNextRequest()) {
                Request request = requestPool.getNextRequest();
                Elevator elevator = elevatorPool.getFreeElevator(request);
                System.out.println("Elevator " + elevator.getElevatorNumber()
                        + ": current floor: " + elevator.getCurrentFloor()
                        + ", destination floor: " + elevator.getTargetFloor()
                        + " direction: " + elevator.isGoingUp());

                try {
                    Thread.sleep(elevator.calculateDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                elevator.setCurrentFloor();
                elevatorPool.returnElevator(elevator);
                System.out.println("Elevator " + elevator.getElevatorNumber()
                        + " is now done with request number " + elevator.getLastRequest().getRequestNumber()
                        + " and on floor " + elevator.getCurrentFloor());
            }
        });
        thread.start();
    }
}
