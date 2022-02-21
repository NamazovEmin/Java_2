package HomWorkMarket;

import java.util.List;

public class Market {
  List<Seller> sellerList;

  public Market(List<Seller> sellerList) {
    this.sellerList = sellerList;
  }

  public List<Seller> getSellerList() {
    return sellerList;
  }

  public void setSellerList(List<Seller> sellerList) {
    this.sellerList = sellerList;
  }
}
