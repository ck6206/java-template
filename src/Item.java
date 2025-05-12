public class Item {
    private String name;
    private String desc;
    public Item(String n, String d){
        name=n;
        desc=d;
    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        name=n;
    }
    
    public String getDesc(){
        return desc;
    }
    public void setDesc(String d){
        desc=d;
    }

    public String toString(){
        return "";
    }
}