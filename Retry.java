public class Retry<T extends Retryable> {
    T clazz;
    int attempts;
    int wait;
    int maxAttempts;

    public Retry(T clazz, int maxAttempts, int wait) throws InterruptedException {
        this.clazz = clazz;
        this.wait = wait;
        this.maxAttempts = maxAttempts;
        ServerThread serv;
        while (true){
            if (attempts<=maxAttempts){
                int i = 0;
                serv = new ServerThread((Server) this.clazz);
                serv.start();
                while (i < wait){
                    if(!serv.isAlive()){
                        break;
                    }
                    Thread.sleep(wait/100);
                    i += wait / 100;
                }
                if(!serv.isSuccessful){
                    attempts++;
                    System.out.println("Retry(ERROR)");
                    serv.interrupt();
                }
                if(serv.isAlive()){
                    System.out.println("Retry(TimeOut)");
                    attempts++;
                    serv.interrupt();
                }
                System.out.println("Success!");
            } else {
                System.out.println("Out of attempts!");
            }
        }
    }
}