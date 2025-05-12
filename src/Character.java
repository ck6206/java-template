public class Character {
    private String name;
    private int level;
    private int HP;
    private int ATK;
    private int DEF;
    private boolean dead;
    private int healthCap;
    public Character(String n, int l, int h, int a, int d){
        name=n;
        level=l;
        HP=h;
        healthCap=HP;
        ATK=a;
        DEF=d;
        dead=false;
        
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name=n;
    }

    public int getLevel(){
        return level;
    }
    public void setLevel(int l){
        level=l;
    }

    public int getHP(){
        return HP;
    }

    public void setHP(int h){
        HP=h;
    }

    public int getATK(){
        return ATK;
    }
    public void setATK(int a){
        ATK=a;
    }

    public int getDEF(){
        return DEF;
    }
    public void setDEF(int d){
        DEF=d;
    }
    public boolean getDead(){
        return dead;
    }
    
    public void setCap(int h){
        healthCap=h;
    }
    public int getCap(){
        return healthCap;
    }

    public String toString(){
        String end = name+Tools.yellow+" L."+level+Tools.reset+"\nHP: "+Tools.green+HP+"/"+healthCap+Tools.reset+"   ATK: "+Tools.red+ATK+Tools.reset+"   DEF: "+Tools.blue+DEF+Tools.reset;
        return end;
    }

    public void die(){
        System.out.println("\n"+getName() + " has died!");
        dead=true;
    }
}