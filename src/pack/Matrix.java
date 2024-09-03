package pack;

import java.util.Scanner;

public class Matrix {
    static int[][] matrix = new int[32][32];
    static int size = 0;

    public static void user_input() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (true) {
            String line = sc.nextLine();
            if (line == "") {
                return;
            }
            String[] str_arr = line.split(" ");
            size = str_arr.length;
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(str_arr[j]);
            }
            i++;
        }
    }

    public static int[][] reachableMatrix(int[][] matrix, int size) {
        int[][] reachable = new int[size][size];

        // Инициализация матрицы достижимости
        for (int i = 0; i < size; i++) {
            reachable[i][i] = 1; // Каждая вершина достижима сама из себя
        }

        // Алгоритм Флойда-Уоршелла
        for (int k = 0; k < size; k++) { // Проходим по всем промежуточным вершинам k
            for (int i = 0; i < size; i++) { // Проходим по всем начальным вершинам i
                for (int j = 0; j < size; j++) { // Проходим по всем конечным вершинам j
                    if (reachable[i][k] == 1 || reachable[k][j] == 1) { // Проверяем, может ли быть путь через k
                        reachable[i][j] = 1; // Если может, то отмечаем, что j достижима из i
                    }
                }
            }
        }

        return reachable;
    }

    static void output(int[][] arr) {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        user_input();

        int[][] reachable = reachableMatrix(matrix, size);

        output(reachable);
    }
}

//0 1 0 0 0 0
//1 0 1 0 0 0
//0 1 0 1 0 0
//0 0 1 0 1 0
//0 0 0 1 0 0
//0 0 0 0 0 0


//0 1 1 0 0
//1 0 0 1 0
//1 0 0 0 1
//0 1 0 0 1
//0 0 1 1 0
