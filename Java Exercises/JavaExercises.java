public class JavaPracticeProblems{
    
    public static boolean primeornot(int n){
        if(n<=1) return false;
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public static void primenumbers(int n){
        System.out.print("Prime numbers from 1 to "+ n +" : ");
        for(int i=2;i<n;i++){
            if(primeornot(i)){
                System.out.print(i + "  ");
            }
        }
    }

    public static void sortingg(int[] arr,int l){
       for(int i=0;i<l-1;i++){
            boolean swapped = false;
            for(int j=0;j<l-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
       }
    }
    
    public static void largest(int[] arr,int m){
        int largest = arr[0];
        for(int i=0;i<m;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        System.out.println("\nLargest element of array is: "+largest);
    }

    public static void secondlargest(int[] arr,int u){
        int largest = arr[0];
        int secondlargest = Integer.MIN_VALUE;

        for(int i=0;i<u;i++){
            if(arr[i] > largest){
                secondlargest = largest;
                largest = arr[i];
            }
            else if(arr[i] != largest && arr[i] > secondlargest){
                secondlargest = arr[i];
            }
        }
        System.out.println("Second Largest element of the array: "+secondlargest);
        }

        public static void smallestt(int[] arr,int t){
            int smallest = arr[0];

            for(int i=0;i<t;i++){
                if(arr[i] < smallest){
                    smallest = arr[i];
                }
            }
            System.err.println("Smallest Element of the array: "+ smallest);
        }

        public static void secondsmallestt(int[] arr,int j){
            int smallest = arr[0];
            int secondsmallest = Integer.MAX_VALUE;

            for(int i=0;i<j;i++){
                if(arr[i] < smallest){
                    secondsmallest = smallest;
                    smallest = arr[i];
                }
                else if(arr[i] != smallest && arr[i] < secondsmallest){
                    secondsmallest = arr[i];
                }
            }
            
            System.out.println("Second smallest element of the array: "+secondsmallest);
        }
        
        public static void sumofarrayelements(int[] arr,int k){
            int sum = 0;
            for(int i=0;i<k;i++){
                sum = sum + arr[i];
            }
            System.out.println("The sum of array elements is " + sum);
        }

        public static void stringreversal(String str1){
            char[] chararray = str1.toCharArray();
            int start = 0;
            int end = chararray.length-1;

            while(start < end){
                char temp = chararray[start];
                chararray[start] = chararray[end];
                chararray[end] = temp;

                start++;
                end--;
            }   
            String reversedstringg = new String(chararray);
            System.out.println("String after Reversal: "+reversedstringg);
        }

        public static boolean palindrome(String str2){
            int left = 0;
            int right = str2.length()-1;

            while(left<right){
                if(str2.charAt(left) != str2.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }

        public static boolean anagram(String str3,String str4){
            if(str3.length() != str4.length()){
                return false;
            }
            int[] charcount = new int[26];

            for(int i=0;i<str3.length();i++){
                charcount[str3.charAt(i) - 'a']++;
            }

            for(int i=0;i<str4.length();i++){
                charcount[str4.charAt(i)- 'a']--;
            }

            for(int count : charcount){
                if(count != 0){
                     return false;
                }
            }
            return true;
        }

        public static void vowelsandconsonants(String str5){
            int vowels = 0;
            int consonants = 0;

            String lowercasestr = str5.toLowerCase();
            String nospacelowerstr = lowercasestr.replaceAll("\\s+", "");

            for(int i=0;i<nospacelowerstr.length();i++){
                char ch = nospacelowerstr.charAt(i);

                if(ch >= 'a' && ch <= 'z'){
                    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                        vowels++;
                    }
                    else{
                        consonants++;
                    }
                }
            }
            System.out.println("The number of vowels in string is "+vowels);
            System.out.println("The number of consonants in string is " + consonants);
        }
    
    public static void main(String[] args) {
        int n = 97;
        int n1 = 13;
        System.out.println(primeornot(n1));                    //1

        primenumbers(n);                                       //2

        int[] arr = {5,4,2,1,3};
        int l = arr.length;
        sortingg(arr, l);                                      //3             
        System.out.print("Array after sorting: ");
        for(int i=0;i<l;i++){
            System.out.print(arr[i]+" ");
        }

        largest(arr, l);                                        //4

        secondlargest(arr, l);                                  //5

        smallestt(arr, l);                                      //6

        secondsmallestt(arr, l);                                //7

        sumofarrayelements(arr, l);                             //8

        String str1 = "LINA";
        stringreversal(str1);                                   //9

        String str2 = "madam";
        if(palindrome(str2)){                                   //10 
            System.out.println(str2 + " is a palidrome");
        }        
        else{
             System.out.print(str2 + " is not a palindrome");             
        }

        String str3 = "listen";
        String str4 = "silent";
        if(anagram(str3, str4)){                                //11
            System.out.println("The given two strings are anagrams"); 
        }
        else {
            System.out.println("The given two strings are not anagrams");
        }

        String str5 = "Anil Kumar";
        vowelsandconsonants(str5);                              //12
    }
}