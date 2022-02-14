package adventure.Adventure;
import java.util.Scanner;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Adventure {

    public static void main(String[] args){
        int fire = 0;
        int numYear = 1;
        boolean stop = false;
        boolean hiddenEnding = false;
        boolean hasSword = false;
        boolean sage = false;
        boolean hasArmour = false;
        boolean hasShield = false;
        boolean win = false;
        boolean playerAlive = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("what is your name Hero? ");
        String playerName = (sc.nextLine());
        System.out.println("what is the name of the evil demon that plagues this land? ");
        String bossName = (sc.nextLine());
        creature player = new creature(playerName,0, 0, 0);
        boss demon = new boss(bossName, 0,0,0);
        int attack = player.getstr();
        int demonMaxHp = demon.getHealth();
        int check = demonMaxHp/2;
            System.out.println("100 years ago, " +bossName + " ressurected and started his conquest to take over the world, but you have awoken. Hero save this land! \nyou have 5 years to prepare. before you go Let me give you this amulet.");
            System.out.println("hero your stats are, " + player.getStats());
        while ((win == false) && (playerAlive == true) && (hiddenEnding == false) && (stop == false)) {
        if ((numYear > 5)&&(win == false) && (playerAlive == true) && (hiddenEnding == false) && (stop == false)){

            //items obtained check
            if (hasSword == true){
                player.strChange(15000);
                System.out.println("having the sword boost your power");
            }
            if (hasArmour == true){
                player.healthChange(55000);
                System.out.println("having the armour boost your vitality");
            }
            if (sage == true){
                demon.healthChange(200000);
                System.out.println("having the sages blessing the demon is weakend");
                demon.healthChange(-40000);
                demon.strChange(-2000);
                demon.speedChange(-4000);
            }
            System.out.println("the amulet given to you earlier, shines, and show you the demons' stats " + demon.getStats());
            System.out.println("the amulet given to you earlier, shines, and show you your stats " + player.getStats());

            //player attack first chosen, super hits,55 % hit rate and 2 attack multiplyer, whilw hits 100%
            while ((player.getspeed()> demon.getspeed()) && (playerAlive == true) && (win == false)){
                System.out.println("you swing faster, you decide to \n hit(h) or super hit(s) ");
                String hitChoice = (sc.nextLine());
                if (hitChoice.equals("s")){
                    int hit = (int)(Math.random() * 100) + 0;
                    if (hit >= 45){
                        demon.healthChange(-attack*2);
                        System.out.println("you hit the demon and now he is at, " + demon.getHealth() + "Hp");
                    }
                    else{
                        System.out.println("you miss, " + demon.getHealth() + "Hp");
                    }
                }
                if (hitChoice.equals("h")){
                    demon.healthChange(attack);
                    System.out.println("you hit the demon and now he is at, " + demon.getHealth() + " hp");
                }
                System.out.println("the demon attacks");
                if (demon.getHealth() <= 0){
                    win = true;
                    break;
                }
                if ((demon.getHealth()<= check) && (fire == 0)){
                    System.out.println("out of deperation the demon uses all of his magic to fire a huge laser.");
                    if (hasShield == true){
                        System.out.println("thanks to the shield of aegis you were able to reflect the laser back at the demon");
                        demon.healthChange(-80000);
                        System.out.println("the demon was damaged and is now at "+demon.getHealth() + "Hp");
                    }
                    else{
                        player.healthChange(-100000);
                        System.out.println("you were severaly wounded "+ player.getHealth() + "Hp");
                    }

                }
                else{
                    player.healthChange(-demon.getstr());
                    System.out.println("you were hit by the demon and now is, " + player.getHealth() + "Hp");
                }
                if (demon.getHealth() <= 0){
                    win = true;
                    break;
                }
                if (player.getHealth() <= 0){
                   playerAlive = false;
                   break;
                }
                
        }

            // boss attacks first chosen

            while ((player.getspeed()< demon.getspeed()) && (playerAlive == true) && (win == false)){
                System.out.println("the faster demon attacks");
                    if ((demon.getHealth()<= check) && (fire == 0)){
                        System.out.println("out of deperation the demon uses all of his magic to fire a huge laser.");
                        if (hasShield == true){
                            System.out.println("thanks to the shield of aegis you were able to reflect the laser back at the demon");
                            demon.healthChange(-80000);
                            System.out.println("the demon was damaged and is now at "+demon.getHealth() + "Hp");
                        }
                        else{
                            player.healthChange(-100000);
                            System.out.println("you were severaly wounded "+ player.getHealth() + "Hp");
                        }
    
                    }
                    else{
                        player.healthChange(-demon.getstr());
                        System.out.println("you were hit by the demon and now is at, " + player.getHealth() + "Hp");
                    }
                    if (demon.getHealth() <= 0){
                        win = true;
                        break;
                    }
                    if (player.getHealth() <= 0){
                       playerAlive = false;
                       break;
                    }
                    System.out.println("you swing faster, you decide to \n hit(h) or super hit(s) ");
                    String hitChoice = (sc.nextLine());
                    if (hitChoice.equals("s")){
                        int hit = (int)(Math.random() * 100) + 0;
                        if (hit >= 45){
                            demon.healthChange(-attack*2);
                            System.out.println("you hit the demon and now he is at, " + demon.getHealth() + "Hp");
                        }
                        else{
                            System.out.println("you miss, " + demon.getHealth() + "Hp");
                        }
                    }
                    if (hitChoice.equals("h")){
                        demon.healthChange(-attack);
                        System.out.println("you hit the demon and now he is at, " + demon.getHealth() + " hp");
                    }
                    System.out.println("the demon attacks");
                    if (demon.getHealth() <= 0){
                        win = true;
                        break;
                    }
              
            
   }
        
        


        }
        else{
            System.out.println("it's year "+ numYear +" do you wish to train(type q), explore(type e), or sleep(type s)");
            String year = (sc.nextLine());
             if (year.equals("q")){
                    System.out.println("which stat? strength(1), HP(2), speed(3)");
                    String train = (sc.nextLine());
             if (train.equals("1")){
                    System.out.println("you spent an entire year rasing your power!");
                    player.strChange(3000);
                    System.out.println(player.getStats());
                    numYear ++;
                }
             if (train.equals("2")){
                    System.out.println("you spent an entire year rasing your HP!");
                    player.healthChange(45000);
                    System.out.println(player.getStats());
                    numYear++;
                
            }
             if (train.equals("3")){
                    System.out.println("you spent an entire year rasing your speed!");
                    player.speedChange(10000);
                    System.out.println(player.getStats());
                    numYear++;
                }
         }
         if (year.equals("e")){
            System.out.println("explore the forest(1), explore the mountains(2), enter the sacred dungeon in the east(3), explore the temple in the west(4). ");
            String nav = (sc.nextLine());
            if (nav.equals("1")) {
                System.out.println("you see a faint glow, a sword stuck in the stone. Do you wish to try and pull it out(y/n)");
                String pull = (sc.nextLine());
                if ((pull.equals("y"))&&(player.getstr()> 1000)){
                    System.out.println("you obtained the holy sword and return home.");
                    hasSword = true;
                    numYear++;
                }
                else{
                    System.out.println("you realize either being too weak or too scared, to go home with nothing after a year.");
                    numYear++;
                }
             }
            if (nav.equals("2")){
                System.out.println("you see a faint glow, the holy sage chained by the demon. Do you wish to try and break the chains(y/n)");
                String pull = (sc.nextLine());
                if ((pull.equals("y"))&&(hasSword == true)){
                    System.out.println("Thank you hero, with my power free, I shall bless you in your fight agaist the demon");
                    sage = true;
                    numYear++;
                }
                else{
                    System.out.println("you realize either not having the tools or too scared, to go home with nothing after a year.");
                    numYear++;
            }
          
         }
            if (nav.equals("3")){
                System.out.println("you see the shield of aegis, the demon has blocked it with magic. Do you wish to try and enter(y/n)");
                String pull = (sc.nextLine());
                if ((pull.equals("y"))&&(hasArmour == true)){
                    System.out.println("you obtained the shield of Aegis and return home. But lose the holy armour");
                    hasArmour = false;
                    hasShield = true;
                    numYear++;
                }
                else{
                    System.out.println("you realize either not having the magic to break the spell or too scared, to go home with nothing after a year.");
                    numYear++;
            }
        
        }
            if (nav.equals("4")){
                    System.out.println("you see the holy Armour,  Do you wish to try and take it(y/n)");
                    String pull = (sc.nextLine());
                    if (pull.equals("y")){
                        System.out.println("you obtained the holy armour but realize there is no magic stat, what could it be used for? you ponder and return home.");
                        hasArmour = true;
                        numYear++;
                    }
                    else{
                        System.out.println("you realize either not having the magic to break the spell or too scared, to go home with nothing after a year.");
                        numYear++;
                }
            
            }
     
            if (nav.equals("5")){
                hiddenEnding = true;
                break;
            }
          
                
    }
     if (year.equals("s")){
              System.out.println("you lay in bed, sleeping the entire year...");
              numYear++;
             }   
}
        if (playerAlive == false){
            System.out.println("hero you have fallen to "+ bossName + ", what HORRROR!!!");
        }
        if (win == true){
            System.out.println("hero "+playerName+ "amazing job slaying " + bossName + ", see you next time!!!");
        }
        if (hiddenEnding == true){
            System.out.println("hero "+playerName+ " you dare break the game!!! Nice, don't worry about the Demon, naw to be honest he's just my cousin.(secret ending achieved)");
        }

    }
    
    }
}
   