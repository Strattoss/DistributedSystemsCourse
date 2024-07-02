package sr.grpc.server;

import sr.grpc.gen.Category;
import sr.grpc.gen.Offer;

import java.util.Collections;
import java.util.Random;

public class RandomOfferGenerator {
    static private final String[] titles = new String[] {"Title 1", "Title 2", "Title 3", "Title 4", "Title 5"};
    static private final String[] descriptions = new String[] {"Description 1", "Description 2", "Description 3", "Description 4"};

    static private int lastOfferId = 0;

    static private final Random rand = new Random();

    public static Offer generateOffer() {
        int titleIndex = rand.nextInt(titles.length);
        int categoryIndex = rand.nextInt(Category.values().length - 1);
        int descriptionIndex = rand.nextInt(descriptions.length);

        lastOfferId++;

        return Offer.newBuilder()
                .setOfferId(lastOfferId)
                .setTitle(titles[titleIndex])
                .setCategory(Category.forNumber(categoryIndex))
                .setDescription(descriptions[descriptionIndex])
                .setPriceIntegerPart(rand.nextInt(999))
                .setPriceDecimalPart(rand.nextInt(100))
                .setAvailableAmount(rand.nextInt(50))
                .build();
    }
}
