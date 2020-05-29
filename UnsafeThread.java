package lesson3;

//有一个共享变量，初始0，启动20个线程，每个过程循环10000次，每次循环共享变量++
public class UnsafeThread {

    private static int SUM;

    public static void increment(int n){
        SUM++;
    }

    public static void main(String[] args) {
        for(int i=0 ; i<20 ;i++){
            new Thread(()->{
                for(int j=0 ; j<10000 ; j++){
                    increment(j);
                }
            }).start();
        }
        //所以子线程执行完毕后，打印SUM值
        while(Thread.activeCount() > 1){//idea使用Debug运行，使用Run运行改为2
            Thread.yield();//当前线程由运行态转为就绪态
        }
        System.out.println(SUM);
    }
}
