package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        }
        if (value1 < value2) {
            return -1;
        }
        return 0;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        }
        if (value1 < value2) {
            return value2;
        }
        return value1; // На случай равенства, но в условии не сказано.
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int j = 0;
        for (int i : values) {
            if (i % 2 == 0) {
                j++;
            }
        }
        if (j == 0) {
            return new int[]{};
        }
        int evenDigits[] = new int[j];
        int nextEvenDigitsIndex = 0;
        for (j = 0; j < evenDigits.length; j++) {
            for (int i = nextEvenDigitsIndex; i < values.length; i++) {
                if (values[i] % 2 == 0) {
                    nextEvenDigitsIndex = i + 1;
                    evenDigits[j] = values[i];
                    break;
                }
            }
        }
        return evenDigits;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        if (initialVal > 0) {
            long factorial = 1;
            for (int i = 1; i <= initialVal; i++) {
                factorial *= i;
            }
            return factorial;
        }
        if (initialVal == 0) {
            return 1L;
        }
        return -1L; // Если поступит отрицательное число, в условии не сказано.
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        long n1 = 0;
        long n2 = 1;
        long fibonachi = 0;
        for (int i = 0; i < number; i++) {
            fibonachi = n2 + n1;
            n2 = n1;
            n1 = fibonachi;
        }
        return fibonachi;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int i = values.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (values[j] > values[j + 1]) {
                    int k = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = k;
                }
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean b = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                b = false;
                break;
            }
        }
        return b;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        for (int i = 0; i < values.length / 2; i++) {
            int j = values [i];
            values [i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = j;
        }
        return values;
    }
}