package lesson23;

public class MyThread extends Thread{
    // перечисление всех
    // необходимых свойств, конструкторов и методов
    // в данном классе могут быть любые мотоды и свойства

    // инструкции, описанные в методе run
    // будут выполняться в отдельном потоке

    @Override
    public void run(){
        System.out.println(this.getName());
        // Thread.currentThread() - ссылка на текуций поток (где ссылка вызывается, там и возвращает основной поток)
        System.out.println(Thread.currentThread().getName());
    }
}
