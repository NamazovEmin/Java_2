package HomWorkMarket;

import java.util.List;

public class Seller extends User{
    List<Product> productList;

    public Seller(String name, String surname, int money, List<Product> productList) {
        super(name, surname, money);
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
