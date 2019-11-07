package br.tbp;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

import java.io.File;

public class Application {

    public static void main(String[] args) throws ManagedProcessException {

        String userHome = System.getProperty("user.home");
        userHome = userHome + File.separator + "mariadb";
        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(3307); // OR, default: setPort(0); => autom. detect free port
        configBuilder.setDataDir(userHome); // just an example
        DB db = DB.newEmbeddedDB(configBuilder.build());
        db.start();
    }
}
