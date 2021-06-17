package lj.td.base;

public class SaleTicketDemo implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while (ticketNums>0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" ---> get ticket" + ticketNums-- +";");
        }
    }

    public static void main(String[] args) {
        SaleTicketDemo saleTicketDemo = new SaleTicketDemo();
        new Thread(saleTicketDemo,"Marvin").start();
        new Thread(saleTicketDemo,"Jim").start();
        new Thread(saleTicketDemo,"others").start();
    }
}
