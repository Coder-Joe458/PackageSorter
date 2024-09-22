public class PackageSorter {

    // Constants for bounds checking
    private static final long MAX_INT = (long) Integer.MAX_VALUE; // Max allowable int value
    private static final int MIN_VALID_DIMENSION = 0;
    private static final int MIN_VALID_MASS = 0;

    public static String sort(long width, long height, long length, long mass) {
        // Input validation: Check for valid dimension and mass values
        if (width < MIN_VALID_DIMENSION || height < MIN_VALID_DIMENSION ||
                length < MIN_VALID_DIMENSION || mass < MIN_VALID_MASS) {
            throw new IllegalArgumentException("Dimensions and mass must be non-negative.");
        }

        if (width > MAX_INT || height > MAX_INT || length > MAX_INT || mass > MAX_INT) {
            throw new IllegalArgumentException("Dimensions and mass must not exceed the maximum integer value.");
        }

        // Prevent overflow when calculating the volume
        long volume = width * height * length;

        // Check if the package is bulky
        boolean isBulky = volume >= 1_000_000L || width >= 150 || height >= 150 || length >= 150;

        // Check if the package is heavy
        boolean isHeavy = mass >= 20;

        // Apply the rules to determine which stack the package should go to
        if (isBulky && isHeavy) {
            return "REJECTED";
        } else if (isBulky || isHeavy) {
            return "SPECIAL";
        } else {
            return "STANDARD";
        }
    }
}
