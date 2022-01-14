package video04;

public class LookAndSayAnotherSolution {

    public static void main(String[] args) {

        // https://github.com/lbarjak/LookAndSay/blob/master/LookAndSay.java

        // but this one writes the number from the second element! the first one was not included!

        String num = "1";
        int counter = 1;

        for (int j = 0; j < 10; j++) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < num.length(); i++) {
                if (i < num.length() - 1 && num.charAt(i) == num.charAt(i + 1)) {
                    counter++;
                } else {
                    result.append(counter).append(num.charAt(i));
                    counter = 1;

                }
            }
            System.out.println(num = result.toString());
        }
    }
}
