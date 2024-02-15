package main;

import java.util.*;

public final class House {
    public final List<Integer> _items;

    public House() {
        this._items = new Vector<>();
    }

    public void doOperation(Command command) throws InterruptedException {
           command.action(_items);
    }
}
