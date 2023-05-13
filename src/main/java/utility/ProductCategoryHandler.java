package utility;

public class ProductCategoryHandler {

    public static String getCategoryName(String categoryCode) {
        switch (categoryCode) {
            case "ETR":
                return ProductCategory.ELECTRONICS.getCategoryName();
            case "CLT":
                return ProductCategory.CLOTHING.getCategoryName();
            case "BTY":
                return ProductCategory.BEAUTY.getCategoryName();
            case "HAK":
                return ProductCategory.HOME_AND_KITCHEN.getCategoryName();
            case "SAO":
                return ProductCategory.SPORTS_AND_OUTDOORS.getCategoryName();
            case "BAM":
                return ProductCategory.BOOKS_AND_MEDIA.getCategoryName();
            default:
                return "Unknown Category";
        }
    }
}
