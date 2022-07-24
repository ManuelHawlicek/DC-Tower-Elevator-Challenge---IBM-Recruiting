package main;

import java.util.ArrayList;
import java.util.List;

public class RequestPool {
    private final List<Request> requests = new ArrayList<>();

    public RequestPool() {

    }

    public synchronized void add(Request request) throws ElevatorException {
        if (request != null) {
            if (!requests.contains(request)) {
                requests.add(request);
            } else {
                throw new ElevatorException("Request already in work");
            }
        } else {
            throw new ElevatorException("Request not valid");
        }
    }

    public synchronized Request getNextRequest() {
        if (!requests.isEmpty()) {
            Request request = requests.get(0);
            requests.remove(request);
            return request;
        } else {
            return null;
        }
    }

    public synchronized boolean hasNextRequest() {
        return !requests.isEmpty();
    }
}
