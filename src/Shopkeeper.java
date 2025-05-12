import java.util.ArrayList;
public class Shopkeeper{
    private String[] dialogue = {
        Tools.yellow+"Shopkeeper: "+Tools.reset+"Hello, adventurer! I have some items for sale that could prove useful,\nI recommend you buy some to help you on your journey.",
        Tools.yellow+"Shopkeeper: "+Tools.reset+"Hello, I'm one of the many Shopkeepers in these lands.\nWe do whatever we can to help adventurers keep safe. Please feel free to buy some of my items.",
        Tools.yellow+"Shopkeeper: "+Tools.reset+"Greetings, traveler! You look like you could use some supplies.\nTake a look at what I have to offer.",
        Tools.yellow+"Shopkeeper: "+Tools.reset+"Welcome! It's always a pleasure to see a new face.\nFeel free to browse my wares and let me know if anything catches your eye."
    };
    private ArrayList<Item> forSale = new ArrayList<>();
    public Shopkeeper(){
        int numSlots=(int)(Math.random()*5)+2;
        boolean w=false;
        boolean a=false;
        for(int i=0;i<numSlots;i++){
            int wOa=(int)(Math.random()*100)+1;
            if(wOa<=50){
                w=true;
            }
            else{
                a=true;
            }
            int rare=(int)(Math.random()*100)+1;
            int randDex=0;
            if(rare<=60){
                if(w){
                    // boolean inStock=true;
                    // while(inStock){
                    //     Weapon newItem=Tools.simple[((int)(Math.random()*Tools.simple.length))];
                    //     for(Item currItem:forSale){
                    //         if(currItem!=newItem){
                    //             inStock=false;
                    //         }
                    //     }
                    //     if(!inStock){
                    //         forSale.add(newItem);
                    //     }
                    // }

                    Weapon newItem=Tools.simple[((int)(Math.random()*Tools.simple.length))];
                    forSale.add(newItem);

                }
                else if(a){
                    // boolean inStock=true;
                    // while(inStock){
                    //     Armor newItem=Tools.light[((int)(Math.random()*Tools.light.length))];
                    //     for(Item currItem:forSale){
                    //         if(currItem!=newItem){
                    //             inStock=false;
                    //         }
                    //     }
                    //     if(!inStock){
                    //         forSale.add(newItem);
                    //     }
                    // }
                    
                    Armor newItem=Tools.light[((int)(Math.random()*Tools.light.length))];
                    forSale.add(newItem);
                }
            }
            else if(rare<=85){
                if(w){
                    // boolean inStock=true;
                    // while(inStock){
                    //     Weapon newItem=Tools.martial[((int)(Math.random()*Tools.martial.length))];
                    //     for(Item currItem:forSale){
                    //         if(currItem!=newItem){
                    //             inStock=false;
                    //         }
                    //     }
                    //     if(!inStock){
                    //         forSale.add(newItem);
                    //     }
                    // }

                    Weapon newItem=Tools.martial[((int)(Math.random()*Tools.martial.length))];
                    forSale.add(newItem);
                }
                else if(a){
                    // boolean inStock=true;
                    // while(inStock){
                    //     Armor newItem=Tools.medium[((int)(Math.random()*Tools.medium.length))];
                    //     for(Item currItem:forSale){
                    //         if(currItem!=newItem){
                    //             inStock=false;
                    //         }
                    //     }
                    //     if(!inStock){
                    //         forSale.add(newItem);
                    //     }
                    // }

                    Armor newItem=Tools.medium[((int)(Math.random()*Tools.medium.length))];
                    forSale.add(newItem);
                }
            }
            else{
                if(w){
                    // boolean inStock=true;
                    // while(inStock){
                    //     Weapon newItem=Tools.magic[((int)(Math.random()*Tools.magic.length))];
                    //     for(Item currItem:forSale){
                    //         if(currItem!=newItem){
                    //             inStock=false;
                    //         }
                    //     }
                    //     if(!inStock){
                    //         forSale.add(newItem);
                    //     }
                    // }

                    Weapon newItem=Tools.magic[((int)(Math.random()*Tools.magic.length))];
                    forSale.add(newItem);
                }
                else if(a){
                    // boolean inStock=true;
                    // while(inStock){
                    //     Armor newItem=Tools.heavy[((int)(Math.random()*Tools.heavy.length))];
                    //     for(Item currItem:forSale){
                    //         if(currItem!=newItem){
                    //             inStock=false;
                    //         }
                    //     }
                    //     if(!inStock){
                    //         forSale.add(newItem);
                    //     }
                    // }

                    Armor newItem=Tools.heavy[((int)(Math.random()*Tools.heavy.length))];
                    forSale.add(newItem);
                }
            }
        }
    }

    public void talk(){
        int randDia = (int)(Math.random()*dialogue.length);
        System.out.println(dialogue[randDia]);
        Tools.timer(4);
        showStock();
    }

    public String showStock(){
        String end = "\n";
        for(int i=0;i<forSale.size();i++){
            System.out.println(forSale.get(i));
            Tools.timer(2);
        }
        return end;
    }

}