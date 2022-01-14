package video04;

public class LookAndSay {

    public static void main(String[] args) {

        // https://www.youtube.com/watch?v=u9l4hGlbHkI&list=PLyriihBWoulxiXbyBTxu7GF6R_FDVwXEs&index=4

        /*
        Output:
        1
        11
        21
        1211
        111221
         */

        /*
        Solution and plan:
        check the number itself, and check how many digits are the same next to each other! this is the task!
         */

        String result = "1";

        for (int i = 0; i < 10; i++) {
            System.out.println(result);
            result = lookAndSay(result);
        }
    }

    private static String lookAndSay(String num) {
        // first say that num is null or if num is not null, but empty!!!
        if (num == null || num.isEmpty()) {
            return "";
        }

        StringBuilder sB = new StringBuilder();
        int firstCharPos = 0;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(firstCharPos) != num.charAt(i)) {
                String digitsTotal = num.substring(firstCharPos, i);
                sB.append(digitsTotal.length()).append(num.charAt(firstCharPos));
                firstCharPos = i;
            }
        }
        sB.append(num.substring(firstCharPos, num.length()).length()).append(num.charAt(firstCharPos));

        return sB.toString();
    }
}
