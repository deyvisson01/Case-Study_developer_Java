import java.util.ArrayList;

public class Functions {

    public static ArrayList<Person> ListPerson = new ArrayList<>();
    public static ArrayList<OccurrenceBoletin> ListBO = new ArrayList<>();
    public static ArrayList<Message> ListMensagens = new ArrayList<>();

    public Message doOperation(Message msgToSend){
        System.out.println("SEND -------->");
        System.out.println(msgToSend.toString());
        Message return_msg = msgToSend;
        SocketClient socketClient = new SocketClient("127.0.0.1",2008,1557);
        socketClient.send(msgToSend.getJSONMessage(msgToSend).toString());
        //return_msg = return_msg.convertStrJSONToMessage(socketClient.request());
        System.out.println("REPLY -------->");
        System.out.println(return_msg.toString());
        if((msgToSend.getRequestId()==return_msg.getRequestId())){
            System.out.println("Respondeu a mensagem certa");
        }else{
           System.out.println("Respondeu a mensagem errada");
        }
        socketClient.closeAll();
        return return_msg;
    }
    public void ListSellers(){
        if(ListPersonSellers.size()>0){
            for(Person seller:ListPersonSellers){
                System.out.println("    > "+seller.getCode()+" <->"+seller.getName());
            }
        }else{
            System.out.println("Empty!");
        }
    }
    
    public void ListBO(){
        if(ListBO.size()>0){
            for(OccurrenceBoletin bo:ListBO){
                System.out.println("  "+bo.getCode_sale()+  " <-> "+bo.getPerson().getName()+" <-> "+bo.getCode_product()+" <-> "+bo.getCliente()+" <-> "+bo.getisDate_Of_Sale()+" <-> "+bo.getQuantidade()+" <-> "+bo.getValor_Final());
            }
        }else{
            System.out.println("Empty!");
        }
    }

    public boolean isCodeListSellers(String Code){ // Retorna true se tiver um vdendedor com esse código cadastrada
        boolean ret = false;
        for(Person seller:ListPersonSellers){
            if(seller.getCode().equals(Code)){
                ret = true;
                break;
            }
        }
        return ret;
    }
}
