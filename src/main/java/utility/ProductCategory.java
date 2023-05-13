package utility;

public enum ProductCategory {
    ELECTRONICS("ETR", "Electronics"),
    CLOTHING("CLT","Clothing"),
    BEAUTY("BTY","Beauty"),
    HOME_AND_KITCHEN("HAK","Home & Kitchen"),
    SPORTS_AND_OUTDOORS("SAO","Sports & Outdoors"),
    BOOKS_AND_MEDIA("BAM","Books & Media");

    private final String categoryCode;
    private final String categoryName;

    ProductCategory(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public String getCategoryCode() {
        return categoryName;
    }
}
