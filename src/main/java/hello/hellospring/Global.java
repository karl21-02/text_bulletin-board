package hello.hellospring;

import hello.hellospring.db.DBConnection;
import hello.hellospring.member.Member;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.time.LocalDate;
import java.util.Scanner;

public class Global {
    private static Scanner scanner;
    private static Member loginedMember;
    private static DBConnection dbConnection;

    public static void initScanner() {
        scanner = new Scanner(System.in);
    }

    public static void exitScanner() {
        scanner.close();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static DBConnection getDbConnection() {
        if(dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }


    public static Member getLoginedMember() {
        return loginedMember;
    }

    public static void setLoginedMember(Member member) {
        loginedMember = member;
    }

    public static String nowDateTime() {
        String now = LocalDate.now().toString();
        return now;
    }
}
