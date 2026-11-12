import java.util.Random;
import java.util.Scanner;

public class SmalMonster extends Monster {

        public SmalMonster(int size) {
            super(size);
            this.imange = "\uD83D\uDC7E";
        }

        //@Override
        public boolean talkMonster(int difficulty) {

            Random r = new Random();
            int a = r.nextInt(50);
            int b = r.nextInt(a+50);

            System.out.println("Маленкий монстр пишит "+a+" + "+b+" = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();

            if(a + b == ans) {
                System.out.println(" В Е Р Н О ? НЕЕЕЕЕТ! КХ - КХ");
                return true;
            }

            else {
                    System.out.println(" Н Е В Е Р Н О !  ХАХАХАХАХА ЛОХ!!");
                    return false;
                }
            }
}


