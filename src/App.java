public class App {
    public static void main(String[] args) throws Exception {
        App cc = new App();
        System.out.println("-----One word:");
        System.out.println(cc.encode("fine"));
        System.out.println(cc.encode("quick"));
        System.out.println(cc.encode("Brown"));
        System.out.println(cc.encode("fox"));
        System.out.println(cc.encode("JumpeD"));
        System.out.println(cc.encode("I"));

        System.out.println("----- A sentence:");
        System.out.println(cc.encodesentence("Hi my name is Millie"));
        System.out.println(cc.encodesentence("I dont know your name"));
        System.out.println(cc.encodesentence("I like sleeping"));
        System.out.println(cc.encodesentence("Why is it so hard to think of sentences"));
        System.out.println(cc.encodesentence("Well I guess it could be fun to see what it does with it"));
        System.out.println(cc.encodesentence("How do I check if this works-oh wait. I got it"));
        System.out.println(cc.encodesentence("Goverment secrets."));
        System.out.println(cc.encodesentence("So, if I wrote a sentence with punctuation, it would work?"));
    }

    public String encode(String blank) {

        if (blank.length() - 1 >= 0) {
            char last = blank.charAt(blank.length() - 1);
            int shift = (int) last;
            char pun = ' ';

            if (shift > 96 && shift < 123) {
                shift = shift - 97;
                shift = shift % 26;
            } else if (shift > 64 && shift < 91) {
                shift = shift - 65;
                shift = shift % 26;
            } else {
                pun = last;
                blank = blank.substring(0, blank.length() - 1);
                last = blank.charAt(blank.length() - 1);
                shift = (int) last;

                if (shift > 96 && shift < 123) {
                    shift = shift - 97;
                    shift = shift % 26;
                } else if (shift > 64 && shift < 91) {
                    shift = shift - 65;
                    shift = shift % 26;
                }

            }
            String base = "";
            int i = 0;
            while (i < blank.length() - 1) {
                char each = blank.charAt(i);
                int num = (int) each;
                if (num > 96 && num < 123) {
                    num = num - 97;
                    num += shift;
                    num = num % 26;
                    num = num + 97;
                } else if (num > 64 && num < 91) {
                    num = num - 65 + shift;
                    num = num % 26;
                    num += 65;
                } else {
                    num = num + 0;
                }

                char fin = (char) num;
                base = base + fin;
                i++;
            }
            return last + base + pun;
        } else {
            return "";
        }
    }

    public String encodesentence(String sentence) {
        String[] splitup = sentence.split(" ");
        int i = 0;
        String base = "";
        while (i < splitup.length) {
            String now = encode(splitup[i]);
            base = base + now + " ";
            i++;
        }
        return base;
    }

}
