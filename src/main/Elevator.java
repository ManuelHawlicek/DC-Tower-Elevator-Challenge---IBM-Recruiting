package main;

public class Elevator {

    private int elevatorNumber;
    private int currentFloor;
    private int targetFloor;
    private Request lastRequest;
    private boolean isAvailable;

    public Elevator(int elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
        currentFloor = 0;
    }

    public void setCurrentFloor() {
        this.currentFloor = lastRequest.getRequestToFloor();
    }

    public void setTargetFloor(int targetFloor) throws ElevatorException {
        if (targetFloor < 0 || targetFloor >= 55) {
            throw new ElevatorException("Not a valid destination floor");
        } else {
            this.targetFloor = lastRequest.getRequestToFloor();
        }
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getTargetFloor() {
        return lastRequest.getRequestToFloor();
    }

    public void setLastRequest(Request request) {
        if (request != null) {
            this.lastRequest = request;
            targetFloor = lastRequest.getRequestToFloor();
            currentFloor = lastRequest.getRequestFromFloor();
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isUsed) {
        this.isAvailable = isUsed;
    }

    public Request getLastRequest() {
        return lastRequest;
    }

    public int calculateDelay() {
        return Math.abs(lastRequest.getRequestToFloor() - lastRequest.getRequestFromFloor()) * 500;
    }

    public String isGoingUp() {
        return currentFloor > targetFloor ? "down" : "up";
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "elevatorID=" + elevatorNumber +
                ", currentFloor=" + currentFloor +
                ", goingTo=" + targetFloor +
                ", currentRequest=" + lastRequest +
                '}';
    }
}
