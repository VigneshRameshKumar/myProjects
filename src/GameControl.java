import java.util.Scanner;

public class GameControl extends RandomClass {
    Scanner sc = new Scanner(System.in);

    PlayerClass player;
    PlayerClass computer;
    GameControl(){
       player =new PlayerClass("Player");
       computer = new PlayerClass("Computer");
       coinToss();
       match();
    }
    public void coinToss(){
        System.out.println("Toss! Choose head or tail");
        player.tossDec=sc.nextLine();
        int intDec = player.tossDec.equals("head")? 1:2;
        int coinToss=toss();

        if(coinToss==intDec){
            System.out.println(player.tossDec + " it is , batting or bowling");
            String temp=sc.nextLine();
            player.setBatting(temp.equals("batting")?"first":"second");
            computer.setBatting(player.getBatting().equals("first")?"second":"first");
        }
        else{
            System.out.println("You loss the toss it is " + (player.tossDec.equals("head") ? "tail" : "head") + ".");
            computer.setBatting(coinToss==1?"first":"second");
            player.setBatting(computer.getBatting().equals("first")?"second":"first");
            System.out.println("computer choose to " + (computer.getBatting().equals("first")?"batting": "bowling"));
        }

    }

    public void batting (PlayerClass obj, String str,boolean flag){
        int total=0;
        int guess=0;
        int target=0;
       // String opp;
        if(flag){
            target=player.getScore()!=0? player.getScore() : computer.getScore();
        }
        while(true){
            System.out.println(str +" : ");
            guess=sc.nextInt();
            int comp =generate();
            System.out.println("Computer puts : "+comp);
            if(guess!=comp){
                if(obj.name.equals("Player")){
                   total=total+guess;
                }
                else {
                    total=total+comp;
                }
                if(flag){
                    if(total>=target){
                        obj.setScore(total);
                        System.out.println("Total score = "+ obj.getScore());
                        break;
                    }
                }
            }
            else{
                obj.setScore(total);
                System.out.println("Total score = "+ obj.getScore());
                break;
            }
        }
    }
    public void match(){
        String winner;
        //debugInfo(player);
        //debugInfo(computer);
        if(player.getBatting()=="first"){
            System.out.println("Player is first batting");
            batting(player,"bat",false);
        }
        else{
            System.out.println("Player is first bowling");
            batting(computer,"bowl",false);
        }
        //debugInfo(player);
        //debugInfo(computer);
        if(player.getBatting()=="second"){
            System.out.println("Now player is batting");
            batting(player,"bat",true);
        }
        else{
            System.out.println("Now player is bowling");
            batting(computer,"bowl",true);
        }
        debugInfo(player);
        debugInfo(computer);
        System.out.println();
        System.out.println();
        if(player.getScore() == computer.getScore())
        {
            System.out.println(" ===Match Draw===");
        } else if (player.getScore()> computer.getScore()) {
            System.out.println("===Player Won the match by " +(player.getScore()- computer.getScore())+" run===");
        }
        else {
            System.out.println("===Computer Won the match by "+(computer.getScore()- player.getScore())+ " run===");
        }

    }

}
