package com.mycompany.wais;

import com.mycompany.modules.DatabaseUtility;
import com.mycompany.userinterface.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DatabaseUtility.getConnection();
        new LoginPage().setVisible(true);
    }
}
