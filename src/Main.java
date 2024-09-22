public class Main {
    public static void main(String[] args) {
        testSort();
    }

    private static void testSort() {
        // Standard package tests
        assert PackageSorter.sort(100, 50, 30, 10).equals("STANDARD") : "Test 1 Failed";
        assert PackageSorter.sort(50, 100, 60, 19).equals("STANDARD") : "Test 2 Failed";

        // Special package (bulky) tests
        assert PackageSorter.sort(151, 50, 30, 10).equals("SPECIAL") : "Test 3 Failed";
        assert PackageSorter.sort(100, 150, 50, 10).equals("SPECIAL") : "Test 4 Failed";
        assert PackageSorter.sort(100, 50, 300, 10).equals("SPECIAL") : "Test 5 Failed";
        assert PackageSorter.sort(120, 60, 200, 10).equals("SPECIAL") : "Test 6 Failed";

        // Special package (heavy) tests
        assert PackageSorter.sort(50, 50, 50, 20).equals("SPECIAL") : "Test 7 Failed";
        assert PackageSorter.sort(100, 100, 100, 25).equals("SPECIAL") : "Test 8 Failed";

        // Rejected package tests
        assert PackageSorter.sort(151, 151, 151, 25).equals("REJECTED") : "Test 9 Failed";
        assert PackageSorter.sort(200, 50, 200, 30).equals("REJECTED") : "Test 10 Failed";

        // All zeros case (should be STANDARD)
        assert PackageSorter.sort(0, 0, 0, 0).equals("STANDARD") : "Test 11 Failed";

        // Edge case for large values
        assert PackageSorter.sort(Integer.MAX_VALUE, 1, 1, 0).equals("SPECIAL") : "Test 12 Failed"; // Large volume
        assert PackageSorter.sort(1, 1, 1, Integer.MAX_VALUE).equals("SPECIAL") : "Test 13 Failed"; // Large mass

        // Test for values exceeding MAX_INT
        try {
            PackageSorter.sort(Integer.MAX_VALUE + 1L, 1, 1, 0);
            assert false : "Test 14 Failed - Exception should be thrown for exceeding MAX_INT";
        } catch (IllegalArgumentException e) {
            assert true : "Test 14 Passed";
        }

        try {
            PackageSorter.sort(1, 1, 1, Integer.MAX_VALUE + 1L);
            assert false : "Test 15 Failed - Exception should be thrown for exceeding MAX_INT";
        } catch (IllegalArgumentException e) {
            assert true : "Test 15 Passed";
        }

        System.out.println("All tests passed!");
    }
}