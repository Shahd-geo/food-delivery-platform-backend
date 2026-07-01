package com.fooddelivery.Utils;

import java.time.LocalTime;

public class HelperUtils {
    public static String generateCode(String prefix) {
        int randomNumber = (int) (Math.random() * 9000) + 1000;

        return prefix + "-" + randomNumber;
    }
    public static String generateCode(String prefix, int length) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            code.append((int)(Math.random() * 10));
        }
        return prefix + "-" + code;
    }
    // Calculate Distance
    // Distance in kilometers (Haversine Formula)
    public static double calculateDistance(
            double lat1,
            double lng1,
            double lat2,
            double lng2) {

        final double EARTH_RADIUS = 6371; // km

        double latDistance = Math.toRadians(lat2 - lat1);
        double lngDistance = Math.toRadians(lng2 - lng1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(lngDistance / 2)
                * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
    // Calculate Total
    public static double calculateTotal(
            double subtotal,
            double fee) {

        return subtotal + fee;
    }

    // Calculate Total with Discount
    public static double calculateTotal(
            double subtotal,
            double fee,
            double discount) {

        return subtotal + fee - discount;
    }

    // Format Currency
    public static String formatCurrency(double amount) {
        return String.format("OMR %.2f", amount);
    }

    public static String formatCurrency(
            double amount,
            String currencyCode) {

        return String.format("%s %.2f", currencyCode, amount);
    }
    // Business Open or Not
    public static boolean isBusinessOpen(
            String openTime,
            String closeTime) {

        LocalTime open = LocalTime.parse(openTime);
        LocalTime close = LocalTime.parse(closeTime);
        LocalTime now = LocalTime.now();

        return !now.isBefore(open)
                && !now.isAfter(close);
    }
}
