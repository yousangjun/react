public class Main extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("스레드가 일하고 있어요: " + i);
            try {
                Thread.sleep(1000); // 1초 동안 멈춤
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main thread1 = new Main();
        Main thread2 = new Main();
        
        thread1.start(); // 첫 번째 스레드 시작
        thread2.start(); // 두 번째 스레드 시작
    }
}
