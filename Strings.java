import java.util.*;
public class Strings {

    public static void funccharAt(String str){
        for(int i=0 ;i<str.length(); i++){
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    //Palindrome or not 
    public static boolean palindrome(String str){
        
        for(int i =0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                // Not Plaindrome
                return false;
            }
        }
        return true;
    }

    // WNEENESENNN Get Shortest Path 
    public static float shortestpath(String str){
        int x=0; 
        int y=0;
        for(int i =0; i<str.length(); i++){
            int dir = str.charAt(i);
            if(dir == 'W'){
                x-=1;
            }else if(dir == 'E'){
                x+=1;
            }else if(dir == 'N'){
                y+=1;
            }else if(dir == 'S'){
                y-=1;
            }
        }
        int X2= x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2+Y2);
    }

    // Substring 
    public static String substring(String str, int si, int ei){
        String substring = "";
        for(int i = si; i<ei; i++){
            substring +=str.charAt(i);
        }
        return substring;
    }

    // Why we needed String Builder 
    //In this code for everytime when loop runs it creates a new string with the change mentioned in loop which leads to O(n^2) TC hence concept of String Builder introduced 
    public static String ImmutableStr(String str){
        for (int i ='a'; i<='z'; i++){
            str+=i;
        }
        return str;
    }

    // Convert First letter to string 
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i =1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //String Compression 
    public static String compress(String str){

        String newStr = "";

        for(int i =0; i<str.length()-1; i++){
            Integer count =1;
            while(i<str.length() && str.charAt(i) == str.charAt(i+1)){
                count ++;
                i++;
            }
            newStr += str.charAt(i);
            if(count>1){
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // Strings are Arrays 
        char arr[] = {'a', 'b','c'};
        char arr1[] = new char[3];

        String str ="abcd";
        String str1 = new String ("seve@#$%^1234");// Anything can be written in Strings 

        //Strings are Immutable i.e if want to change anything in existing String we have to make new String only 

        //  Input/Output in Strings 

        String name;

        //name = sc.next();// This does not take space as soon as space comes it returns 
        name = sc.nextLine();
        System.out.println(name); 

        //Length in String we use .length() in String length is a function so () but in Arrays length was property so we used .length just.

        String fullname = "Pranjal Sharma";
        System.out.println(fullname.length()); // String counts space also in length 

        //Concatenation = To join with +
        String firstname = "Pranjal";
        String lastname = "Sharma";
        String myname = firstname + " " + lastname;  //Concatenation with hepl of +++ sign 
        System.out.println(myname);

        // charAt() function in String - To know which element is at which index 
        System.out.println(myname.charAt(0));
        funccharAt(myname);

        //Palindrome or not  TC = O(n)
        String palindrome = "racecar";
        System.out.println(palindrome(palindrome));

        //Ques WNEENESENNN TC O(n)
        String path = "NS";
        System.out.println(shortestpath(path));

        // Strings Compare 
        /*If we use == to compare the string it will provide wrong output since in string we check from object level but we check for the value inside new String points towards new string whereas str1 and str2 they both point towards same strings hence gives wrong output */
        // Here we have concept of Interning and we use .equals() for comparing
        String str3 = "Pranjal";
        String str4 = "Pranjal";
        String str5 = new String("Pranjal");


     
        if(str3 == str4){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        if(str3 == str5){
            System.out.println("Yes");// Wrong output
        }else {
            System.out.println("No");
        }

        if(str3.equals(str5)){
            System.out.println("Yes"); //correct output 
        }else{
            System.out.println("No");
        }

        //Substring 
        String subs = "Hello World";
        System.out.println(subs.substring(0,5)); // Inbuilt in JAVA for finding substring .substring(0,5)
        System.out.println(substring(subs, 0,5));
        

        //Largest String by Lexicographic order 
        // We use compareTo() this to compare in this 'a' 'A' are different means 'a' < 'A'
        // In compareToIgnore() our 'a' and 'A' are same = equal 
        // TC = O(x*n)
        String fruits[] = {"apple", "mango", "banana"};
        String largest = fruits[0];
        for(int i =0; i<fruits.length; i++){
            if( largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }
        System.out.println(largest);

        // String Builder 
        // TC = O(26)
        // Using string it was O(26*n)
        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a'; ch<='z'; ch++){
            sb.append(ch + " ");
        }
        System.out.println(sb);
        System.out.println(sb.length());

        // Convert First Letter to upper case 
        System.out.println("enter the sentence to be converted");
        String toconvert = sc.nextLine();
        System.out.println(toUpperCase(toconvert));

        // Compress The String 
        String com = "aaaabbbccd";
        System.out.println(compress(com));


    }
    
}
