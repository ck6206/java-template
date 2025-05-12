public class Player extends Character{
    private int EXP;
    private Weapon playerWeapon;
    private Armor playerArmor;
    private Flask playerFlask;
    private Item[] inventory = new Item[3];
    private int healthCap;
    private int nextLevel = 50;
    private int gold = 0;
    private String recentDirection = "North";

    public String getRecentDirection() {
        return recentDirection;
    }

    public void setRecentDirection(String recentDirection) {
        this.recentDirection = recentDirection;
    }
    
    public Player(String n, int l, int h, int a, int d, int e, Weapon pW, Armor pA, Flask pF){
        super(n, l, h, a, d);
        EXP=e;
        playerWeapon=pW;
        playerArmor=pA;
        playerFlask=pF;
        inventory[0]=playerWeapon;
        inventory[1]=playerArmor;
        inventory[2]=playerFlask;
        setATK(getATK());
        setDEF(getDEF()+playerArmor.getDefense());
        healthCap = getHP();
    }

    public String getEXP(){
        return "EXP: "+Tools.purple+EXP+"/"+nextLevel+Tools.reset;
    }
    public void setEXP(int e){
        EXP=e;
        if(EXP>=nextLevel){
            EXP-=nextLevel;
            nextLevel+=50;
            levelUp();
        }
    }

    public void levelUp(){
        setLevel(getLevel()+1);
        setHP(getCap()+8);
        setCap(getHP());
        setATK(getATK()+3);
        inventory[2]=new Flask(playerFlask.getName(),playerFlask.getDesc(),playerFlask.getHealBy()+5,playerFlask.getFlasks()+1);
        System.out.println("\nYou leveled up! You are now"+Tools.yellow+" L."+getLevel()+Tools.reset);
        Tools.timer(2);     
        System.out.println( "\nNew Player Status:");
        System.out.println(this); 
        Tools.timer(5);     
    }

    public String getGold(){
        return "Gold: "+Tools.yellow+gold+Tools.reset;
    }

    public void drink(){
        if(playerFlask.getFlasks()!=0){
            setHP(getHP()+playerFlask.getHealBy());
            playerFlask.setFlasks(playerFlask.getFlasks()-1);
            if(getHP()>healthCap){
                setHP(healthCap);
            }
            System.out.println("\n"+super.getName()+" drank a "+Tools.green+"Healing Flask"+Tools.reset);
            Tools.timer(2);
            System.out.println("+"+Tools.green+playerFlask.getHealBy()+Tools.reset+" health, Current HP: "+Tools.green+super.getHP()+Tools.reset);
            Tools.timer(2);
        }
        else{
            System.out.println("No flasks left!");
        }
    }
    
    public void attack(Enemy e){
        int damage1=playerWeapon.getPower()+Tools.rollDice(playerWeapon.getNumD(),playerWeapon.getSides());
        int damage=getATK()+damage1-e.getDEF();
        e.setHP(e.getHP()-damage);
        System.out.println("\n"+getName()+ " attacked with the "+playerWeapon.getName()+": "+Tools.red+damage+Tools.reset+" ("+damage1+"+"+getATK()+"-"+e.getDEF()+") "+"damage dealt!");
        Tools.timer(2);
        if(e.getHP()<=0){
            e.die();
            int newEXP=Tools.rollDice(e.getLevel()+2,10)+4;
            int newGold=Tools.rollDice(e.getLevel()+2,8)+2;
            System.out.println("Gained "+Tools.purple+newEXP+" EXP"+Tools.reset+ " and "+Tools.yellow+newGold+" gold"+Tools.reset+".");
            gold+=newGold;
            setEXP(EXP+=newEXP);
            Tools.timer(3);
        }
    }

    @Override
    public String toString(){
        return super.toString()+"   "+getEXP()+"   "+getGold();
    }

    public void seeInv(){
        System.out.println(Tools.yellow+"Inventory"+Tools.reset);
        for(Item i : inventory){
            System.out.println(i+"\n");
        }
    }

    public Item[] getInv(){
        return inventory;
    }

    public void setWeapon(Weapon i){
        inventory[0]=i;
        playerWeapon=i;
    }
    public void setArmor(Armor i){
        inventory[1]=i;
        playerArmor=i;
        setDEF(playerArmor.getDefense());
    }
    public String opposite(){
        if(recentDirection.equals("North")){
            return "South";
        }
        else if(recentDirection.equals("South")){
            return "North";
        }
        else if(recentDirection.equals("West")){
            return "East";
        }
        else if(recentDirection.equals("East")){
            return "West";
        }
        return "";
    }

    
    public void changeWeapon(Weapon i){
        // Tools.bigLine();
        // System.out.println("You got a new item!\n");
        // Tools.timer(1);
        System.out.println(Tools.yellow+"New:"+Tools.reset+"\n"+i+"\n");
        Tools.timer(2);
        System.out.println("Do you want to replace your current weapon?\n");
        Tools.timer(1);
        System.out.println(Tools.purple+"Current:\n"+Tools.reset+playerWeapon);
        Tools.timer(2);
        Tools.bigLine();
        System.out.println(Tools.green+"\n[Y]"+Tools.reset+"Replace your current weapon with the new one (you will lose your current weapon)");
        System.out.println(Tools.red+"[N]"+Tools.reset+"Keep your current weapon and don't take the new one (you will lose access to the new weapon, for now)");
        System.out.print("Your choice: ");
        String[] yesNo = {"Y","N"};
        String input = Tools.checkInput(yesNo);
        if(input.equals("y")){
            System.out.println("You left the "+Tools.red+playerWeapon.getName()+Tools.reset+" and are now wielding the "+Tools.yellow+i.getName()+Tools.reset);
            setWeapon(i);
            Tools.timer(2);
        }
        else{
            System.out.println("The "+Tools.red+i.getName()+Tools.reset+" will be left behind, and you will keep your "+Tools.green+playerWeapon.getName()+Tools.reset);
            Tools.timer(2);
        }
    } 

    public void changeArmor(Armor i){
        System.out.println(Tools.yellow+"New:"+Tools.reset+"\n"+i+"\n");
        Tools.timer(2);
        System.out.println("Do you want to replace your current set of armor?\n");
        Tools.timer(1);
        System.out.println(Tools.purple+"Current:\n"+Tools.reset+playerArmor);
        Tools.timer(2);
        Tools.bigLine();
        System.out.println(Tools.green+"\n[Y]"+Tools.reset+"Replace your current armor with the new one (you will lose your current armor)");
        System.out.println(Tools.red+"[N]"+Tools.reset+"Keep your current armor and don't take the new one (you will lose access to the new armor, for now)");
        System.out.print("Your choice: ");
        String[] yesNo = {"Y","N"};
        String input = Tools.checkInput(yesNo);
        if(input.equals("y")){
            System.out.println("You left the "+Tools.red+playerArmor.getName()+Tools.reset+" and are now wearing the "+Tools.yellow+i.getName()+Tools.reset);
            setArmor(i);
            Tools.timer(2);
        }
        else{
            System.out.println("The "+Tools.red+i.getName()+Tools.reset+" will be left behind, and you will keep wearing your "+Tools.green+playerArmor.getName()+Tools.reset);
            Tools.timer(2);
        }
    } 

    public Weapon getWeapon() {
        return playerWeapon;
    }

    public Armor getArmor() {
        return playerArmor;
    }

}