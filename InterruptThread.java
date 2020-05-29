package lesson3;

public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {
        //第一段代码：在子线程阻sleep断时中断它
//        Thread t = new Thread(()->{
//            try {
//                while(!Thread.interrupted()){//判断当前线程是否中断--->判断中断标志位
//                    System.out.println(Thread.currentThread().getName());
//                        //sleep线程阻塞也能中断，是以抛出InterruptedException异常来中断
//                        Thread.sleep(1000000000);
//                    }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//            });
//            t.start();
//            Thread.sleep(3000);
//            //特殊情况出现，中断线程
//            t.interrupt();

        //第二段代码；
        //（1）线程初始时，zhd标志位false；
        //（2）调用线程的interrupt（）方法，使中断标志位 = true；
        //（3）如果线程处于阻塞态，中断抛出异常时会重置中断标志位
//        Thread t = new Thread(()->{//isInterrupted = false；
//            while(!Thread.interrupted()){
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    //线程阻塞时，抛出异常中断，isInterrupted = false;
//                    e.printStackTrace();
//                }
//            }
//        });
//        t.start();
//        Thread.sleep(3000);
//        //特殊情况出现，中断线程
//        t.interrupt();//t.isInterrupted = true；


//        //第三段代码：Thread.interrupted（）作用
//        Thread t = new Thread(()->{//t.isInterrupted = true;
//           for(int i=0 ; i<10 ; i++){
//               //Thread.interrupted();返回当前中断标志位，并重置标志位
//               System.out.println(Thread.interrupted());
//           }
//        });
//        t.start();//t.isInterrupted = false;
//        //特殊情况出现，中断线程
//        t.interrupt();//t.isInterrupted = true；

        //第四段代码：线程对象isInterrupted()作用，只返回中断标志位，不重置中断标志位
        Thread t = new Thread(()->{//t.isInterrupted = true;
            for(int i=0 ; i<10 ; i++){
                //Thread.interrupted();返回当前中断标志位，并重置标志位
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();//t.isInterrupted = false;
        //特殊情况出现，中断线程
        t.interrupt();//t.isInterrupted = true；
    }
}
