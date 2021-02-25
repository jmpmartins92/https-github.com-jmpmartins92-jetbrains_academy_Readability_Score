class Problem {
    public static void main(String[] args) {
        boolean modeExists = false;
        for (int parameter = 0; parameter < args.length - 1; parameter += 2) {
            if (args[parameter].equals("mode")) {
                System.out.println(args[parameter + 1]);
                modeExists = true;
            }
            if (!modeExists && parameter == args.length - 2) {
                System.out.println("default");
            }
        }
    }
}