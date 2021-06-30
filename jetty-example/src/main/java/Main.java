public class Main {
    public static void main(String[] args) throws Exception {
        new ApplicationServer(8283, new RythmApplication()).start();
    }
}