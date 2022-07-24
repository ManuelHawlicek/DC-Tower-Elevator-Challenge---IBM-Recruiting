package main;

import java.util.UUID;

public class Request {
    private String requestID;
    private int requestFromFloor;
    private int requestToFloor;
    private int requestNumber;

    public Request(int requestNumber, int requestFromFloor, int requestToFloor) throws ElevatorException {
        requestID = UUID.randomUUID().toString();
        this.requestNumber = requestNumber;
        setRequestFromFloor(requestFromFloor);
        setRequestToFloor(requestToFloor);
    }

    public void setRequestFromFloor(int requestFromFloor) throws ElevatorException {
        if ((requestFromFloor < 0) || requestFromFloor > 55) {
            throw new ElevatorException("Invalid floor number");
        } else {
            this.requestFromFloor = requestFromFloor;
        }
    }

    public void setRequestToFloor(int requestToFloor) throws ElevatorException {
        if ((requestToFloor < 0) || requestToFloor > 55) {
            throw new ElevatorException("Invalid floor number");
        } else {
            this.requestToFloor = requestToFloor;
        }
    }

    public int getRequestFromFloor() {
        return requestFromFloor;
    }

    public int getRequestToFloor() {
        return requestToFloor;
    }

    public int getRequestNumber() {
        return requestNumber;
    }


    @Override
    public String toString() {
        return "Request{" +
                "requestID='" + requestID + '\'' +
                ", requestFromFloor=" + requestFromFloor +
                ", requestToFloor=" + requestToFloor +
                '}';
    }
}
