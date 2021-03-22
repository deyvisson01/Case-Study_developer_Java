import org.json.*;
public class Person {
    private String Cod;
    private String Name;
    private String CPF;

    public Person(String Cod, String name, String CPF) {
        this.Cod = Cod;
        Name = name;
        this.CPF = CPF;
    }
    public String getCod() {
        return Cod;
    }

    public void setCod(String CPF) {
        this.Cod = CPF;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public JSONObject getJSONPerson(Person OBJ_Person){
        JSONObject obj_to_return = new JSONObject();
        try{
            obj_to_return.put("Cod",OBJ_Person.getCod());
            obj_to_return.put("Name",OBJ_Person.getName());
            obj_to_return.put("CPF",OBJ_Person.getCPF());
        }catch (JSONException e){
            System.out.println(e);
        }
        return obj_to_return;
    }
    public Person convertStrJSONToPerson(String JSONSTRPerson){
        Person person = null;
        try {
            JSONObject obj = new JSONObject(JSONSTRPerson);
            person = new Person(obj.getString("Cod"),obj.getString("Name"),obj.getString("CPF"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }
    @Override
    public String toString() {
        return "Person{" +
                "Cod='" + Cod + '\'' +
                ", Name='" + Name + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
