package Run;
// Q.2) Write a Java Program to implement I/O Decorator for converting uppercase letters to lower case letters.

public class changeCase
{
public static void main(String[] args)
{
String str1="Software Architecture & Design Pattern List of Assignments";
StringBuffer newStr=new StringBuffer(str1);
System.out.println("\nString before case conversion : ");
System.out.println(newStr);
for(int i = 0; i < str1.length(); i++)
{
//Checks for lower case character
//if(Character.isLowerCase(str1.charAt(i)))
//{
//Convert it into upper case using toUpperCase() function
//newStr.setCharAt(i, Character.toUpperCase(str1.charAt(i)));
//}
//Checks for upper case character
//else
if(Character.isUpperCase(str1.charAt(i)))
{
//Convert it into upper case using toLowerCase() function
newStr.setCharAt(i, Character.toLowerCase(str1.charAt(i)));
}
}
System.out.println("\n String after case conversion : ");
System.out.println(newStr);
}
}