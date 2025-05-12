import java.util.Scanner;

public class Tools {
    public static String red = "\u001B[31m";
    public static String green = "\u001B[32m";
    public static String yellow = "\u001B[33m";
    public static String blue = "\u001B[34m";
    public static String purple = "\u001B[35m";
    public static String cyan = "\u001B[36m";
    public static String reset = "\u001B[0m";

    public static String[] enemyList = new String[]{
        "Goblin",
        "Skeleton",
        "Demon",
        "Zombie",
        "Hobgoblin",
        "Ogre",
        "Gnoll",
        "Orc",
        "Troll",
        "Warg",
        "Imp",
        "Gargoyle",
        "Serpentfolk",
        "Minotaur",
        "Cyclops",
        "Gorgon",
        "Gremlin",
        "Ghoul",
        "Vampire",
        "Kobold",
        "Chimera",
        "Manticore",
        "Direwolf",
        "Pseudodragon",
    };

    public static String[] placeList = new String[]{
        "past an "+green+"Abandoned Camp"+reset,
        "into a "+green+"Small Cave"+reset,
        "a part of the "+green+"Evergreen Forest"+reset,
        "into a "+green+"Rundown Shack"+reset,
        "near some "+green+"Ancient Ruins"+reset,
        "through a "+green+"Fog-covered Swamp"+reset,
        "over a "+green+"Shallow River"+reset,
        "through the "+green+"Grassfields"+reset,
        "past a "+green+"Strange Graveyard"+reset,
    };

    //heals
    public static Flask crimson = new Flask("Healing Flask","description",8,5);
        
    public static Weapon rustySword = new Weapon("Rusty Sword", "desc.", 3, 1, 4, 0);

    //simple
    public static Weapon club = new Weapon("Club", "A simple wooden club.", 0, 1, 4, 1);
    public static Weapon dagger = new Weapon("Dagger", "A small, easily concealable blade.", 4, 1, 4, 1);
    public static Weapon greatclub = new Weapon("Greatclub", "A large wooden club.", 3, 1, 8, 1);
    public static Weapon handaxe = new Weapon("Handaxe", "A small axe that can be thrown.", 2, 1, 6, 1);
    public static Weapon javelin = new Weapon("Javelin", "A light spear designed for throwing.", 3, 1, 6, 1);
    public static Weapon lightHammer = new Weapon("Light Hammer", "A small hammer that can be thrown.", 4, 1, 4, 1);
    public static Weapon mace = new Weapon("Mace", "A blunt weapon with a heavy head.", 3, 1, 8, 1);
    public static Weapon quarterstaff = new Weapon("Quarterstaff", "A simple wooden staff.", 2, 1, 6, 1);
    public static Weapon sickle = new Weapon("Sickle", "A curved blade used for cutting.", 2, 1, 4, 1);
    public static Weapon spear = new Weapon("Spear", "A versatile weapon for thrusting or throwing.", 3, 1, 6, 1);

    //martial
    public static Weapon battleaxe = new Weapon("Battleaxe", "A versatile axe used for combat.", 3, 1, 8, 2);
    public static Weapon flail = new Weapon("Flail", "A spiked weapon attached to a chain, difficult to master.", 4, 1, 6, 2);
    public static Weapon glaive = new Weapon("Glaive", "A polearm with a sharp blade at the end.", 2, 1, 10, 2);
    public static Weapon lance = new Weapon("Lance", "A long weapon designed for mounted combat.", 2, 1, 12, 2);
    public static Weapon longsword = new Weapon("Longsword", "A classic sword favored by knights.", 3, 1, 8, 2);
    public static Weapon maul = new Weapon("Maul", "A massive hammer that delivers devastating blows.", 4, 2, 6, 2);
    public static Weapon morningstar = new Weapon("Morningstar", "A spiked weapon that combines blunt and piercing damage.", 0, 1, 8, 2);
    public static Weapon pike = new Weapon("Pike", "A long spear designed for keeping enemies at bay.", 3, 1, 10, 2);
    public static Weapon rapier = new Weapon("Rapier", "A thin, sharp sword designed for precision thrusts.", 1, 1, 8, 2);
    public static Weapon scimitar = new Weapon("Scimitar", "A curved sword designed for slashing attacks.", 3, 1, 6, 2);
    public static Weapon shortsword = new Weapon("Shortsword", "A lightweight sword favored by rogues.", 2, 1, 6, 2);
    public static Weapon trident = new Weapon("Trident", "A three-pronged spear used for piercing attacks.", 3, 1, 8, 2);
    public static Weapon warPick = new Weapon("War Pick", "A pickaxe-like weapon designed for piercing armor.", 3, 1, 8, 2);
    public static Weapon warhammer = new Weapon("Warhammer", "A hammer designed for crushing blows.", 4, 1, 8, 2);
    public static Weapon whip = new Weapon("Whip", "A flexible weapon with extended reach.", 2, 1, 4, 2);

    public static Weapon[] simple = {
        club, dagger, greatclub, handaxe, javelin, lightHammer, mace, quarterstaff, sickle, spear
    };

    public static Weapon[] martial = {
        battleaxe, flail, glaive, lance, longsword, maul, morningstar, pike, rapier, scimitar, shortsword, trident, warPick, warhammer, whip
    };

    public static Weapon[] magic = {
        rustySword
    };


    //light
    public static Armor leather = new Armor("Leather Armor","Light armor that doesn't provide much protection.",5, 1);
    public static Armor padded = new Armor("Padded Armor", "Light armor made of quilted layers of cloth.", 4, 1);
    public static Armor studdedLeather = new Armor("Studded Leather Armor", "Leather armor reinforced with metal studs.", 6, 2);

    //medium
    public static Armor hide = new Armor("Hide Armor", "Armor made from thick animal hides.", 6, 1);
    public static Armor chainShirt = new Armor("Chain Shirt", "A shirt of interlocking metal rings worn under clothing.", 7, 2);
    public static Armor scaleMail = new Armor("Scale Mail", "Armor made of overlapping metal plates.", 8, 2);
    public static Armor breastplate = new Armor("Breastplate", "A fitted metal chest piece worn with light materials.", 8, 3);
    public static Armor halfPlate = new Armor("Half-Plate Armor", "Partly chain and partly steel, this armor can hold up for a while.", 9, 3);

    //heavy
    public static Armor ringMail = new Armor("Ring Mail", "Armor made of leather with heavy metal rings sewn into it.", 7, 1);
    public static Armor chainMail = new Armor("Chainmail", "Armor formed of chain links that can deflect light attacks.", 9, 2);
    public static Armor splint = new Armor("Splint Armor", "Armor made of metal strips attached to a leather backing.", 10, 3);
    public static Armor plate = new Armor("Plate Armor", "A sturdy set of armor that can stand against some of the strongest blows.", 11, 4);

    public static Armor[] light = {
        padded, leather, studdedLeather, 
    };

    public static Armor[] medium = {
        hide, chainShirt, scaleMail, breastplate, halfPlate
    };

    public static Armor[] heavy = {
        ringMail, chainMail, splint, plate
    };

    public static int rollDice(int n, int d){
        int num = 0;
        for(int i=0;i<n;i++){
            num+=(int)(Math.random()*d)+1;
        }
        return num;
    }

    public static void timer(int x){
        try{
            Thread.sleep(x*1000); 
        }
        catch (InterruptedException ee){
            ee.printStackTrace();
        }        
    }

    public static String checkInput(String[] s){
        Scanner scanner = new Scanner(System.in);
        boolean inputGood = false;
        String input2="";

        String pleaseString = "";
        for(String e : s){
            if(e.equals(s[s.length-1])){
                pleaseString = pleaseString+"or "+e+":";
            }
            else{
                pleaseString = pleaseString+e+", ";
            }
        }

        while(!inputGood){
            input2=scanner.nextLine();
            for(String e : s){
                String e2=e.toLowerCase();
                if(input2.equals(e2) || input2.equals(e)){
                    inputGood=true;
                }
            }
            if(!inputGood){
                System.out.print("Not a valid answer, please enter "+pleaseString+" ");
            }
        }
        return input2.toLowerCase();
    }

    public static int randomEvent(int firstChance, int secondChance, int thirdChance){
        int event = (int)(Math.random()*10)+1;
        if(1<=event && event<=firstChance){
            return 1;
        }
        else if(firstChance<event && event<=secondChance+firstChance){
            return 2;
        }
        else if(secondChance+firstChance<event && event<=thirdChance+secondChance+firstChance){
            return 3;
        }
        return -1;
    }

    public static void bigLine(){
        System.out.println("\n_____________________________________________________________________\n");
    }

    public static void bigSpace(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static Player user = new Player("DefaultName", 1, 15, 3, 0, 0, Tools.club, Tools.leather, Tools.crimson);
}