package algorithms;

// Определение ФАКТОРИАЛА, используя рекурсию.

class FactorialUsingRecursion {

    // Рекурсивный метод
    int fact(int n) {
        int result;
        if(n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }

    public static void main (String[] args) {
        FactorialUsingRecursion dimFact = new FactorialUsingRecursion();
        System.out.println("Факториал(1) = " + dimFact.fact(1));
        System.out.println("Факториал(2) = " + dimFact.fact(2));
        System.out.println("Факториал(3) = " + dimFact.fact(3));
    }
}
/*
Метод fact() действует следующим образом.
Когда этот метод вызывается со значением 1 своего аргумента, то возвращается значение 1.
В противном случае возвращается произведение fact(n - 1) * n.
Для вычисления этого выражения метод fасt() вызывается со значением n - 1 своего аргумента.
Этот процесс повторяется до тех пор, пока значение n не станет равным 1,
после чего начнется возврат из последовательных вызовов метода fасt().
-------------------
Факториал(1) = 1
Факториал(2) = 2
Факториал(3) = 6
 */
