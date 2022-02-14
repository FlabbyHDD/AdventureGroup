package adventure.Adventure;


public class creature {
public String name;
public int health;
public boolean playerAlive = true;
public  int str;
public int speed;
    public creature(String name, int health, int str, int speed){
        
        this.name = name;
        this.health = 100;
        this.str = 1;
        this.speed = 10;
       
    }
    
    public void healthChange( int hp)
     {
        health += hp;
    }
    public void strChange( int stre)
     {
        str += stre;
    }
   
   public void speedChange(int x)
     {
       speed += x;
    }
    public void death(){
        playerAlive = false;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getstr(){
        return str;
    }
    public int getspeed(){
        return speed;
    } 
    public boolean getAlive(){
        return playerAlive;
    }
    public String getStats(){
        return ( "HP is: " +health+", Strength is: " + str + ", Speed is: " +speed);
    }
}
