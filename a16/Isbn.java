/**
 * This class is supposed to calculate and verify an ISBN13's checksum.
 * @author Daniel Thümen
 * @author Philipp Bartsch
 * */

public class Isbn{
    public static void main(String[] args){
        
        // input validation
        if(args.length != 1){
            System.out.println("Illegal or missing parameter!\nusage: java isbn <ISBN>");
            System.exit(1);
        }

        // initializing variables
        String isbn = args[0];
        int checksum,temp,sum,c;
        checksum=temp=sum=c=0;

        // calculate checksum
        for(int i=0, comp=isbn.length()-1; i<comp; i++){
            temp = Character.getNumericValue(isbn.charAt(i));
            if(temp != -1){
                sum += (c+1)%2 == 0 ? temp*3 : temp;
                c++;
            }           
        }
        checksum = 10-(sum%10);

        // output result
        if(checksum == Character.getNumericValue(isbn.charAt(isbn.length()-1))){
            System.out.println(isbn + " ist eine gültige ISBN.");
        }else{
            System.out.println(isbn + " ist eine fehlerhafte ISBN\nchecksum sollte '" + checksum + "' sein.");
        }
    }
}
