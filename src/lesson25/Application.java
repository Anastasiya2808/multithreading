package lesson25;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {
    public static void main(String[] args) {
        // потокобезопасные коллекции, мапы
        // Vector, HashTable, Stack

        // создание потокобезопасных коллекций, мап
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        Set<String> synchronizedSet = Collections.synchronizedSet(set);
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        strings = new LinkedBlockingQueue<>(30);

        ArrayBlockingQueue<Message> messages =
                new ArrayBlockingQueue<>(30);
        messages = new ArrayBlockingQueue<>(30);

//        new Thread(new WriteThread(messages)).start();
//        new Thread(new WriteThread(messages)).start();
//        new Thread(new WriteThread(messages)).start();
//        new Thread(new ReadThread(messages)).start();

        // блокирующая очередь DelayQueue:
        // 1. класс, экземпляры которого помещаются в очередь
        // должен имплементировать интерфейс Delayed
        // 2. take блокирует поток, если данных в очереди нет
        // или если элемент нельзя извлечь из очереди
        DelayQueue<Task> tasks = new DelayQueue<>();
        // метод put вызывает метод compareTo объекта task,
        // чтобы разместить элементы в отсортированном порядке
        tasks.put(new Task(()->{
            System.out.println("old task");
        }, LocalDateTime.now().minusDays(1)));

        tasks.put(new Task(()->{
            System.out.println("future task");
        }, LocalDateTime.now().plusMinutes(3)));

        tasks.put(new Task(()->{
            System.out.println("now task");
        }, LocalDateTime.now().plusSeconds(20)));

        while (true) {
            try { // метод take вызывает метод getDelay объекта Task,
                // и если метод вернет положительное число,
                // то поток (в данном случае main) блокируется
                Runnable runnable = tasks.take().getAction();
                new Thread(runnable).start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
