import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        MyPublisher myPublisher = new MyPublisher();
        myPublisher.registerObserver(obj -> System.out.println((String)obj));
        new Thread(myPublisher).start();
    }
}

interface Publisher {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyEvent(Object obj);
}

interface Observer {
    void onEvent(Object obj);
}

class MyPublisher implements Publisher, Runnable {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyEvent(Object obj) {
        observers.stream().forEach(observer -> observer.onEvent(obj));
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            notifyEvent("Observer");
            Thread.sleep(5000);
            notifyEvent("Pattern");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}