import java.util.Scanner;

public class KaminoFactoryMarto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rangeDna = Integer.parseInt(scan.nextLine());

        int bestLength = 0;
        String bestDNA="";
        int bestIndex = 0;
        int bestSum = 0;
        int counter = 0;
        int bestCounter=0;
        String dna = scan.nextLine();
        while (!"Clone them!".equals(dna)) {
                counter++;
            String sequence = dna.replaceAll("!+", "");
            String[] dnas = sequence.split("0");

            int sum=0;
            int currentLength  = 0;
            String bestLocalDna = "";
            for (int i = 0; i < dnas.length; i++) {
                int some = dnas[i].length();
                if (dnas[i].length() > currentLength) {//парсва стойноста на индекса
                    //  на стринг масива dnas в int и дава дължината на самата стойност на този индекс
                    currentLength = dnas[i].length();//Първа интерация 2,втора 3,сума 5
                    bestLocalDna=dnas[i];
                }
                sum+=dnas[i].length();
            }

            int beginIndex = sequence.indexOf(bestLocalDna);

            if(currentLength > bestLength){
                bestCounter=counter;
                bestLength=currentLength;
                bestDNA=sequence;
                bestIndex=beginIndex;
                bestSum=sum;
            }else if (currentLength==bestLength && (beginIndex<bestIndex || sum>bestSum)){
                bestCounter=counter;
                bestLength=currentLength;
                bestDNA=sequence;
                bestIndex=beginIndex;
                bestSum=sum;
            }else if(counter == 1){
                bestCounter=counter;
                bestLength=currentLength;
                bestDNA=sequence;
                bestIndex=beginIndex;
                bestSum=sum;
            }
            dna = scan.nextLine();
        }

        System.out.println(String.format("Best DNA sample " +
                "%d with sum: %d.",bestCounter,bestSum));
        for (int i = 0; i <bestDNA.length() ; i++) {
            System.out.print(bestDNA.charAt(i) + " ");
        }
    }
}
