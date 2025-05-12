public class Flask extends Item{
    private int healBy;
    private int numFlasks;
    public Flask(String n, String d, int hB, int nF){
        super(n,d);
        healBy=hB;
        numFlasks=nF;
    }
    public int getHealBy(){
        return healBy;
    }
    public void setHealBy(int h){
        healBy=h;
    }

    public int getFlasks(){
        return numFlasks;
    }
    public void setFlasks(int f){
        numFlasks=f;
    }
    
    public String toString(){
        return Tools.green+getName()+Tools.reset+" : "+Tools.green+healBy+Tools.reset+" healing, "+numFlasks+" uses\n   "+getDesc();
    }
}