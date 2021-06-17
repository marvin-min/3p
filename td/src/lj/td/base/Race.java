package lj.td.base;

public class Race implements Runnable{

    private static String winner;
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if(isGameOver(i)){
                break;
            }
            try {
                if(Thread.currentThread().getName().equals("乌龟") && i % 9 == 0)
                Thread.sleep(i%9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "🏃了"+i+"步");
        }
    }

    private boolean isGameOver(int steps){
        if(winner != null) {
            return true;
        }
        if(steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }
}
