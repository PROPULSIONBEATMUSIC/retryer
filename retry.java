import java.util.Random;

public class retry implements Retryable {
    int attempt;
    static int delay;
    int wait;

    public retry(int attempt, int delay, int wait){
        this.attempt = attempt;
        this.delay = delay;
        this.wait = wait;
    }

    public static boolean answer(){
        try
        {
            Thread.sleep(retry.delay);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public static void main(String[] args) {
        retry retry = new retry(6, 1000, 4);
        boolean answered = false;
        int iteration = 0;
        for(int i = 0; i < retry.attempt; i++) {
            if (answer() == false) {
                System.out.println("Сервер не ответил");
                iteration += 1;
            }
            if (answer() == true) {
                System.out.println("Сервер ответил");
                answered = true;
                break;
            }
            if (iteration >= retry.attempt-1) {
                System.out.println("Количество попыток истекло!");
                break;
            }
        }
        retry.answer();
    }
}