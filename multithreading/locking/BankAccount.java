package multithreading.locking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;
    private Lock lock = new ReentrantLock();
    public void withdraw(int withdrawAmount){
        System.out.println(Thread.currentThread().getName()+" starting withdrawing process, balance "+balance);

        try {
//        if(lock.tryLock()) { // if not available , exits immediately
            if (lock.tryLock(5, TimeUnit.SECONDS)) { // if not available, waits for given time
                if (balance >= withdrawAmount) {
                    try {
                        // say what if time is indefinite then,
                        // other thread will wait indefinitely,
                        // that's why we use explicit lock,
                        // cause synchronized does not have timeout
                        //here comes Lock interface
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();  // good practice
                    }
                    balance -= withdrawAmount;
                    System.out.println(Thread.currentThread().getName() + " Amount withdraw - " + withdrawAmount);
                    System.out.println(Thread.currentThread().getName() + " Balance - " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance!!");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Server is busy.....");
            }
        }
        catch(Exception e){
            Thread.currentThread().interrupt(); // good practice
        }
        finally {
            lock.unlock();
        }
    }
}
