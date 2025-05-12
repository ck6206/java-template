public class Armor extends Item{
    private int defense;
    private int rarity;

    public Armor(String n, String d, int df, int r){
        super(n,d);
        defense=df;
        rarity = r;
    }    
    public int getDefense(){
        return defense;
    }
    public String toString(){
        String rareStr;
        if(getRarity()==1){
            rareStr=Tools.yellow+" R1"+Tools.reset;
        }
        else if(getRarity()==2){
            rareStr=Tools.green+" R2"+Tools.reset;
        }
        else{
            rareStr=Tools.purple+" R3"+Tools.reset;
        }
        return Tools.blue+getName()+rareStr+Tools.reset+" : +"+Tools.blue+defense+Tools.reset+" defense\n   "+getDesc();
    }
    public int getRarity() {
        return rarity;
    }
}