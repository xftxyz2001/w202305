public class Quine {
    public static void main(String[] args) {
        String str = """
public class Quine {
    public static void main(String[] args) {""";
        String secondStr = """
        System.out.println(str);
        System.out.println("        String str = " + '"' + '"' + '"');
        System.out.println(str + '"' + '"' + '"' + ';');
        System.out.println("        String secondStr = " + '"' + '"' + '"');
        System.out.print(secondStr);
        System.out.println("" + '"' + '"' + '"' + ';');
        System.out.print(secondStr);
        System.out.println("    }");
        System.out.println("}");
""";
        System.out.println(str);
        System.out.println("        String str = " + '"' + '"' + '"');
        System.out.println(str + '"' + '"' + '"' + ';');
        System.out.println("        String secondStr = " + '"' + '"' + '"');
        System.out.print(secondStr);
        System.out.println("" + '"' + '"' + '"' + ';');
        System.out.print(secondStr);
        System.out.println("    }");
        System.out.println("}");
    }
}