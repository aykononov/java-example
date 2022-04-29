package algorithms;

// Определение ФАКТОРИАЛА (используя Лямбда-выражение)

interface Numeric {
    int getNum(int n);
}
public class FactorialUsingLambda {
    public static void main(String[] args) {
        Numeric factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            } return result;
        };

        System.out.println("Факториал числа 3 равен: " + factorial.getNum(3));
        System.out.println("Факториал числа 5 равен: " + factorial.getNum(5));
    }
}
/*
В блочном лямбда-выражении объявляется переменная result, организуется цикл for и указывается оператор return.
В лямбда-выражении оператор return, просто вызывает возврат из самого лямбда-выражения, но не из объемлющего его метода.
-------------------------
Факториал числа 3 равен: 6
Факториал числа 5 равен: 120
 */