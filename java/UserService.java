import java.util.List;
import java.util.ArrayList;

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

}

public class UserService {

    public static Model findUserByEmail(List<Model> Users, String targetEmail) {
        for (Model m : Users) {
            if (m.getEmail().equals(targetEmail)) {
                return m;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Model> Users = new ArrayList<>();
        Users.add(new Model(1, "Alice", "alice@example.com"));
        Users.add(new Model(2, "Charlie", "charlie@gmail.com"));
        Users.add(new Model(3, "Dana", "dana@outlook.com"));

        Model result = findUserByEmail(Users, "alice@example.com");

        if (result != null) {
            System.out.println("Username: " + result.getName());

        } else {
            System.out.println("User not found for email: bob@example.com");
        }

    }
}