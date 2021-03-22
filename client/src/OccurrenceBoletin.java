import org.json.JSONException;
import org.json.JSONObject;

public class OccurrenceBoletin {

    private String Cod_sale;
    private Person Person;
    private String Cod_product;
    private String Cliente;
    private String Date_Of_Sale;
    private String Quantidade;
    private String Valor_Final;

    public OccurrenceBoletin(String cod_sale, 
                            Person person, 
                            String cod_product,
                            String cliente,
                            String date_Of_Birth,
                            String quantidade,
                            String valor_Final ) {

        this.Cod_sale = cod_sale;
        this.Person = person;
        this.Cod_product = cod_product;
        this.Cliente = cliente;
        this.Date_Of_Sale = date_Of_Birth;
        this.Quantidade = quantidade;
        this.Valor_Final = valor_Final;
    }

    public Cod_sale getCod_sale() {
        return Cod_sale;
    }

    public void setCod_sale(String cod_sale) {
        Cod_sale = cod_sale;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person person) {
        Person = person;
    }

    public String getCod_product() {
        return Cod_product;
    }

    public void setCod_product(String cod_product) {
        Cod_product = cod_product;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public boolean isDate_Of_Sale() {
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
            obj_to_return.put("Cod_sale",occurrenceBoletin.getCod_sale().getJSONPerson(occurrenceBoletin.getCod_sale()));
            obj_to_return.put("Person",occurrenceBoletin.getPerson().getJSONPerson(occurrenceBoletin.getPerson()));
            obj_to_return.put("Cod_product",occurrenceBoletin.getCod_product());
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
            boletin = new OccurrenceBoletin(person,obj.getString("Cod_product"),obj.getString("Cliente"),obj.getBoolean("Date_Of_Sale"),obj.getString("Quantidade"),obj.getString("Valor_Final"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return boletin;
    }

    @Override
    public String toString() {
        return "OccurrenceBoletin{" +
                "Cod_sale=" + Cod_sale +
                ", Person=" + Person +
                ", Cod_product='" + Cod_product + '\'' +
                ", Cliente='" + Cliente + '\'' +
                ", Date_Of_Sale=" + Date_Of_Sale +
                ", Quantidade='" + Quantidade + '\'' +
                ", Valor_Final=" + Valor_Final +
                '}';
    }
}
