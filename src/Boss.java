
//THIS CLASS IS NOT FINISHED, AND NOT USED

public class Boss extends Character{
    public Boss(String n, int l, int h, int a, int d){
        super(n, l, h, a, d);
    }

    public void normAttack(Player p){
        int dmg = getATK()+Tools.rollDice(getLevel(),4) - p.getDEF();
        if(dmg<=0){
            dmg=0;
        }
        p.setHP(p.getHP()-dmg);
        System.out.println(getName()+" attacks "+p.getName()+": "+Tools.red+dmg+Tools.reset+" damage dealt!");     

        if(p.getHP()<=0){
            p.setHP(0);
            p.die();
            Tools.timer(2);
            System.out.println(Tools.red+"\nGAME OVER");
            Tools.timer(2);
            System.exit(0);
        }   
        
        Tools.timer(2);
    }

    public void piercingAttack(Player p){
        int dmg = getATK()+Tools.rollDice(getLevel(),4);
        if(dmg<=0){
            dmg=0;
        }
        p.setHP(p.getHP()-dmg);
        System.out.println(getName()+" hits "+p.getName()+" with a piercing attack, bypassing all armor protection: "+Tools.red+dmg+Tools.reset+" damage dealt!");     

        if(p.getHP()<=0){
            p.setHP(0);
            p.die();
            Tools.timer(2);
            System.out.println(Tools.red+"\nGAME OVER");
            Tools.timer(2);
            System.exit(0);
        }   
        
        Tools.timer(2);
    }

    public void heavyAttack(Player p){
        int dmg = getATK()+Tools.rollDice(getLevel(),8) - p.getDEF();
        if(dmg<=0){
            dmg=0;
        }
        p.setHP(p.getHP()-dmg);
        System.out.println(getName()+" attacks "+p.getName()+" with a heavy attack: "+Tools.red+dmg+Tools.reset+" damage dealt!");     

        if(p.getHP()<=0){
            p.setHP(0);
            p.die();
            Tools.timer(2);
            System.out.println(Tools.red+"\nGAME OVER");
            Tools.timer(2);
            System.exit(0);
        }   
        
        Tools.timer(2);
    }

    public void phaseTwo(int a){
        System.out.println(Tools.red + "IMPRESSIVE, CHILD.\n");
        Tools.timer(2);
        System.out.println(Tools.red+ "THIS IS THE CLOSEST A MORTAL HAS BROUGHT ME TO DEATH. BUT OF COURSE... \n");
        Tools.timer(2);
        System.out.println(Tools.red+"I WON'T LET YOUR IMPUDENCE STAND ANY LONGER. \n");
        Tools.timer(2);
        System.out.println(Tools.red+ getName()+"'s eyes ignite with red fire. Some sort of ancient power seems to be lurking in that fire...");
        Tools.timer(2);
        System.out.println(Tools.red+ "TIME FOR YOU TO DIE."+ Tools.reset);

        setATK(getATK()+5);
    }   

    public void ultimate(){
        int dmg = getATK()+Tools.rollDice(getLevel(),15) - p.getDEF();
        if(dmg<=0){
            dmg=0;
        }
        p.setHP(p.getHP()-dmg);
        System.out.println(Tools.red+ "ULTIMATE ART: FLAMES OF THE FALLEN KING \n" + Tools.reset);
        System.out.println(getName()+" attacks "+p.getName()+" with a spell of unrivaled power: "+Tools.red+dmg+Tools.reset+" damage dealt!");     

        if(p.getHP()<=0){
            p.setHP(0);
            p.die();
            Tools.timer(2);
            System.out.println(Tools.red+"\nGAME OVER");
            Tools.timer(2);
            System.exit(0);
        }   
        
        Tools.timer(2);
    }
}