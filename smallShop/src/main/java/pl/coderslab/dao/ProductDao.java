package pl.coderslab.dao;

import pl.coderslab.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private List<Product> products;

    public ProductDao() {
        products = new ArrayList<>();
        //wypelniamy produkty
        products.add(new Product(1L,"Produkt 1","Opis 1",22.5f));
        products.add(new Product(2L,"Produkt 2","Opis 2",12.5f));
        products.add(new Product(3L,"Produkt 3","Opis 3",23.5f));
        products.add(new Product(4L,"Produkt 4","Opis 4",22.99f));
        products.add(new Product(5L,"Produkt 5","Opis 5",11.95f));
        products.add(new Product(6L,"Produkt 6","Opis 6",20.19f));
    }

    public List<Product> getProducts() {
        return products;
    }
    public Product findProduct(Long id){
        for(Product product:products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
}
