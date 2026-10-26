package strings;
public class StringReverse {
    public static void main(String[] args) {
        //Approch1:
        String str = "Deepak";
        char ch[] = str.toCharArray();
        for (int i=ch.length-1;i>=0;i--)
        {
            System.out.print(ch[i]);
        }
        System.out.println(" ");
        //Approch 2
        for(int i= str.length()-1;i>=0;i--)
        {
            System.out.print(str.charAt(i));
        }
        System.out.println(" ");
        //Approach-3
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }
}
