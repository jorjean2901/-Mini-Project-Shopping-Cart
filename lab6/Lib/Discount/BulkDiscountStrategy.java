package Lib.Discount;
import Lib.*;

/**
 * กลยุทธ์ส่วนลด Bulk (ยิ่งซื้อเยอะลดราคา)
 */

public class BulkDiscountStrategy implements DiscountStrategy {
    private final int minimumQauntity;
    private final double discountPercentage;

    public BulkDiscountStrategy(int minimumQauntity, double discountPercentage){
        this.minimumQauntity = minimumQauntity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item) {
        double originalPrice = item.getProduct().getPrice()*item.getQuantity();
        if(item.getQuantity() >= minimumQauntity){
            return originalPrice * (1.0 - discountPercentage);
        }
        return originalPrice ;
    }
}
