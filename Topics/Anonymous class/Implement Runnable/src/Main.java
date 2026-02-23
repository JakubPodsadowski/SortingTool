class Create {

    public static Runnable createRunnable(String text, int repeats) {
        Runnable method = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < repeats; i++) {
                    System.out.println(text);
                }
            }
        };
        return method;
    }
}