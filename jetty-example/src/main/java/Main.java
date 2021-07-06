public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationServer server = new ApplicationServer(8283, new MyApplication());
        server.start();
    }
}