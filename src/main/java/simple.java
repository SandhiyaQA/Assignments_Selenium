public class simple {
    public static void main(String[] args) {
        String s = "+ 45.78 %";
        String s1="N.A";
        System.out.println(java.lang.Float.parseFloat(s.substring(2,7)));
        System.out.println(java.lang.Float.parseFloat(s1.replace("N.A","0.0")));

    }
}
