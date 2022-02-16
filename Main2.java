public class Main2 {
    public static void main(String[] args) {
        Main retry = new Main(6, 200, 4);
        boolean answered = false;
        int iteration = 0;
        for(int i = 0; i < retry.attempt; i++) {
            if (Main.answer() == false) {
                System.out.println("Сервер не ответил");
                iteration += 1;
            }
            if (Main.answer() == true) {
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