package br.tbp;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

import java.io.File;

public class Application {

    public static void main(String[] args) throws ManagedProcessException {

        String userHome = System.getProperty("user.home");
        userHome = userHome + File.separator + "mariadb";
        int port = 3307;
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(port); // OR, default: setPort(0); => autom. detect free port
        configBuilder.setDataDir(userHome); // just an example
        DB db = DB.newEmbeddedDB(configBuilder.build());
        System.out.println("MariaDB started. Port: " + port + " ; Host: localhost ; user: root ; password: ''" );
        db.start();


    }
}
