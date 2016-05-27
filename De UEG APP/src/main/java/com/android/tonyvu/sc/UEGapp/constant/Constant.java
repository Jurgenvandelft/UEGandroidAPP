package com.android.tonyvu.sc.UEGapp.constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.android.tonyvu.sc.UEGapp.model.Product;

public final class Constant {
    public static final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

    static {
        for (int i = 1; i < 14; i++) QUANTITY_LIST.add(i);
    }

    public static final Product PRODUCT1 = new Product(1, "Millers Juice Liquid - Caribbean Rum Sauce", BigDecimal.valueOf(5.59), "Een donkere tobacco vooraan, daarna het zoete van de bruine rum met een afdronk van echte vanille. Deze combinatie is intens, vol en zelfs een beetje romig. Hou je van zoet en hou je van vanille, dan is deze liquid spot-on!");
    public static final Product PRODUCT2 = new Product(2, "Millers Juice Liquid - Best Bam Buddhapest", BigDecimal.valueOf(5.59), "Basma Tabaksbladeren uit Xanthi. Een lichtere tabaksmaak gemixt met donkere Argos bladeren. Perfect als je zoekt naar iets nieuws met de robuuste smaak van sigaretten. Met deze tabaksblend denk je terug aan de donkere variété theaters in de oost-europese landen. Rokerig, houterig en een verassende fruitige smaak op de “afdronk”.");
    public static final Product PRODUCT3 = new Product(3, "Millers Juice Liquid - Turkish blend tabak", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT4 = new Product(4, "Millers Juice limonade / citroen e-liquid", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT5 = new Product(5, "Millers Juice red candy e-liquid", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT6 = new Product(6, "Millers Juice kokos e-liquid", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT7 = new Product(7, "Millers Juice watermeloen e-liquid", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT8 = new Product(8, "Millers Juice groene appel e-liquid", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT9 = new Product(9, "Millers Juice aadbei e-liquid", BigDecimal.valueOf(2.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT10 = new Product(10, "Millers Juice Liquid - Watermeloen", BigDecimal.valueOf(99.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT11 = new Product(11, "Millers Juice Liquid - Framboos", BigDecimal.valueOf(99.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT12 = new Product(12, "Millers Juice Liquid - Banaan", BigDecimal.valueOf(99.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT13 = new Product(13, "Millers Juice Liquid - Ananas", BigDecimal.valueOf(99.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");
    public static final Product PRODUCT14 = new Product(14, "Millers Juice Liquid - Fruitmix", BigDecimal.valueOf(99.95), "Verkrijgbaar in 0, 6, 12 en 18mg nicotine.");

    public static final List<Product> PRODUCT_LIST = new ArrayList<Product>();

    static {
        PRODUCT_LIST.add(PRODUCT1);
        PRODUCT_LIST.add(PRODUCT2);
        PRODUCT_LIST.add(PRODUCT3);
        PRODUCT_LIST.add(PRODUCT4);
        PRODUCT_LIST.add(PRODUCT5);
        PRODUCT_LIST.add(PRODUCT6);
        PRODUCT_LIST.add(PRODUCT7);
        PRODUCT_LIST.add(PRODUCT8);
        PRODUCT_LIST.add(PRODUCT9);
        PRODUCT_LIST.add(PRODUCT10);
        PRODUCT_LIST.add(PRODUCT11);
        PRODUCT_LIST.add(PRODUCT12);
        PRODUCT_LIST.add(PRODUCT13);
        PRODUCT_LIST.add(PRODUCT14);
    }
}
