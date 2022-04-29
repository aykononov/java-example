package algorithms;

// Проверить, является ли строка Палиндромом.
class IsPalindrome {
    private String inStr;

    IsPalindrome(String a) {
        inStr = a;
    }

    // Check if the string is a Palindrome.
    void chk () {
        int i;
        for (i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) != inStr.charAt(inStr.length() - i - 1)) {
                System.out.println(inStr + " : Not Palindrome");
                break;
            }
            else if (i == inStr.length() - 1 )
                System.out.println(inStr + " : Palindrome");
        }
    }
}
class Palindrom {
    public static void main(String[] args) {
        IsPalindrome ob1 = new IsPalindrome("100002");
        IsPalindrome ob2 = new IsPalindrome("10001");
        IsPalindrome ob3 = new IsPalindrome("радар");
        IsPalindrome ob4 = new IsPalindrome("soRros");
        ob1.chk();
        ob2.chk();
        ob3.chk();
        ob4.chk();
    }
}
/* --------------------
100002 : Not Palindrome
10001 : Palindrome
радар : Palindrome
soRros : Not Palindrome
*/
