import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ты готов начать игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine();

        switch (answer.toLowerCase()) {
            case "да":
                System.out.println("Начинаем игру!");
                break;
            case "нет":
                System.out.println("Жаль, приходи ещё!");
                System.exit(744585672);
            default:
                System.out.println("Непонятный ответ, но мы все равно начинаем!");
        }

        System.out.println("Выберите уровень сложноти(введите число от 1 и выше)");
        int difficulty = scanner.nextInt();
        System.out.println("Выбран уровень сложности " + difficulty);

        int size = 5;
        String[][] board = new String[size][size];
        int step = 1;

        Person person = new Person(size);
        Random r = new Random();
        int castleX = r.nextInt(size) + 1;
        int castleY = 1;
        String castleImange = "🔏";

         //System.out.println("Выберете размер поля ");
         //size = scanner.nextInt();
         //if(size < 101){ System.out.println("Выбран размер поля : "+size); }
         //else{ System.out.println("НЕВОЗМОЖНО!! слишком большой обьём памяти !");
         //    System.exit(744585672);}




        int monsterCount = (size * size) / 5;
        Monster[] monsters = new Monster[monsterCount];
        for (int i = 0; i < monsterCount; i++){
            int type = r.nextInt(3);
            if (type == 0)monsters[i] = new Monster(size);
            else if (type == 1)monsters[i] = new Big_Monster(size);
            else monsters[i] = new SmalMonster(size);
        }

        while(true){
            for (int y = 0; y < size; y++){
                for (int x = 0; x < size; x++) {
                    board[y][x] = "  ";
                }
            }

            for (Monster m : monsters) {
                if (m != null && m.getX() > 0 && m.getY() > 0) {
                    board[m.getY() - 1][m.getX() - 1] = m.getImange();
                }
            }

            board[castleY - 1][castleX - 1] = castleImange;
            board[person.getY() - 1][person.getX() - 1] = person.getImage();

            System.out.println("\nХод: " + step + " | Жизни: " + person.getLive());
            String wall = "+----".repeat( size ) + "+";
            for (int i = 0; i < size; i++){
                System.out.println(wall);
                for (int j = 0; j < size ; j ++) {
                    System.out.print("| " + board[i][j] + "  ");
                }
                System.out.println("|");
            }
            System.out.println(wall);

            if (person.getLive() <= 0) {
                System.out.println("Ты мёртв !! лох!!!!");
                boolean game = false;
            }

            System.out.println("Твои корды : Y ="+person.getY()+" X ="+person.getX());
            System.out.println("Введите новые кординаты героя (х и y через пробел):");

            int nextY = scanner.nextInt();
            int nextX = scanner.nextInt();

            if (nextX < 1 || nextX > size || nextY < 1 || nextY > size) {
                System.out.println("Выход за границы поля");
                continue;
            }

            if(person.isMoveCorrect(nextX, nextY)){
                String nextCell = board[nextY - 1][nextX - 1];

                if (nextCell.equals(castleImange)) {
                    System.out.println("ТЫ ПОБЕДИЛ ?");
                    System.exit(363);
                } else if (!nextCell.equals("  ")) {
                    for(int i = 0; i < monsters.length; i++) {
                        if (monsters[i] != null && monsters[i].getX() == nextX && monsters[i].getY() == nextY) {
                            boolean success = monsters[i].taskMonster(difficulty);
                            if (success) {
                                monsters[i] = null;
                                person.move(nextX,nextY);
                            }else {
                                person.downLive();
                            }
                            break;
                        }
                    }
                } else {
                    person.move(nextX,nextY);
                }
                step++;
            } else {
                System.out.println("Некоректный ход !! ты д@лба@юб !!");
            }
        }
  }
}