package com.alura.hotel.hotelAlura;

import com.alura.hotel.hotelAlura.controller.sesionController;
import com.alura.hotel.hotelAlura.model.sesionModel;
import com.alura.hotel.hotelAlura.views.MenuPrincipal;
import com.alura.hotel.hotelAlura.views.MenuUsuario;
import java.awt.*;

public class App 
{
	private static final sesionController session = new sesionController();
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            sesionModel session1 = session.obtenerSession();
            try {
                if(session1.getIdusuario() == null) {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } else {
                    MenuUsuario frame = new MenuUsuario();
                    frame.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
