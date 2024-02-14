package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Rob extends Thread implements Command {
    private final int _maxSize;
    private int _plenum = 0;
    private List<House> _houses =new ArrayList<>();

    public Rob(int sizeBag, String name) {
        setName(name);
        this._maxSize = sizeBag;
    }

    public void addHouses(List<House> houses) {
        _houses=houses;
        start();
    }

    @Override
    public void action(Collection<Integer> collection) {
        Iterator<Integer> it = collection.iterator();
        Integer temp = null;
        while (it.hasNext()) {
            Integer value = it.next();
            if (freePlace() >= value) {
                _plenum += value;
                temp = value;
                System.out.println("Вор " + getName() + " смог украсть " + value + ". У вора теперь добра " + _plenum);
                break;
            }
        }
        if (temp == null) {
            System.out.println(getName() + "В сумку ничего не лезет!");
            if (freePlace()==0) {
                interrupt();
            }
        }
    }

    private int freePlace() {
        return _maxSize - _plenum;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            for (var element: _houses){
                try {
                    element.doOperation(this);
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " достаточно награбил! Теперь он уходит");
                    interrupt();
                }
            }
        }

    }

}
