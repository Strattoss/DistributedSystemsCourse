package sr.grpc.server;

import sr.grpc.gen.Offer;
import sr.grpc.gen.OfferFilter;

public class OfferFilterMatcher {
    /**
     * Check if the offer matches the filter criteria
     */
    public static boolean matches(OfferFilter offerFilter, Offer offer) {
        double offerPrice = calculateUnitPrice(offer);

        if (!offerFilter.getCategoriesList().isEmpty() &&
                !offerFilter.getCategoriesList().contains(offer.getCategory().name())) {
                return false;
        }

        if (offerFilter.hasMinimalPrice() &&
                offerPrice < offerFilter.getMinimalPrice()) {
            return false;
        }

        if (offerFilter.hasMaximalPrice() &&
                offerPrice > offerFilter.getMaximalPrice()) {
            return false;
        }

        if (offerFilter.hasMinimalAvailableAmount() &&
                offer.getAvailableAmount() < offerFilter.getMinimalAvailableAmount()) {
            return false;
        }

        if (offerFilter.hasMaximalAvailableAmount() &&
                offer.getAvailableAmount() > offerFilter.getMaximalAvailableAmount()) {
            return false;
        }

        return true;
    }

    public static double calculateUnitPrice(Offer offer) {
        return offer.getPriceIntegerPart() + (double) offer.getPriceDecimalPart() / 100;
    }
}
