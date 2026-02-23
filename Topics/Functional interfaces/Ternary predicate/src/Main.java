class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (x, y, z) -> x != y && y != z && z != x;

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }
}