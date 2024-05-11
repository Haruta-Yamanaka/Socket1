import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
public class JankenServer {
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Janken janken = (Janken) ois.readObject();// Integerクラスでキャスト。

//ここからじゃんけんの処理に切り替える
            String result =  "Draw";

                Random r = new Random();
                int a = r.nextInt(3);
                String[] j = {"グー","チョキ","パー"}; //　0グー　1チョキ　2パー
                int handSign = janken.getHand();

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Janken response = new Janken();
            if(handSign > 2 || handSign <0  ){
                response.setMessage("不正な入力値です");
                ois.close();
                socket.close();
                server.close();
            }
            else{
                if(handSign == 0 && a == 2){
                    result = "You win!";
                }
                else if(a - handSign ==1){
                    result = "You win!";
                }

                if(handSign == 2 && a == 0){
                    result ="You lose...";
                }
                else if(handSign - a == 1){
                    result ="You lose...";
                }
                if(a == handSign){
                    result = "Draw";
                }

                System.out.println("出した手は" + j[handSign]);
                
                response.setMessage(result+" サーバーが出した手は"+j[a]+"です");

            response.setResult(result);

            oos.writeObject(response);
        

            // close処理

            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();
            }

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
