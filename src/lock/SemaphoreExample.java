package lock;

import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        /* Для управления доступом к ресурсу семафор использует счетчик, представляющий количество разрешений.
           Если значение счетчика больше нуля, то поток получает доступ к ресурсу, при этом счетчик уменьшается на
           единицу. После окончания работы с ресурсом поток освобождает семафор, и счетчик увеличивается на единицу. Если же
           счетчик равен нулю, то поток блокируется и ждет, пока не получит разрешение от семафора.*/

        // Semaphore(int permits)
        // Semaphore(int permits, boolean fair)
        // void acquire() throws InterruptedException
        // void acquire(int permits) throws InterruptedВxception
        // void release()
        // void release(int permits)

        Semaphore sem = new Semaphore(1, true); // 1 разрешение
        HashSet<String> commonSet = new HashSet<>();
        Runnable runnable = ()->{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " ожидает разрешение");
            try {
                sem.acquire();
                Thread.sleep(3000);
                System.out.println(threadName + " разрешение получено");
                commonSet.add(threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(threadName + " освобождает разрешение");
                sem.release();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
