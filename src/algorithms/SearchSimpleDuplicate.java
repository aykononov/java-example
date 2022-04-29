package algorithms;

// Поиск дубликатов в массиве методом простого перебора всех элементов.
// 1,2,3,4,5 = false
// 1,2,3,1,5 = true
class SearchSimpleDuplicate {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 5, 1};
        boolean result = containsDuplication(input);
    }

    // Меод поиска дубликатов массива
    static boolean containsDuplication(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.printf("Найден повторяющийся элемент: %b\n", (nums[i] == nums[j]));
                    System.out.println(nums[i] + " = " + nums[j]);
                    return true;
                }
            }
        }
        System.out.println("Дубликат не обнаружен: " + false);
        return false;
    }
}
/*--------------------------------
// 1,2,3,1,5 = true
Найден повторяющийся элемент: true
1 = 1

// 1,2,3,4,5 = true
Дубликат не обнаружен: false
 */
