public class N1114_PrintInOrder {


}

//執行續要依照順序執行,如果先呼叫second 得要先等待確定first已經執行完畢才能做
//同步鎖, 如果還輪不到後面的 就等待, 直到前面的notifyAll
class Foo{
    boolean isFirst = true;
    boolean isSecond = true;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(this){
            printFirst.run();
            isFirst = false;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(this){
            while(isFirst){
                this.wait();
            }
            printSecond.run();
            isSecond = false;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(this){
            while(isFirst || isSecond){
                this.wait();
            }
            printThird.run();
            this.notifyAll();
        }
    }
}
