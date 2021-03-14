package gameshop;

public class BackpackNode {

    public Weapon data;
    public BackpackNode next;

    public BackpackNode(Weapon d){
        data = d;
        next=null;
    }
}
