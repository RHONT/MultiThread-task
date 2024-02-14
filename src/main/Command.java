package main;

import java.util.Collection;

public interface Command {
    void action(Collection<Integer> collection);
}
