package functional;

public class GorrillaFamily {
    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        //approach = "run";
        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "ride");
        play(() -> approach);        
    }

    void play(Gorrilla g) {
        System.out.println(g.move());
    }
}