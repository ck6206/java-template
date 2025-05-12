public class Enemy extends Character{

    public Enemy(String n, int l){
        super(n, l, 1,1,1);
        setHP(Tools.rollDice(getLevel(),8)+5); // Ld8+5
        setCap(getHP());
        setATK(Tools.rollDice(getLevel(),3)); // Ld4
        setDEF(Tools.rollDice(getLevel(),3)); // Ld4
    }

    public void attack(Player p){
        int dmg = getATK()+Tools.rollDice(getLevel(),6)+4 - p.getDEF();
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
}
