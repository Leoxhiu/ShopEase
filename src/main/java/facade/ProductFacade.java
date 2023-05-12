package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Product;

import java.util.List;

@Stateless (name = "ProductFacade")
@LocalBean
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeI {
    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public boolean createProduct(Product product) {
        try{
            this.create(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editProduct(Product product) {
        try{
            this.edit(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeProduct(Product product) {
        this.remove(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return this.findAll();
    }

    @Override
    public List<Product> getRangeProduct(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Product getProductById(String id) {
        return this.find(id);
    }

    @Override
    public int countProduct() {
        return this.count();
    }

    @Override
    public List<Product> getAllActiveProduct() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.isDeleted = false", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllActiveProductBySellerId(String sellerId) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.isDeleted = false AND p.seller.id = :sellerId", Product.class);
        query.setParameter("sellerId", sellerId);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllActiveProductBySellerIdANDSearchTerm(String sellerId, String searchTerm) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE (LOWER(p.category) LIKE LOWER(:searchTerm) " +
                        "OR LOWER(p.name) LIKE LOWER(:searchTerm) OR LOWER(p.description) LIKE LOWER(:searchTerm)) " +
                        "AND p.isDeleted = false AND p.seller.id = :sellerId", Product.class);
        query.setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%");
        query.setParameter("sellerId", sellerId);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllActiveProductBySellerIdANDFilter(String sellerId, String[] selectedCategories, String priceOrder, String[] selectedDiscounts, String[] selectedRatings) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT p FROM Product p WHERE p.isDeleted = false AND p.seller.id = :sellerId");

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

    @Override
    public List<Product> getAllAvailableProduct() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.isDeleted = false AND p.quantity > 0", Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> getAllAvailableProductWithSearchTerm(String searchTerm) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE (LOWER(p.category) LIKE LOWER(:searchTerm) " +
                        "OR LOWER(p.name) LIKE LOWER(:searchTerm) OR LOWER(p.description) LIKE LOWER(:searchTerm)) " +
                        "AND p.isDeleted = false AND p.quantity > 0", Product.class);
        query.setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%");
        return query.getResultList();
    }

    @Override
    public List<Product> getAllAvailableProductByFilter(String[] selectedCategories, String priceOrder, String[] selectedDiscounts, String[] selectedRatings) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT p FROM Product p WHERE p.isDeleted = false AND p.quantity > 0");

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
}
