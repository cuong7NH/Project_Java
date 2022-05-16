package src;

import src.controller.*;
import src.view.*;

import java.awt.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuManagerView menuManagerView = new MenuManagerView();
                menuManagerView.setVisible(true);

                MenuManagerController menuManagerController = new MenuManagerController(
                        menuManagerView
                );
            }
        });
    }
}
