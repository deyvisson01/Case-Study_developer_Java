import org.json.JSONException;
import org.json.JSONObject;

public class OccurrenceBoletin {

    private String Code_sale;
    private Person Person;
    private String Code_product;
    private String Cliente;
    private String Date_Of_Sale;
    private String Quantidade;
    private String Valor_Final;

    public OccurrenceBoletin(String code_sale, 
                            Person person, 
                            String code_product,
                            String cliente,
                            String date_Of_Sale,
                            String quantidade,
                            String valor_Final ) {

        this.Code_sale = code_sale;
        this.Person = person;
        this.Code_product = code_product;
        this.Cliente = cliente;
        this.Date_Of_Sale = date_Of_Sale;
        this.Quantidade = quantidade;
        this.Valor_Final = valor_Final;
    }

    public Code_sale getCode_sale() {
        return Code_sale;
    }

    public void setCode_sale(String code_sale) {
        Code_sale = code_sale;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person person) {
        Person = person;
    }

    public String getCode_product() {
        return Code_product;
    }

    public void setCode_product(String code_product) {
        Code_product = code_product;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getisDate_Of_Sale() {
        return Date_Of_Sale;
    }

    public void setDate_Of_Sale(boolean date_Of_Sale) {
        Date_Of_Sale = date_Of_Sale;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String quantidade) {
        Quantidade = quantidade;
    }

    public String getValor_Final() {
        return Valor_Final;
    }

    public void setValor_Final(String valor_Final) {
        Valor_Final = valor_Final;
    }

    public JSONObject getJSONOccurenceBoletin(OccurrenceBoletin occurrenceBoletin){
        JSONObject obj_to_return = new JSONObject();
        try{
            obj_to_return.put("Code_sale",occurrenceBoletin.getCode_sale().getJSONPerson(occurrenceBoletin.getCode_sale()));
            obj_to_return.put("Person",occurrenceBoletin.getPerson().getJSONPerson(occurrenceBoletin.getPerson()));
            obj_to_return.put("Code_product",occurrenceBoletin.getCode_product());
            obj_to_return.put("Cliente",occurrenceBoletin.getCliente());
            obj_to_return.put("Date_Of_Sale",occurrenceBoletin.isDate_Of_Sale());
            obj_to_return.put("Quantidade",occurrenceBoletin.getQuantidade());
            obj_to_return.put("Valor_Final",occurrenceBoletin.getValor_Final());
        }catch (JSONException e){
            System.out.println(e);
        }
        return obj_to_return;
    }

    public OccurrenceBoletin convertStrJSONToOccurrenceBoletin(String JSONSTROccurrenceBoletin){
        OccurrenceBoletin boletin = null;
        Person person = new Person("","","","","");
        try {
            JSONObject obj = new JSONObject(JSONSTROccurrenceBoletin);
            person = person.convertStrJSONToPerson(obj.get("Person").toString());
            boletin = new OccurrenceBoletin(person,obj.getString("Code_product"),obj.getString("Cliente"),obj.getBoolean("Date_Of_Sale"),obj.getString("Quantidade"),obj.getString("Valor_Final"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return boletin;
    }

    @Override
    public String toString() {
        return "OccurrenceBoletin{" +
                "Code_sale=" + Code_sale +
                ", Person=" + Person +
                ", Code_product='" + Code_product + '\'' +
                ", Cliente='" + Cliente + '\'' +
                ", Date_Of_Sale=" + Date_Of_Sale +
                ", Quantidade='" + Quantidade + '\'' +
                ", Valor_Final=" + Valor_Final +
                '}';
    }
}
