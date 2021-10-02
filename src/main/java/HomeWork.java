import connect.ConnectToDb;
import connect.Queries;

public class HomeWork {

    public static void main(String[] args) {

        Queries engine = new Queries();

        ConnectToDb.connenct();

        System.out.println(engine.usersData());
    }
}
