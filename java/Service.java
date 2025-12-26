import java.util.*;

class Model {
    private int id;
    private String name;
    private String email;

    public Model(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}

public class Service {
    public static void main(String[] args) {
        Model user1 = new Model(1, "anku", "ankubieber01@gmail.com");

        List<Model> model = new ArrayList<>();

        model.add(user1);

        System.out.println(model.get(0).getName());

        System.out.println(user1.getName());

        user1.setName("banku");

        System.out.println(model.get(0).getName());

    }
}