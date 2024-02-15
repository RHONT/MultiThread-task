package main;

import java.util.*;

public class Master extends Thread implements Command {
    public final House _house;

    public Master(String name, House _house) {
        this._house = _house;
        setName(name);
        start();
    }

    @Override
    public void action(Collection<Integer> collection) {
        Integer random = new Random().nextInt(20);
        collection.add(random);
        ((List<Integer>) collection).sort(Comparator.reverseOrder());
        System.out.println(getName() + " положил вещь " + random + " Всего вещей " + collection);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                _house.doOperation(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
