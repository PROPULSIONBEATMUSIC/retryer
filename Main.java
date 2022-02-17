//Класс с методом main должен быть отдельно. Внутри main ты создаёшь экземпляр класса Retry.
//И в конструктор передаёшь экземпляр другого класса, который имплементирует интерфейс Retryable

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Retry<>(new Server() ,5, 5000);
    }
}