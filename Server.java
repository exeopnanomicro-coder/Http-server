import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java .util.Scanner;

public class Server {
    public static void main(String args[])throws Exception{
    ServerSocket server = new ServerSocket(8080);
    System.out.println("Server is listening on port 8080");
    System.out.println("the server is started in http://localhost:8080 ");
    while(true){
        Socket ServerAccept = server.accept();
        System.out.println("Client connected:");
        Scanner sc = new Scanner(ServerAccept.getInputStream());
        
        if(sc.hasNextLine()){
            String request = sc.nextLine();
            System.out.println("Received request: " + request);
        }else{
            System.out.println("No request received from client.");     
    }
    PrintWriter out = new PrintWriter(ServerAccept.getOutputStream(), true);
    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" +
                          "<html><body><h1>NaNiiiiiiiiiiiiii i Build My First Web Server</h1></body></html>";
    out.println(httpResponse);
    out.flush();
    ServerAccept.close();
    }
}}