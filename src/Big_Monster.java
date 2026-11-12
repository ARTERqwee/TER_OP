import java.util.Random;
import java.util.Scanner;

public class Big_Monster extends Monster {

    public Big_Monster(int size) {
        super(size);
        this.imange = "\uD83D\uDC79";
    }

    //@Override

    public boolean talkMonster(int difficulty) {
        if (difficulty == 1) {
            return super.taskMonster(difficulty);
        }

        Random r = new Random();
        int max = difficulty*10;
        int a = r.nextInt(max);
        int b = r.nextInt(max);
        int c = r.nextInt(max);


        System.out.println("Громадина орёт ("+a+" - "+b+" ) * "+c+" = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();

        if((a+b)*c == ans) {
            System.out.println(" ВЕРНО! ХОРОШ!! ВОТ ТЕБЕ 1 ХП");
            return true;
        }

        else {
            System.out.println(" Н Е В Е Р Н О !  ХАХАХАХАХА ЛОХ(ЛОХОТРЯН)!!");
            return false;
        }
    }
}
