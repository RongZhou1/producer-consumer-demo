package chapter4.section2;

public class Producer extends Thread {
    private SynchronizedBuffer sharedBuffer;

    public Producer(SynchronizedBuffer sharedBuffer) {
        super("生产线程");
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        for (int count = 0; count <= 4; count++) {
            try {
                Thread.sleep((int) (Math.random() * 2000));
                sharedBuffer.set(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
