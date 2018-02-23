package lesson16.atHome.ex5;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by student on 11.02.2018.
 */
public class Shop {
    public static void main(String[] args) {
        Set<Product> products1 = new TreeSet<>();
        products1.add(new Product("Dress", 1001.2, 4));
        products1.add(new Product("Anorak", 1001.25, 5));
        products1.add(new Product("T-Shirt", 1212.5, 5));
        Category category = new Category("Cloths", products1);
        Set<Product> products2 = new TreeSet<>(new ProductComparatorName());
        products2.addAll(products1);
        printProducts(products1);
        System.out.println();
        printProducts(products2);
        System.out.println();
        Set<Product> products3 = new TreeSet<>(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() - o2.getPrice() > 0) {
                    return 1;
                } else if (o1.getPrice() - o2.getPrice() < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        );
        products3.addAll(products1);
        printProducts(products3);
    }

    private static void printProducts(Set<Product> products) {
        products.forEach(System.out::println);
    }
}
