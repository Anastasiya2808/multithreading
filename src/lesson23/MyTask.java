package lesson23;

public class MyTask implements Runnable{
    // перечисление всех
    // необходимых свойств, конструкторов и методов
    // в данном классе могут быть любые мотоды и свойства

    // инструкции, описанные в методе run
    // будут выполняться в отдельном потоке

    @Override
    public void run(){
        // System.out.println(this.getName); - нельзя,тк нет наследования
        System.out.println(Thread.currentThread().getName());
    }
}
