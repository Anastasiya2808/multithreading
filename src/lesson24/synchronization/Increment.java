package lesson24.synchronization;

public class Increment extends Thread {
    private SomeAccount account;

    public Increment (SomeAccount account){
        this.account = account;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        //lesson24.synchronization блок - блокирует монитор объекта из (),
        // в данном случае account
        // операции не связанные с изменением свойств объекта из ()
        // в данном случае account
        synchronized (account){
            // операции на 5 минут
            account.upBalance(10);
        }

    }
}

