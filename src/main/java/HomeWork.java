import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import config.Helper;
import connect.ConnectToDb;
import connect.Queries;

public class HomeWork {

    public static void main(String[] args) {

        ConnectToDb.connectToMyDb();

        System.out.println(Queries.usersData(Helper.allUsersData));
        System.out.println();
        System.out.println(Queries.usersData(Helper.statusUsersData));
        System.out.println();
        Queries.sourcingUserFromDb(Helper.selectFromDbAUser, "Pista Bácsi");
        System.out.println();
        System.out.println(Queries.oneUserAllBlogs(Helper.aUserAllBlogs, "Nedry"));
    }
}
