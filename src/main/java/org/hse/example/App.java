package org.hse.example;

/**
 * Приложение для работы со счастливым
 */
public class App {

    private static final int MAX_NUMBER = 1000000;

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     * @param args аргументы
     */
    public static void main(String... args) {
        long count = 0L;
        for (long i = 0; i < MAX_NUMBER; i++) {
            //Получаем билет
            Lucky luckyCandidate = getCandidate(i);

            if (luckyCandidate.isLucky()) {
                //Если счастливый, увеличиваем счётчик и выводим
                count++;
                System.out.println(luckyCandidate);
            }

        }
        System.out.println("Счастливых билетов " + count);
    }

    /**
     * Возвращает очередной экземпляр для проверки
     * @param i номер
     * @return объект, реализующий {@link Lucky}
     */
    private static Lucky getCandidate(long i) {
        return new LuckyImpl(i);
    }

}
