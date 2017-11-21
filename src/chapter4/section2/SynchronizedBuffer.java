package chapter4.section2;

public class SynchronizedBuffer {
    private int buffer = -1;       //定义缓冲区buffer:保存整型值
    private boolean occupiedBuffer = false;   //标志缓冲区是否已占用

    //该方法设置buffer的值，模拟生产过程
    public synchronized void set(int value) {
        String name = Thread.currentThread().getName();  //得到生产线程的名字
        while (occupiedBuffer){
            try {
                System.err.println(name+"试图生产，但上一次的还没有消费！等待消费！");
                wait(); //生产线程等待，直到消费线程已消费：occupiedBuffer为false
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer=value;//消费唤醒该线程后，可以生产，即设置buffer的值
        System.out.println(name+"生产一个整数："+buffer);
        occupiedBuffer=true;
        notify();
    }

    //该方法得到buffer的值，模拟消费过程
    public synchronized int get(){
        String name = Thread.currentThread().getName();//得到消费线程的名字
        while (!occupiedBuffer){
            try {
                System.err.println(name+"试图消费，但还没有生产！等待生产！");
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(name+"消费一个整数："+buffer);
        occupiedBuffer=false;
        notify();
        return buffer;
    }
}
