package chapter4.section2;

public class TestProducerComsumer {
    public static void main(String[] args) {
        System.out.println("演示生产者与消费者同步：");
        SynchronizedBuffer sharedBuffer = new SynchronizedBuffer();
        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);
        producer.start();
        consumer.start();

    }
}
