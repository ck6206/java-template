public class Weapon extends Item{
    private int power;
    private int numD;
    private int sidesD;
    private int rarity;

    public Weapon(String n, String d, int p, int nd, int s, int r){
        super(n,d);
        power=p;
        numD=nd;
        sidesD=s;
        rarity = r;
    }

    public int getPower(){
        return power;
    }
    public int getNumD(){
        return numD;
    }
    public int getSides(){
        return sidesD;
    }
    
    public String toString(){
        int minDmg = power+numD;
        int maxDmg = power+(sidesD*numD);
        String rareStr;
        if(getRarity()==1){
            rareStr=Tools.yellow+" R1 "+Tools.reset;
        }
        else if(getRarity()==2){
            rareStr=Tools.green+" R2"+Tools.reset;
        }
        else{
            rareStr=Tools.purple+" R3"+Tools.reset;
        }
        
        return Tools.red+getName()+rareStr+Tools.reset+" : "+Tools.red+minDmg+"-"+maxDmg+" (+"+Tools.user.getATK()+")"+Tools.reset+" damage\n   "+getDesc();
    }

    public int getRarity(){
        return rarity;
    }
}