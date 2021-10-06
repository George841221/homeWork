import config.Helper;
import connect.ConnectToDb;
import connect.Queries;

public class HomeWork {

    public static void main(String[] args) {

        ConnectToDb.connenct();

        System.out.println(Queries.usersData(Helper.statusUsersData));
        System.out.println();
       // System.out.println(Queries.test(Helper.allUsersData));
    }
}
