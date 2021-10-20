class PingPong implements Runnable {
    final Object obj;

    public PingPong(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            while (true) {
                    System.out.println(Thread.currentThread().getName());
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}


public class Practice1 {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread thread1 = new Thread(new PingPong(obj),"ping");
        Thread thread2 = new Thread(new PingPong(obj),"pong");
        thread1.start();
        thread2.start();
    }
}
