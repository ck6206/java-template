import java.util.Scanner;
public class Main { 
    
    public static void main(String[] args) throws Exception {
        boolean what = false;
        Scanner nameScanner = new Scanner(System.in);System.out.print("Enter a name for your character: ");
        String name = nameScanner.nextLine();
        Tools.user.setName(name);
        int rooms = (int)(Math.random()*5)+7;

        //System.out.println(rooms);
        for(int p=1;p<=3;p++){
            for(int i=0;i<rooms;i++){
                move();
                int event  = Tools.randomEvent(7,0,3);
                if((event==1 && !what) || (what)){
                    Enemy goblin = new Enemy(Tools.enemyList[(int)(Math.random()*Tools.enemyList.length)],Tools.user.getLevel());
                    System.out.println("A "+Tools.red+goblin.getName()+Tools.reset+" jumps out at you. Initiating combat...");
                    Tools.timer(2);
                    combat(goblin);

                }
                else{
                    Tools.bigSpace();
                    Tools.bigLine();
                    System.out.println("You found a item.\n");
                    Tools.timer(2);
                    itemRoom();
                }
            }
            Tools.bigSpace();
            Tools.bigLine();
            System.out.println("Phase "+p+" Complete\n Congratulations!");
            Tools.timer(2);
            if(p!=3){
                System.out.println("Moving on in...");
                for(int i=1;i<=5;i++){
                    Tools.timer(i);
                    System.out.println(i);
                }
            }
            // System.out.println("You found a shopkeeper.\n");
            // Tools.timer(2);
            // Tools.bigSpace();
            // Tools.bigLine();
            // Shopkeeper s = new Shopkeeper();
            // s.talk();
            // Tools.timer(2);
            //put shop here
        }
        Tools.bigSpace();
        Tools.bigLine();
        System.out.println("You beat this very bad and unfinished boring game, good job!");
        Tools.bigLine();
    }

    public static void move(){
        Tools.bigSpace();
        String[] options = new String[3];
        String nOption=Tools.blue+"[N] "+"Go North "+Tools.reset+Tools.placeList[(int)(Math.random()*Tools.placeList.length)];
        String eOption=Tools.red+"[E] "+"Go East "+Tools.reset+Tools.placeList[(int)(Math.random()*Tools.placeList.length)];
        String sOption=Tools.yellow+"[S] "+"Go South "+Tools.reset+Tools.placeList[(int)(Math.random()*Tools.placeList.length)];
        String wOption=Tools.green+"[W] "+"Go West "+Tools.reset+Tools.placeList[(int)(Math.random()*Tools.placeList.length)];
        Tools.bigLine();
        System.out.println(Tools.user+"\n");
        Tools.user.seeInv();
        System.out.println("_____________________________________________________________________\n");
        if(Tools.user.opposite().equals("North")){
            options[0]="E";
            options[1]="S";
            options[2]="W";
            //options[3]="M";
            System.out.println("You come across a crossroad. Where do you want to go?\n\n"+eOption+"\n"+sOption+"\n"+wOption);
        }
        else if(Tools.user.opposite().equals("East")){
            options[0]="N";
            options[1]="S";
            options[2]="W";
            //options[3]="M";
            System.out.println("You come across a crossroad. Where do you want to go?\n\n"+nOption+"\n"+sOption+"\n"+wOption);
        }
        else if(Tools.user.opposite().equals("South")){
            options[0]="N";
            options[1]="E";
            options[2]="W";
            //options[3]="M";
            System.out.println("You come across a crossroad. Where do you want to go?\n\n"+nOption+"\n"+eOption+"\n"+wOption);
        }
        else if(Tools.user.opposite().equals("West")){
            options[0]="N";
            options[1]="S";
            options[2]="E";
            //options[3]="M";
            System.out.println("You come across a crossroad. Where do you want to go?\n\n"+nOption+"\n"+eOption+"\n"+sOption);
        }
        //System.out.println(Tools.purple+"[M]"+Tools.reset+" Check your "+Tools.purple+"Player Status "+Tools.reset+"and "+Tools.yellow+"Inventory\n"+Tools.reset);
        System.out.print("Enter choice here: ");
        String moveChoice = Tools.checkInput(options);
        
        if (moveChoice.equals("n")){
            Tools.user.setRecentDirection("North");
            System.out.println("You moved North \n");
        }
        else if (moveChoice.equals("s")){
            Tools.user.setRecentDirection("South");
            System.out.println("You moved South \n");
        }
        else if (moveChoice.equals("e")){
            Tools.user.setRecentDirection("East");
            System.out.println("You moved East \n");
        }
        else if (moveChoice.equals("w")){
            Tools.user.setRecentDirection("West");
            System.out.println("You moved West \n");
        }
    }

    public static void combat(Enemy goblin){
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        int choice = 0;
        boolean gameLoop = true;
        while(gameLoop == true){
            Tools.bigSpace();
            Tools.bigLine();
            if(round==1){
                System.out.println("You encountered a "+Tools.yellow+goblin.getName()+Tools.reset+":");
            }
            else{
                System.out.println("Round "+Tools.yellow+round+Tools.reset);
            }
            System.out.println("\n"+Tools.user+"\n\n"+goblin+"\n");
            Tools.bigLine();

            System.out.println("What would you like to do?");
            System.out.println(Tools.red+"[1]"+Tools.reset+" Use "+Tools.red+Tools.user.getInv()[0].getName()+Tools.reset+" to"+Tools.red+" attack"+Tools.reset);
            System.out.println(Tools.green+"[2]"+Tools.reset+" Drink a "+Tools.green+Tools.user.getInv()[2].getName()+Tools.reset+" ("+Tools.green+Tools.crimson.getFlasks()+Tools.reset+" uses left)");
            System.out.println(Tools.blue+"[3]"+Tools.reset+Tools.blue+" Flee"+Tools.reset+" from the encounter");
            System.out.print("Enter Choice Here: ");
            
            while(true){
                try{
                    choice = scanner.nextInt();
                    while((choice==2 && Tools.crimson.getFlasks()==0) || (choice != 1 && choice !=2 && choice != 3)){
                        if(choice==2 && Tools.crimson.getFlasks()==0){
                            System.out.println("You have no flasks left! Please select a different option: ");
                        }
                        else{
                            System.out.println("Not a valid choice! Please select 1, 2, or 3: ");
                        }
                        choice = scanner.nextInt();
                    }     
                    break;
                }
                catch (Exception e){
                    System.out.println("Not a valid choice! Please select 1, 2, or 3.");
                    scanner.next();
                }
            }
            
            if(choice == 1){
                Tools.user.attack(goblin);
                if(goblin.getDead()){
                    break;
                }
            }

            if(choice == 2){
                Tools.user.drink();
            }

            if(choice == 3){
                int random = (int)(Math.random()*9+1);
                if(random>2){
                    Tools.timer(1);
                    System.out.println("You got away safely!");
                    Tools.timer(2);
                    break;
                }
                else{
                    Tools.timer(1);
                    System.out.println("You couldn't escape!");
                    Tools.timer(2);
                }
            }

            if(gameLoop==true){
                System.out.println("\n"+goblin.getName()+"'s turn:");
                Tools.timer(2);
                goblin.attack(Tools.user);
                Tools.timer(2);
                round++;
            }
        }
    }

    public static void itemRoom(){
        int wOa=(int)(Math.random()*100)+1;
        boolean w=false;
        boolean a=false;
        if(wOa<=60){
            w=true;
        }
        else{
            a=true;
        }
        if(w){
            Weapon weap;
            int randDex=(int)(Math.random()*100)+1;
            System.out.println(randDex);
            if(randDex<=65){
                weap=Tools.simple[(int)(Math.random()*Tools.simple.length)];
            }
            else{
                weap=Tools.martial[(int)(Math.random()*Tools.martial.length)];
            }
            Tools.user.changeWeapon(weap);
        }
        else{
            Armor arm;
            int randDex=(int)(Math.random()*100)+1;
            System.out.println(randDex);
            if(randDex<=50){
                arm=Tools.light[(int)(Math.random()*Tools.light.length)];
            }
            else if(randDex<=80){
                arm=Tools.medium[(int)(Math.random()*Tools.medium.length)];
            }
            else{
                arm=Tools.heavy[(int)(Math.random()*Tools.heavy.length)];
            }
            Tools.user.changeArmor(arm);
        }
    }
}
