import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Gen> GEN = new ArrayList<>();
    public static int Population = 500;
    public static int min = 1;
    public static int max = 10;

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < Population; i++) {
            int[] temp = new int[16];
            for (int j = 0; j < 16; j++) {
                temp[j] = random.nextInt(max - min + 1) + min;
            }
            CheckGen(temp);
            Gen gen = new Gen(temp,Fitness(temp));
            GEN.add(gen);
        }
        GEN.sort(Comparator.comparing(Gen::getFITNESS));
        for (int i = 0; i < GEN.size(); i++) {
            System.out.println(GEN.get(i).getFITNESS());
        }


    }
    public static int Fitness(int[] gen){
        int FITNESS = 0;
        for (int i = 0; i < gen.length; i++) {
            if(gen[i] ==1){
                FITNESS +=15;
            }else if(gen[i] ==2){
                FITNESS +=10;
            }else if(gen[i] ==3){
                FITNESS +=30;
            }else if(gen[i] ==4){
                FITNESS +=25;
            }else if(gen[i] ==5){
                FITNESS +=20;
            }else if(gen[i] ==6){
                FITNESS +=50;
            }else if(gen[i] ==7){
                FITNESS +=35;
            }else if(gen[i] ==8){
                FITNESS +=25;
            }else if(gen[i] ==9){
                FITNESS +=50;
            }else if(gen[i] ==10){
                FITNESS +=20;
            }
        }
        return FITNESS;

    }
    public static void CheckGen(int[] gen){
        Random random = new Random();
        for (int i = 0; i < gen.length; i++) {
            int Mutation = 0 ;
            for (int j = 0; j < gen.length; j++) {
                if(Mutation== 8){
                    gen[i] = 0;
                }
            if(gen[i] == 1){
                if(gen[i]%2==0 ){
                    if(i > 6 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 6 ||gen[i-1] == 1 || gen[i-1] == 6 || gen[i-1] == 8 || gen[i-1] == 10 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
                
            }
            else if(gen[i] == 2){
                if(gen[i]%2==0){
                    if(i > 12 || 2 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 12 ||gen[i-1] == 9 || gen[i-1] == 4 || gen[i-1] == 5  || 2 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 3){
                if(gen[i]%2==0){
                    if(i > 10 || 10 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 10 ||gen[i-1] == 9 || 10 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 4){
                if(gen[i]%2==0){
                    if(i > 8 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 8 ||gen[i-1] == 2|| gen[i-1] == 7 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 5){
                if(gen[i]%2==0){
                    if(i > 18 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 18 ||gen[i-1] == 2|| gen[i-1] == 7 || gen[i-1] == 10 || gen[i-1] == 6 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 6){
                if(gen[i]%2==0){
                    if(i > 2 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 2 ||gen[i-1] == 5|| gen[i-1] == 1  || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 7){
                if(gen[i]%2==0){
                    if(i > 14 || 5 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 14 ||gen[i-1] == 4|| gen[i-1] == 5 || gen[i-1] == 10  || 5 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 8){
                if(gen[i]%2==0){
                    if(i > 16 || 1 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 16 ||gen[i-1] == 1|| gen[i-1] == 8  || 1 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 9){
                if(gen[i]%2==0){
                    if(i > 10 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 10 ||gen[i-1] == 2|| gen[i-1] == 3  || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
            else if(gen[i] == 10){
                if(gen[i]%2==0){
                    if(i > 10 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }else if(i>1){
                    if(i > 10 ||gen[i-1] == 1|| gen[i-1] == 7 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
                        Mutation++;
                        gen[i] = random.nextInt(max - min + 1) + min;
                    }
                }
            }
        }}
    }
    public static int countOccurrencesInRange(int[] array, int target, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                count++;
            }
        }
        return count;
    }
}

