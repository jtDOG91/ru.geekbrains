package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class lesson3_xo {
    public static char[][] map;
    public static int sizeY;
    public static int sizeX;
    public static int dotsToWin;
    public static final char empty = '*';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_AI = '0';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int scoreHuman = 0;
    public static int scoreAI = 0;

    public static void main(String[] args) {
        initialized();
        while (true) {
            intiMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (isGameWin(DOT_HUMAN)) {
                    scoreHuman++;
                    System.out.println("Human is WIN!!! Score: Human - " + scoreHuman + ", AI - " + scoreAI + ".");
                    break;
                }
                if (!isDraw()) {
                    System.out.println("DRAW!!! Score: Human - " + scoreHuman + ", AI - " + scoreAI + ".");
                    break;
                }
                aiTurn();
                printMap();
                if (isGameWin(DOT_AI)) {
                    scoreAI++;
                    System.out.println("AI is WIN!!! Score: Human - " + scoreHuman + ", AI - " + scoreAI + ".");
                    break;
                }
                if (!isDraw()) {
                    System.out.println("Draw!!! Score: Human - " + scoreHuman + ", AI - " + scoreAI + ".");
                    break;
                }
            }
            System.out.println("Wanna play again? >>>>> Y or N");
            if (!sc.next().equalsIgnoreCase("y")) break;
        }
    }

    // ввод данных
    public static void initialized() {
        System.out.println("Введите размер поля Y X через пробел.");
        sizeY = sc.nextInt();
        sizeX = sc.nextInt();
        System.out.println("Введите длину выигрышной комбинации");
        dotsToWin = sc.nextInt();
    }

    // инициализация поля
    public static void intiMap() {
        map = new char[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                map[y][x] = empty;
            }
        }

    }

    // вывод поля в консоль
    public static void printMap() {
        System.out.print(" ");
        for (int w = 1; w != sizeX + 1; w++) {
            System.out.print(" " + w);
        }
        System.out.println(" ");
        for (int i = 0; i < sizeY; i++) {

            System.out.print(i + 1 + "|");
            for (int j = 0; j < sizeX; j++) {
                System.out.print(map[i][j] + "|");
            }
            System.out.println();

        }

    }

    // ход игрока
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход. Введите координаты Y X");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_HUMAN;
    }

    // проверка валидности хода
    public static boolean isCellValid(int y, int x) {
        if (y < 0 || y >= sizeY || x < 0 || x >= sizeX) return false;
        return map[y][x] == empty;
    }

    // ход компьютера
    public static void aiTurn() {
        if (checkWinAI()) return;
        if (checkWinHuman()) return;
        if (checkPreWin(DOT_AI)) return;
        if (checkPreWin(DOT_HUMAN)) return;
        randomTurnAI();
    }

    //проверка ничьей
    public static boolean isDraw() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (map[y][x] == empty) return true;
            }
        }
        return false;
    }

    // проверка победы
    public static boolean isGameWin(char c) {
        // горизонталь
        int x, y;
        for (y = 0; y < sizeY; y++) {
            int count = 0;
            for (x = 0; x < sizeX; x++) {
                if (map[y][x] == c) {
                    count++;
                } else count = 0;
                if (count == dotsToWin) {
                    return true;
                }
            }
        }
        // вертикаль
        for (x = 0; x < sizeX; x++) {
            int count = 0;
            for (y = 0; y < sizeY; y++) {
                if (map[y][x] == c) {
                    count++;
                } else count = 0;
                if (count == dotsToWin) return true;
            }
        }

        // диагонали
        for (y = 0; y < sizeY; y++) {
            int count = 0;
            int w = y;
            for (x = 0; x < sizeX && w < sizeY; x++, w++) {
                if (map[w][x] == c) {
                    count++;
                } else count = 0;
                if (count == dotsToWin) return true;
            }
        }
        for (x = 1; x < sizeX; x++) {
            int count = 0;
            int w = x;
            for (y = 0; y < sizeY && w < sizeX; y++, w++) {
                if (map[y][w] == c) {
                    count++;
                } else count = 0;
                if (count == dotsToWin) return true;
            }
        }


        for (y = sizeY - 1; y >= 0; y--) {
            int count = 0;
            int w = y;
            for (x = 0; x < sizeX && w >= 0; x++, w--) {
                if (map[w][x] == c) {
                    count++;
                } else count = 0;
                if (count == dotsToWin) return true;

            }
        }
        for (x = 1; x < sizeX; x++) {
            int count = 0;
            int w = x;
            for (y = sizeX - 1; y >= 0 && w < sizeX; y--, w++) {
                if (map[y][w] == c) {
                    count++;
                } else count = 0;
                if (count == dotsToWin) return true;

            }
        }
        return false;
    }

    // случайный ход компа
    public static void randomTurnAI() {
        int x, y;
        do {
            y = rand.nextInt(sizeY);
            x = rand.nextInt(sizeX);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_AI;
    }

    // проверка выигрышной комбинации компа
    public static boolean checkWinAI() {
        int y, x;
        for (y = 0; y < sizeY; y++) {
            for (x = 0; x < sizeX; x++) {
                if (map[y][x] == empty) {
                    map[y][x] = DOT_AI;
                    if (isGameWin(DOT_AI)) {
                        return true;
                    }
                    map[y][x] = empty;
                }
            }
        }
        return false;
    }

    // проверка выигрышной комбинации игрока
    public static boolean checkWinHuman() {
        int y, x;
        for (y = 0; y < sizeY; y++) {
            for (x = 0; x < sizeX; x++) {
                if (map[y][x] == empty) {
                    map[y][x] = DOT_HUMAN;
                    if (isGameWin(DOT_HUMAN)) {
                        map[y][x] = DOT_AI;
                        return true;
                    }
                    map[y][x] = empty;
                }
            }
        }
        return false;
    }

    // проверка предвыигрышной комбинации
    public static boolean checkPreWin(char c) {
        if (dotsToWin >= 4) {
            int e = dotsToWin - 2;
            int x, y;
            // горизонталь
            for (y = 0; y < sizeY; y++) {
                int count = 0;
                for (x = 0; x < sizeX; x++) {
                    if (map[y][x] == c) {
                        count++;
                    } else count = 0;
                    if (count == dotsToWin - 2) {
                        if (isCellValid(y, x + 1)) {
                            map[y][x + 1] = DOT_AI;
                            return true;
                        }
                        if (isCellValid(y, x - e)) {
                            map[y][x - e] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
            // вертикаль
            for (x = 0; x < sizeX; x++) {
                int count = 0;
                for (y = 0; y < sizeY; y++) {
                    if (map[y][x] == c) {
                        count++;
                    } else count = 0;
                    if (count == dotsToWin - 2) {
                        if (isCellValid(y + 1, x)) {
                            map[y + 1][x] = DOT_AI;
                            return true;
                        }
                        if (isCellValid(y - e, x)) {
                            map[y - e][x] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
            // диагонали
            for (y = 0; y < sizeY; y++) {
                int count = 0;
                int w = y;
                for (x = 0; x < sizeX && w < sizeY; x++, w++) {
                    if (map[w][x] == c) {
                        count++;
                    } else count = 0;
                    if (count == dotsToWin - 2) {
                        if (isCellValid(w + 1, x + 1)) {
                            map[w + 1][x + 1] = DOT_AI;
                            return true;
                        }
                        if (isCellValid(w - e, x - e)) {
                            map[w - e][x - e] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
            for (x = 1; x < sizeX; x++) {
                int count = 0;
                int w = x;
                for (y = 0; y < sizeY && w < sizeX; y++, w++) {
                    if (map[y][w] == c) {
                        count++;
                    } else count = 0;
                    if (count == dotsToWin - 2) {
                        if (isCellValid(y + 1, w + 1)) {
                            map[y + 1][w + 1] = DOT_AI;
                            return true;
                        }
                        if (isCellValid(y - e, w - e)) {
                            map[y - e][w - e] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
            for (y = sizeY - 1; y >= 0; y--) {
                int count = 0;
                int w = y;
                for (x = 0; x < sizeX && w >= 0; x++, w--) {
                    if (map[w][x] == c) {
                        count++;
                    } else count = 0;
                    if (count == dotsToWin - 2) {
                        if (isCellValid(w - 1, x + 1)) {
                            map[w - 1][x + 1] = DOT_AI;
                            return true;
                        }
                        if (isCellValid(w + e, x - e)) {
                            map[w + e][x - e] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
            for (x = 1; x < sizeX; x++) {
                int count = 0;
                int w = x;
                for (y = sizeX - 1; y >= 0 && w < sizeX; y--, w++) {
                    if (map[y][w] == c) {
                        count++;
                    } else count = 0;
                    if (count == dotsToWin - 2) {
                        if (isCellValid(y - 1, w + 1)) {
                            map[y - 1][w + 1] = DOT_AI;
                            return true;
                        }
                        if (isCellValid(y + e, w - e)) {
                            map[y + e][w - e] = DOT_AI;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

