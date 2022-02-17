public class ServerThread extends Thread{
    Server clazz;
    boolean isSuccessful = true;

    public ServerThread(Server clazz){
        this.clazz = clazz;
    }
    @Override
    public void run(){
        try {
            clazz.doLogic();
        }catch (Exception e){
            isSuccessful = false;
        }
    }
}

