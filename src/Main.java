import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Gen> GEN = new ArrayList<>();
    public static int Population = 200;
    public static ArrayList<product> Product = new ArrayList<>();
    public static int min = 1;
    public static int max = 10;
    public static int NumberOfTrip = 20;
    public static int Generation = 5;

    public static void main(String[] args) {
        Random random = new Random();
        int[] P1,P2,P3,P4,P5,P6,P7,P8,P9,P10;
        P1 = new int[]{1, 6, 8, 10};
        product P = new product(P1,6,4,15);
        Product.add(P);
        P2 = new int[]{9,4,5};
        P = new product(P2,12,2,10);
        Product.add(P);
        P3 = new int[]{9};
        P = new product(P3,10,10,30);
        Product.add(P);
        P4 = new int[]{2,7};
        P = new product(P4,8,4,25);
        Product.add(P);
        P5 = new int[]{2,6,7,10};
        P = new product(P5,18,3,20);
        Product.add(P);
        P6 = new int[]{5,1};
        P = new product(P6,2,4,50);
        Product.add(P);
        P7 = new int[]{4,5,10};
        P = new product(P7,14,5,35);
        Product.add(P);
        P8 = new int[]{1,8};
        P = new product(P8,16,1,25);
        Product.add(P);
        P9 = new int[]{2,3};
        P = new product(P9,10,3,50);
        Product.add(P);
        P10 = new int[]{1,7};
        P = new product(P10,10,3,20);
        Product.add(P);

        for (int i = 0; i < Population; i++) {
            int[] temp = new int[NumberOfTrip];
            for (int j = 0; j < NumberOfTrip; j++) {
                temp[j] = random.nextInt(max - min + 1) + min;
            }
            CheckGen(temp);
           // Mutation(temp);
            Gen gen = new Gen(temp,Fitness(temp));
            GEN.add(gen);
        }
        GEN.sort(Comparator.comparing(Gen::getFITNESS));
        System.out.println(GEN);
        for (int i = 0; i < Generation; i++) {
            Crossover();
        }
        System.out.println(GEN);

    }
    public static int Fitness(int[] gen){
        int FITNESS = 0;

        for (int i = 0; i < gen.length; i++) {
            if(gen[i]!=0){
                FITNESS +=Product.get(gen[i]-1).getValue();
            }
        }
        return  (FITNESS*2)-1150;
    }
    public static void CheckGen(int[] gen){
        Random random = new Random();
        for (int i = 0; i < NumberOfTrip; i++) {
            int Mutation = 0 ;
            for (int j = 0; j <50; j++) {

                if(gen[i] == 0){
                    Mutation++;
                    gen[i] = random.nextInt(max - min + 1) + min;
                }

                    if (gen[i] % 2 == 0 ) {
                        if (Check_Expiration_Date(gen[i] - 1, i) || (Product.get(gen[i] - 1).getExpiration_Date() < countOccurrencesInRange(gen, gen[i], 0, i))) {
                            Mutation++;
                            gen[i] = random.nextInt(max - min + 1) + min;
                        }
                    } else if (gen[i] % 2 == 1 && i > 1) {
                        if (Check_Expiration_Date(gen[i] - 1, i) || (Check_Interference(gen[i] - 1, gen[i - 1])) || (Product.get(gen[i] - 1).getExpiration_Date() < countOccurrencesInRange(gen, gen[i], 0, i))) {
                            Mutation++;
                            gen[i] = random.nextInt(max - min + 1) + min;
                        }
                    }
                if(Mutation >= 20){
                    gen[i] = 0;
                    j=60;
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
    public static void Crossover(){
        GEN.sort(Comparator.comparing(Gen::getFITNESS));
        Random random = new Random();
        for (int i = 0; i < Population/2; i++) {
            int[] temp = new int[NumberOfTrip];
            int parent2 = random.nextInt(Population);
            int parent1 = random.nextInt(Population);
            for (int j = 0; j < NumberOfTrip; j++) {
                if(j>=NumberOfTrip/2){
              //if(j<NumberOfTrip/2){
                    temp[j] = GEN.get(parent1).getGEN()[j];
                }else {
                    temp[j] = GEN.get(parent2).getGEN()[j];
                }

            }
            CheckGen(temp);
            //Mutation(temp);
            Gen gen = new Gen(temp,Fitness(temp));
            GEN.add(gen);
        }

        for (int i = 0; i < Population/2; i++){
            GEN.sort(Comparator.comparing(Gen::getFITNESS));
            GEN.remove(random.nextInt(GEN.size() - ((GEN.size()/4)*3) + 1) + GEN.size()/2);
        }
        //System.out.println(GEN);

    }
//    public static void Mutation(int[] gen){
//        Random random = new Random();
//        for (int i = 0; i < gen.length; i++) {
//            int Mutation = 0 , Mutation_Rate = 80 ;
//            for (int j = 0; j < 20; j++) {
//                if(j == 18){
//                    Mutation =3;
//                }
//                if(gen[i] == 0){
//                    if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                        Mutation++;
//                        gen[i] = random.nextInt(max - min + 1) + min;
//                    }else {
//                        gen[i] = 0;
//                    }
//
//                }
//                else if(gen[i] == 1){
//                    if(gen[i]%2==0 ){
//                        if(i >= 6 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 6 ||gen[i-1] == 1 || gen[i-1] == 6 || gen[i-1] == 8 || gen[i-1] == 10 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//
//                }
//                else if(gen[i] == 2){
//                    if(gen[i]%2==0){
//                        if(i >= 12 || 2 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 12 ||gen[i-1] == 9 || gen[i-1] == 4 || gen[i-1] == 5  || 2 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 3){
//                    if(gen[i]%2==0){
//                        if(i >= 10 || 10 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 10 ||gen[i-1] == 9 || 10 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 4){
//                    if(gen[i]%2==0){
//                        if(i >= 8 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 8 ||gen[i-1] == 2|| gen[i-1] == 7 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 5){
//                    if(gen[i]%2==0){
//                        if(i >= 18 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 18 ||gen[i-1] == 2|| gen[i-1] == 7 || gen[i-1] == 10 || gen[i-1] == 6 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 6){
//                    if(gen[i]%2==0){
//                        if(i >= 2 || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 2 ||gen[i-1] == 5|| gen[i-1] == 1  || 4 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 7){
//                    if(gen[i]%2==0){
//                        if(i >= 14 || 5 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 14 ||gen[i-1] == 4|| gen[i-1] == 5 || gen[i-1] == 10  || 5 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 8){
//                    if(gen[i]%2==0){
//                        if(i > 16 || 1 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>1){
//                        if(i > 16 ||gen[i-1] == 1|| gen[i-1] == 8  || 1 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 9){
//                    if(gen[i]%2==0){
//                        if(i >= 10 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i > 10 ||gen[i-1] == 2|| gen[i-1] == 3  || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//                else if(gen[i] == 10){
//                    if(gen[i]%2==0){
//                        if(i >= 10 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100) && Mutation<= 1){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }else if(i>=1){
//                        if(i >= 10 ||gen[i-1] == 1|| gen[i-1] == 7 || 3 <countOccurrencesInRange(gen,gen[i],0,i)){
//                            if(Mutation_Rate <= random.nextInt(100)){
//                                Mutation++;
//                                gen[i] = random.nextInt(max - min + 1) + min;
//                            }else {
//                                gen[i] = 0;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
    public static boolean Check_Interference(int number , int first_P){
        for (int i = 0; i < Product.get(number).getInterference().length; i++) {
            if((Product.get(number).getInterference()[i])==first_P){
                return true;
            }

        }
        return false;
    }
    public static boolean Check_Expiration_Date(int number, int Now){
        if(Product.get(number).getExpiration_Date() <=  Now){
            return true;
        }
        return false;

    }
}

