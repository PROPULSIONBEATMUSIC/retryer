//Класс с методом main должен быть отдельно. Внутри main ты создаёшь экземпляр класса Retry.
//И в конструктор передаёшь экземпляр другого класса, который имплементирует интерфейс Retryable

import java.util.Random;

public class Main implements Retryable {
    int attempt;
    static int delay;
    int wait;

    public Main(int attempt, int delay, int wait){
        this.attempt = attempt;
        this.delay = delay;
        this.wait = wait;
    }

    public static boolean answer(){
        try
        {
            Thread.sleep(Main.delay);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        Random rd = new Random();
        return rd.nextBoolean();
    }

}