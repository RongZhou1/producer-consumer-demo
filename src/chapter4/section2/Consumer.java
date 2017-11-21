package chapter4.section2;

public class Consumer extends Thread {
    private SynchronizedBuffer sharedBuffer;

    public Consumer(SynchronizedBuffer sharedBuffer) {
        super("消费线程");
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int count = 0; count <= 4; count++) {
            try {
                Thread.sleep((int) Math.random() * 2000);
                sum += sharedBuffer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "消费的整数和：" + sum);
    }
}
