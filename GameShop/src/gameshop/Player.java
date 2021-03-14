package gameshop;

class Player
    {
        public String name;
        public Backpack backpack;
        public int numItems;
        public double money;

        public Player(String n, double m)
        {
            name = n;
            money = m;
            numItems = 0;
            backpack = new Backpack(10);
        }

        public void buy(Weapon w)
        {
            System.out.println(w.weaponName+" bought...");
            if(backpack.add(w)){
                System.out.println(w.weaponName+" has been bought and added to the backpack");
                numItems++;
            }
            else{
                System.out.println("The weight of " + w.weaponName + " will exceed the backpack limit");
            }
        }
        public void withdraw(double amt)
        {
            money = money - amt;
        }

        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }

        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }

        public void printBackpack()
        {
            System.out.println(" "+name+", you own "+numItems+" Weapons:");
            System.out.println(backpack.toString());
            System.out.println();
        }
    }
