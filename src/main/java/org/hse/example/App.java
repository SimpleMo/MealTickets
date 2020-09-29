package org.hse.example;

public class App {

    /**
     * Основной метод
     * @param args
     */
    public static void main(String... args) {
        long count = 0l;
        for (long i = 0; i < 1000000; i++){
            //Получаем билет
            int[] ticket = getTicket(i);

            if(!isMealTicket(ticket)) {
                continue;
            }

            //Если счастливый, увеличиваем счётчик и выводим
            count++;
            for (int k : ticket) {
                System.out.print(k);
            }
            System.out.println();

        }
        System.out.println("Hello World! " + count);
    }

    /**
     * Возвращает для переданного числа номер билета в виде массива цифр
     *
     * @param i номер билета
     * @return массив с цифрамиб составляющими номер билета
     */
    private static int[] getTicket(long i) {
        long t = i;
        int j = 5;
        int[] ticket = new int[]{0, 0, 0, 0, 0, 0};
        while (t > 0) {
            ticket[j] = (int) t % 10;
            t = t / 10;
            j--;
        }

        return ticket;
    }

    /**
     * @param ticket билет в виде массива
     * @return true если билет счастливый
     */
    private static boolean isMealTicket(int[] ticket){
        int firstSum = ticket[0] + ticket[1] + ticket[2];
        int lastSum = ticket[3] + ticket[4] + ticket[5];

        return firstSum == lastSum;
    }
}
