package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    public void run() {
        State state = thread.getState();
        State termin = State.TERMINATED;
        System.out.println(state);
        while (true) {
            State newState;
            if (state != (newState = thread.getState())) {
                System.out.println(newState);
                state = newState;
            } else if (newState == termin) return;
        }

//        State newState;
//        do {
//            if ((newState = thread.getState()) != currentState) {
//                currentState = newState;
//                System.out.println(newState);
//            }
//        } while (!currentState.equals(State.TERMINATED));
    }

}
