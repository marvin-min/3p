package lj.td.pc;

public class FoodBox {
    Integer[] box = new Integer[10];

    int count = 0;

    public synchronized void push(Integer i){
        if(count == box.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        box[count] = i;
        count++;
        this.notifyAll();
    }

    public synchronized Integer pop() {
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Integer which = box[count];
        this.notifyAll();
        return which;
    }
}
