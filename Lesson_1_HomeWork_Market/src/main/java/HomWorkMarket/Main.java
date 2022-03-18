package HomWorkMarket;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Buyer buyer = createBuyer();
        buyer.choiceYourShopping();
        System.out.println(buyer.requiredShoppingList);
        DataBase dataBase = DataBase.getInstance();
        dataBase.createTableShoppedProductList();
        dataBase.InsertProductInTableProductInDataBase(buyer);
        dataBase.selectFrom();
        dataBase.deleteTableShoppedProduct();
    }


    public static Market createSellerList() {
       return new Market(List.of(createFirstSeller(),createSecondSeller()));
    }

    public static Seller createFirstSeller() {

        return  new Seller("Vasiliy", "Ivanov", 500, List.of(createFirstProduct(),createSecondProduct()));

    }

    public static Seller createSecondSeller() {


        return new Seller("Boris", "Victorovich", 500, List.of(createThirdProduct(),createFourthProduct()));
    }

    public static Product createFirstProduct() {
        return new Product(MarketConstants.TOMATO_PRODUCT_NAME, 5, 50);
    }

    public static Product createSecondProduct() {
        return new Product(MarketConstants.POTATO_PRODUCT_NAME, 5, 50);
    }

    public static Product createThirdProduct() {
        return  new Product(MarketConstants.TOMATO_PRODUCT_NAME, 8, 20);
    }

    public static Product createFourthProduct() {
        return new Product(MarketConstants.POTATO_PRODUCT_NAME, 2, 1);
    }

    public static Buyer createBuyer() {

        return new Buyer("Vladimir", "Vladimirovich", 500, List.of(createBuyerFirstProduct(),createBuyerSecondProduct()), new ArrayList());
    }

    public static Product createBuyerFirstProduct() {
        return new Product(MarketConstants.TOMATO_PRODUCT_NAME, 0, 3);
    }

    public static Product createBuyerSecondProduct() {
        return new Product(MarketConstants.POTATO_PRODUCT_NAME, 0, 5);
    }

}
