class Problem {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                System.out.println(i);
                break;

            } else if (i == args.length - 1 && !args[i].equals("test")) {
                System.out.println(-1);
            }
        }

    }
}