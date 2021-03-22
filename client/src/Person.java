import org.json.*;
public class Person {
    private String Code;
    private String Name;
    private String CPF;

    public Person(String Code, String name, String CPF) {
        this.Code = Code;
        Name = name;
        this.CPF = CPF;
    }
    public String getCode() {
        return Code;
    }

    public void setCodee(String CPF) {
        this.Code = Code;
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
            obj_to_return.put("Codee",OBJ_Person.getCode());
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
            person = new Person(obj.getString("Code"),obj.getString("Name"),obj.getString("CPF"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }
    @Override
    public String toString() {
        return "Person{" +
                "Code='" + Code + '\'' +
                ", Name='" + Name + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
