package lj.td.base;

public class SaleTicketDemo{

    public static void main(String[] args) {
        Buyticket saleTicketDemo = new Buyticket();
        new Thread(saleTicketDemo,"Marvin").start();
        new Thread(saleTicketDemo,"Jim").start();
        new Thread(saleTicketDemo,"others").start();
        new Thread(saleTicketDemo,"ddd").start();
        new Thread(saleTicketDemo,"333").start();
        new Thread(saleTicketDemo,"eee").start();
        new Thread(saleTicketDemo,"aaa").start();
        new Thread(saleTicketDemo,"ffff").start();
    }
}


class Buyticket implements Runnable {
    private int ticketNums = 2000;
    boolean flag = true;
    @Override
    public  void run() {
        while (flag) {
            try {
               buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void buy () throws InterruptedException {
        if(ticketNums <= 0 ){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+" ---> get ticket" + ticketNums-- +";");
    }
}
