package gameshop;

public class ShopItemNode {
    public ShopItem data;
    public ShopItemNode left;
    public ShopItemNode right;

    public ShopItemNode(ShopItem data){
        this.data = data;
        left=right=null;
    }
}
