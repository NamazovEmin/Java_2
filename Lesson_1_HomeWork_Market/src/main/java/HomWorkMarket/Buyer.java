package HomWorkMarket;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Buyer extends User {
    List<Product> requiredShoppingList;
    List<Product> shoppedList;

    public Buyer(String name, String surname, int money, List<Product> requiredShoppingList, List<Product> shoppedList) {
        super(name, surname, money);
        this.requiredShoppingList = requiredShoppingList;
        this.shoppedList = shoppedList;
    }

    public void findAndBuyRequiredProductsInMarket(Market market) {
        for(Seller seller : market.sellerList) {
            for (Product requiredProduct : requiredShoppingList) {
                for (Product product : seller.productList)
                if (Objects.equals(product.getName(), requiredProduct.getName())
                        && product.getQuantity() >= requiredProduct.getQuantity()
                        && money >= product.getQuantity() * product.getPrice()) {
                    buyProduct(seller, requiredProduct, product);
                }
            }
        }
    }

    private void buyProduct(Seller seller, Product requiredProduct, Product product) {
        if (shoppedList.contains(requiredProduct)) {
            return;
        }

        product.setQuantity(product.getQuantity() - requiredProduct.getQuantity());
        seller.setMoney(seller.getMoney() + product.getPrice() * requiredProduct.getQuantity());
        setMoney(money - requiredProduct.getQuantity() * product.getPrice());

        shoppedList.add(requiredProduct);
    }
    public void findAndBuyRequiredProductsInMarketInCurrentSeller(Market market , String name, String surName) {
        for(Seller seller : market.sellerList) {
            if (Objects.equals(seller.name, name) && Objects.equals(seller.surname, surName)){
                for (Product requiredProduct : requiredShoppingList) {
                    for (Product product : seller.productList)
                        if (Objects.equals(product.getName(), requiredProduct.getName())
                                && product.getQuantity() >= requiredProduct.getQuantity()
                                && money >= product.getQuantity() * product.getPrice()) {
                            buyProduct(seller, requiredProduct, product);
                        }
                    }
                }
            }
        }

    public void choiceYourShopping (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите как вы хотите осуществить покупки");
        System.out.println("Введите 1, если вы хотите зайти к своему любимо продавцу");
        System.out.println("Введите 2, если вы хотите пройтись по всему рынку");
        int a = scanner.nextInt();
        if (a == 1){
            System.out.println("Введите имя продавца");
            String sellerName = scanner.next();

            System.out.println("Введите фамилию продавца");
            String surName = scanner.next();
            findAndBuyRequiredProductsInMarketInCurrentSeller(Main.createSellerList(), sellerName, surName );

        } else {
            findAndBuyRequiredProductsInMarket(Main.createSellerList());
        }


    }
}
