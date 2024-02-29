import java.util.Random;

public class RandomClass {
    Random rand = new Random();

    public int toss() {

        return rand.nextInt(2) + 1;
    }

    public int generate() {
        return rand.nextInt(6) + 1;
    }

    public void debugInfo(PlayerClass obj) {
        System.out.println("=======Debug Info ==========");
        System.out.println("Player name =" + obj.name);
        System.out.println("Player is batting = " + obj.getBatting());
        System.out.println("Player score =" +obj.getScore());
        System.out.println("=============================");
    }
}