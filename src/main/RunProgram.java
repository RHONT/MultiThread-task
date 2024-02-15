package main;

import java.util.ArrayList;
import java.util.List;

public class RunProgram {
    public static void main(String[] args) {
        House house=new House();
        Master master = new Master("Мастер",house);
        Master master2 = new Master("Мастер2",house);
        Rob rob=new Rob(100,"Вор");
        Rob rob2=new Rob(200,"Вор_2");
        Rob rob3=new Rob(300,"Вор_3");

        List<Master> masters=List.of(master,master2);
        List<Rob> robs=List.of(rob2,rob,rob3);
        go(robs,masters);


    }

    static public void go(List<Rob> robs, List<Master> masters){
        for (var rob:robs) {
            List<House> houses=new ArrayList<>();
            for (var master:masters) {
                houses.add(master._house);
            }
            rob.addHouses(houses);
        }
    }
}
