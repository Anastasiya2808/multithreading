package lock;

import static java.lang.Thread.sleep;
import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
//       Класс Exchanger предназначен для обмена данными между потоками.Он является типизированным и типизируется типом
//        данных, которыми потоки должны обмениваться.
//        Обмен данными производится с помощью единственного метода этого класса exchange():
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println("Первый поток получил данные: " + exchanger.exchange("Первый поток"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                sleep(3000);
                System.out.println("Второй поток получил данные: " + exchanger.exchange("Второй поток"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
