import java.io.Serializable;
public class Janken implements Serializable{
private int hand;
private String message;
private String result;
public int getHand(){
    return hand;
}

public void setHand(int hand){
    this.hand =  hand;
}

public String getMessage(){
    return message;
}

public void setMessage(String message) {
    this.message = message;
}

public void setResult(String result){
    this.result = result;
}

public String getResult(){
    return result;
}


}
