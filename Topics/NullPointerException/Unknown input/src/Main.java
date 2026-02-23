class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {
        try {
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}