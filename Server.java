import java.util.Random;

public class Server implements Retryable{

    public boolean isSuccessful;

    @Override
    public void doLogic() throws Exception {
        Random random = new Random();
        boolean isSuccessful = random.nextBoolean();
        if(!isSuccessful){
            throw new Exception("error");
        }
        System.out.println("waiting...");
        Thread.sleep(8000);
    }
}
