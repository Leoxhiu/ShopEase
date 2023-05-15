package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Product;
import model.Seller;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import java.text.DecimalFormat;
import java.util.List;

@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    public ProductFacade() {
        super(Product.class);
    }

    public boolean createProduct(Product product) {
        try{
            this.create(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editProduct(Product product) {
        try{
            this.edit(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeProduct(Product product) {
        this.remove(product);
    }

    public List<Product> getAllProduct() {
        return this.findAll();
    }

    public List<Product> getRangeProduct(int[] range) {
        return this.findRange(range);
    }

    public Product getProductById(String id) {
        return this.find(id);
    }

    public int countProduct() {
        return this.count();
    }

    public int countProductsByRating(int rating) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.rating = :rating", Long.class);
        query.setParameter("rating", rating);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        Long count = query.getSingleResult();
        return count.intValue();
    }

    public List<Product> getTopRatedProducts(int limit) {
        TypedQuery<Product> query = super.em.createQuery(
                "SELECT p " +
                        "FROM Product p " +
                        "ORDER BY p.rating DESC", Product.class);
        query.setMaxResults(limit);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllActiveProduct() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.isDeleted = 0", Product.class);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllProductBySeller(Seller seller) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.seller = :seller", Product.class);
        query.setParameter("seller", seller);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllActiveProductBySeller(Seller seller) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.isDeleted = 0 AND p.seller = :seller", Product.class);
        query.setParameter("seller", seller);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllActiveProductBySellerIdANDSearchTerm(String sellerId, String searchTerm) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE (LOWER(p.category) LIKE LOWER(:searchTerm) " +
                        "OR LOWER(p.name) LIKE LOWER(:searchTerm) OR LOWER(p.description) LIKE LOWER(:searchTerm)) " +
                        "AND p.isDeleted = 0 AND p.seller.id = :sellerId", Product.class);
        query.setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%");
        query.setParameter("sellerId", sellerId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllActiveProductBySellerIdANDFilter(String sellerId, String[] selectedCategories, String priceOrder, String[] selectedDiscounts, String[] selectedRatings) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT p FROM Product p WHERE p.isDeleted = 0 AND p.seller.id = :sellerId");

        // Add the selected categories condition
        if (selectedCategories != null && selectedCategories.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedCategories.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" p.category = :category").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the selected discounts condition
        if (selectedDiscounts != null && selectedDiscounts.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedDiscounts.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" p.discount > :discount").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the selected ratings condition
        if (selectedRatings != null && selectedRatings.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedRatings.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" p.rating >= :rating").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the price ordering condition
        if (priceOrder != null && !priceOrder.isEmpty()) {
            if (priceOrder.equals("lowToHigh")) {
                queryBuilder.append(" ORDER BY p.discountedPrice ASC");
            } else if (priceOrder.equals("highToLow")) {
                queryBuilder.append(" ORDER BY p.discountedPrice DESC");
            }
        }

        TypedQuery<Product> query = em.createQuery(queryBuilder.toString(), Product.class);
        query.setParameter("sellerId", sellerId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        // Set the parameter values for selected categories
        if (selectedCategories != null && selectedCategories.length > 0) {
            for (int i = 0; i < selectedCategories.length; i++) {
                query.setParameter("category" + i, selectedCategories[i]);
            }
        }

        // Set the parameter values for selected discounts
        if (selectedDiscounts != null && selectedDiscounts.length > 0) {
            for (int i = 0; i < selectedDiscounts.length; i++) {
                int discountValue = Integer.parseInt(selectedDiscounts[i]);
                query.setParameter("discount" + i, discountValue);
            }
        }

        // Set the parameter values for selected ratings
        if (selectedRatings != null && selectedRatings.length > 0) {
            for (int i = 0; i < selectedRatings.length; i++) {
                int ratingValue = Integer.parseInt(selectedRatings[i]);
                query.setParameter("rating" + i, ratingValue);
            }
        }
        return query.getResultList();
    }

    public List<Product> getAllAvailableProduct() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.isDeleted = 0 AND p.quantity > 0", Product.class);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllAvailableProductWithSearchTerm(String searchTerm) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE (LOWER(p.category) LIKE LOWER(:searchTerm) " +
                        "OR LOWER(p.name) LIKE LOWER(:searchTerm) OR LOWER(p.description) LIKE LOWER(:searchTerm)) " +
                        "AND p.isDeleted = 0 AND p.quantity > 0", Product.class);
        query.setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%");
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Product> getAllAvailableProductByFilter(String[] selectedCategories, String priceOrder, String[] selectedDiscounts, String[] selectedRatings) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT p FROM Product p WHERE p.isDeleted = 0 AND p.quantity > 0");

        // Add the selected categories condition
        if (selectedCategories != null && selectedCategories.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedCategories.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" p.category = :category").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the selected discounts condition
        if (selectedDiscounts != null && selectedDiscounts.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedDiscounts.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" p.discount > :discount").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the selected ratings condition
        if (selectedRatings != null && selectedRatings.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedRatings.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" p.rating >= :rating").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the price ordering condition
        if (priceOrder != null && !priceOrder.isEmpty()) {
            if (priceOrder.equals("lowToHigh")) {
                queryBuilder.append(" ORDER BY p.discountedPrice ASC");
            } else if (priceOrder.equals("highToLow")) {
                queryBuilder.append(" ORDER BY p.discountedPrice DESC");
            }
        }

        TypedQuery<Product> query = em.createQuery(queryBuilder.toString(), Product.class);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        // Set the parameter values for selected categories
        if (selectedCategories != null && selectedCategories.length > 0) {
            for (int i = 0; i < selectedCategories.length; i++) {
                query.setParameter("category" + i, selectedCategories[i]);
            }
        }

        // Set the parameter values for selected discounts
        if (selectedDiscounts != null && selectedDiscounts.length > 0) {
            for (int i = 0; i < selectedDiscounts.length; i++) {
                int discountValue = Integer.parseInt(selectedDiscounts[i]);
                query.setParameter("discount" + i, discountValue);
            }
        }

        // Set the parameter values for selected ratings
        if (selectedRatings != null && selectedRatings.length > 0) {
            for (int i = 0; i < selectedRatings.length; i++) {
                int ratingValue = Integer.parseInt(selectedRatings[i]);
                query.setParameter("rating" + i, ratingValue);
            }
        }
        return query.getResultList();
    }

    public boolean update(String productId, byte[] image, String name, String description, double price, int quantity, String category, int discount){

        Product product = getProductById(productId);

        product.setImage(image);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setDiscount(discount);
        double discountedPrice = findDiscountedPrice(price, discount);
        product.setDiscountedPrice(discountedPrice);

        return editProduct(product);
    }

    public boolean updateRating(String productId, int rating){

        Product product = getProductById(productId);
        product.setRating(rating);
        return editProduct(product);
    }

    public boolean minusQuantity(String id, int quantity){

        Product product = getProductById(id);
        int newQuantity = product.getQuantity() - quantity;

        product.setQuantity(newQuantity);
        return editProduct(product);
    }

    public double findDiscountedPrice(double price, int discount) {
        double discountedPrice = price - (price * discount / 100);

        // Format the discounted price to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedDiscountedPrice = decimalFormat.format(discountedPrice);

        // Parse the formatted string back to double
        discountedPrice = Double.parseDouble(formattedDiscountedPrice);

        return discountedPrice;
    }

    public boolean delete(String id) {
        Product product = getProductById(id);
        product.setDeleted(1);
        return editProduct(product);
    }

    public boolean isValidNameLength(String name) {
        int minLength = 2;
        int maxLength = 100;

        return name.length() >= minLength && name.length() <= maxLength;
    }

    public boolean isValidDescription(String description) {
        int minLength = 10;

        return description.length() >= minLength;
    }

    public boolean isValidPrice(double price) {
        return price > 0 ;
    }

    public boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    public boolean isValidDiscount(int discount) {
        int minDiscount = 0;
        int maxDiscount = 95;

        return discount >= minDiscount && discount <= maxDiscount;
    }
}
