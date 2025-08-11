package multithreading.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Reentrant r = new Reentrant();
        r.outerMethod();
    }
}

class Reentrant {

    Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock(); // see here we locked
        System.out.println("OuterMethod");
        innerMethod();
        lock.unlock(); // will give error if two unlock used in innerMethod as lock is already unlocked
    }

    public void innerMethod(){
        // here again locking , we can do this cause we are using reentrant lock, therefor we can lock it again
        // in reentrant locking , a thread can lock using same lock multiple times
        // if it is not reentrant then deadlock will occur here, as  below lock will wait till the lock get unlocked so that it can be locked again
        lock.lock();
        System.out.println("InnerMethod");
        lock.unlock();
        // if one more unlock here then the lock completely unlocked
//        lock.unlock();
    }

    // lock.unlock always unlocks the last lock we acquired, internally lock manage state, as we lock state increases by one, as unlock state decreases
}
