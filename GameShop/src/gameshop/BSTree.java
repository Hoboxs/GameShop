package gameshop;

public class BSTree {
    private ShopItemNode root;

    public BSTree(){
        root=null;
    }

    public ShopItem get(String key)
    {
        if(exist(key)) {
            return search(key);
        }
        else{
            return null;
        }
    }

    public void deleteKey(String key)
    {
        root = deleteRec(root, key);
    }

    public ShopItemNode deleteRec(ShopItemNode root, String key)
    {
        if (root == null)  {
            System.out.println(key + " has not been deleted");
            return root;
        }

        if (root.data.item.weaponName.compareTo(key) > 0)
            root.left = deleteRec(root.left, key);
        else if (root.data.item.weaponName.compareTo(key) < 0)
            root.right = deleteRec(root.right, key);
        else
        {
            if (root.left == null) {
                System.out.println(key + " has been deleted");
                return root.right;
            }
            else if (root.right == null) {
                System.out.println(key + " has been deleted");
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data.item.weaponName);
        }
        System.out.println(key + " has been deleted");
        return root;
    }

    public ShopItem minValue(ShopItemNode root)
    {
        ShopItem minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public boolean exist(String key){
        if (root==null){
            return false;
        }
        ShopItemNode curr=root;
        while (curr!=null && !curr.data.item.weaponName.equals(key)){
            if (curr.data.item.weaponName.compareTo(key) > 0){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        if (curr==null){
            return false;
        }
        return true;
    }

    public ShopItem search(String key){
        ShopItemNode curr=root;
        while (curr!=null && !curr.data.item.weaponName.equals(key)){
            if (curr.data.item.weaponName.compareTo(key) > 0){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        return curr.data;
    }

    public void put(Weapon item,int quantity){
        ShopItemNode newNode = new ShopItemNode(new ShopItem(item,quantity));
        if (root == null){
            root=newNode;
            return;
        }

        ShopItemNode parent,current;
        current=parent=root;
        while (current!=null){
            parent=current;
            if (current.data.item.weaponName.compareTo(newNode.data.item.weaponName) > 0){
                current=current.left;
            }else{
                current=current.right;
            }
        }
        if (parent.data.item.weaponName.compareTo(newNode.data.item.weaponName) > 0){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
    }

    public void printTable(){
        recInOrder(root);
        System.out.println("");
    }

    public void recInOrder(ShopItemNode curr){
        if (curr!=null){
            recInOrder(curr.left);
            if(curr.data.numberInStock > 0) {
                System.out.println("Name: " + curr.data.item.weaponName + "   Damage:" + curr.data.item.damage + "    Cost:" + curr.data.item.cost + "     Quantity in stock:" + curr.data.numberInStock);
            }
            recInOrder(curr.right);
        }
    }
}
