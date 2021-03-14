package gameshop;

class Backpack
{
    double maxWeight;
    double presentWeight;
    BackpackNode head;

    public Backpack(int maxWeight){
        this.maxWeight = maxWeight;
        presentWeight = 0;
        head=null;
    }

    public boolean add(Weapon k){
        BackpackNode n = new BackpackNode(k);
        if(n.data.weight + presentWeight > maxWeight) return false;
        if (head==null){//case 1
            head= n;
            return true;
        }
        BackpackNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=n;
        return true;
    }


    public String toString(){
        String s="";
        BackpackNode curr=head;
        while (curr!=null){
            s = s + curr.data.weaponName + "\n";
            curr = curr.next;
        }
        return s;
    }

}
