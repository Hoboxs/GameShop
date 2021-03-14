package gameshop;

import java.util.Scanner;

public class GameShop {

    public static int getInteger(Scanner sc, String message) {
        int n = 0;
        while (true) {
            try {
                System.out.print(message);
                n = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
            }
        }
        return n;
    }

    public static double getDouble(Scanner sc, String message) {
        double n = 0;
        while (true) {
            try {
                System.out.print(message);
                n = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {

            }
        }

        return n;
    }


    public static void addWeapons(BSTree h, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName;
        int weaponRange;
        int weaponDamage;
        double weaponWeight;
        double weaponCost;
        int quantity;
        System.out.print("Please enter the NAME of the Weapon: ");
        weaponName = sc.nextLine();
        System.out.println(weaponName);
        weaponRange = getInteger(sc, "Please enter the Range of the Weapon (0-10):");
        weaponDamage = getInteger(sc, "Please enter the Damage of the Weapon:");
        weaponWeight = getDouble(sc, "Please enter the Weight of the Weapon (in pounds):");
        weaponCost = getDouble(sc, "Please enter the Cost of the Weapon:");
        Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
        quantity = getInteger(sc, "Please enter the quantity in stock:");
        h.put(w, quantity);

        System.out.println("\n" + weaponName + " has been created!\n");
    }

    public static void showRoomMenu(BSTree ht, Player p) {
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        ht.printTable();
        System.out.println("You have " + p.money + " money.");
        System.out.println("Please select a weapon to buy: ");
    }

    public static void showRoom(BSTree ht, Player p, Scanner sc) {
        String choice;
        showRoomMenu(ht, p);
        choice = sc.nextLine();
        if (!p.inventoryFull()) {
            ShopItem si = ht.get(choice);
            if (si != null) {
                if (si.item.cost > p.money) {
                    System.out.println("Insufficient funds to buy " + si.item.weaponName);
                } else {
                    p.buy(si.item);
                    p.withdraw(si.item.cost);
                    si.numberInStock--;
                }
            } else {
                System.out.println(" ** " + choice + " not found!! **");
            }
        }
        System.out.println("");
    }

    public static void deleteWeapon(BSTree h, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON DELETING MENU*********");
        String weaponName;
        System.out.print("Please enter the NAME of the Weapon: ");
        weaponName = sc.nextLine();
        h.deleteKey(weaponName);
    }

    public static void showMenu() {
        System.out.println("1. Add Items to the shop");
        System.out.println("2. Delete Items from the shop ");
        System.out.println("3. Buy from the Shop");
        System.out.println("4. View backpack");
        System.out.println("5. View Player");
        System.out.println("6. Exit");
    }

    public static void getChoice(BSTree ht, Player pl, Scanner sc) {
        String choice = "";
        while (!choice.equals("6")) {
            showMenu();
            choice = sc.next();
            sc.nextLine();
            switch (choice) {
                case "1":
                    addWeapons(ht, sc);
                    break;
                case "2":
                    deleteWeapon(ht, sc);
                    break;
                case "3":
                    showRoom(ht, pl, sc);
                    break;
                case "4":
                    pl.printBackpack();
                    break;
                case "5":
                    pl.printCharacter();
                    break;
                case "6":
                    //Exit
                    break;
                default:
                    System.out.println("Please print a valid number");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pname;
        System.out.println("Please enter Player name:");
        pname = sc.nextLine();
        Player pl = new Player(pname, 45);
        BSTree ht = new BSTree();
        getChoice(ht, pl, sc);
    }
}
