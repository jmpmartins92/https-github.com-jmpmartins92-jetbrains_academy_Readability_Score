class Problem {
    public static void main(String[] args) {
        for (int value = 1; value < args.length; value += 2) {
            int parameter = value - 1;
            System.out.println(args[parameter] + "=" + args[value]);
        }

    }
}