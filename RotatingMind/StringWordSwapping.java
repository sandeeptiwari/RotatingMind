/*
 *  Input : “My \t India \t is great”
 *  output : great is India My;
*/

String s = "My \t India \t is great";
String[] split = s.split(" ");
String result = "";
for (int i = split.length - 1; i >= 0; i--) {
  result += (split[i] + " ");
}
System.out.println(result.trim());
