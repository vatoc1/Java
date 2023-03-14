import java.util.HashSet;


class InvalidAmountException extends Exception {
    public String toString() {
        return "Invalid Input of Amount";
    }
}


public class Sweeft {

    //Exercise 1
    public static int singleNumber(int [] arr) {
        int res = arr[0];
        for(int i = 1;i<arr.length;i++) {
            res^=arr[i];
        }
        return res;
    }

    //Exercise 2
    public static int minSplit(int amount) throws InvalidAmountException{

        if(amount<0) {
            throw new InvalidAmountException();
        }
        int counter = 0;
        int [] coins = {50,20,10,5,1};
        for(int i : coins) {
            counter+=(amount/i);
            amount%=i;
            if(amount==0) {
                break;
            }
        }
        return counter;
        
        
    }
    //Exercise 3
    public static int notContains(int [] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        int min = 1;
        for(int i : arr) {
            set.add(i);
            if(set.contains(min)) {
                min++;
            }
        }
        return min;
    }

    //Exercise 4 
    public static String binaryString(String first,String second) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = first.length()-1;
        int j = second.length()-1;
        while(i>=0||j>=0||carry > 0) {
            int sum = carry;
            if(i>=0) sum+= first.charAt(i) - '0';
            if(j>=0) sum+= second.charAt(i) - '0';
            res.append(sum%2);
            carry = sum/2;
            j--;
            i--;

        }
        return res.reverse().toString();
    }

    //Exercise 5 
    public static int countVariants(int stearsCount) {
        if(stearsCount < 0) {
            System.out.println("invalid input");
            return -1;
        }
        int [] arr = new int[stearsCount+1];
        arr[0] = 1;
        arr[1] = 2;
        for(int i = 2;i<stearsCount;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[stearsCount-1];
    }




    public static void main(String [] args)throws Exception{

        
        

        
    }
}