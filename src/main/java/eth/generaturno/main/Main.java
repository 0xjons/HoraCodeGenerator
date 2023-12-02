/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eth.generaturno.main;

import eth.generaturno.app.App;


/**
 *
 * @author 0xjons
 */
public final class Main {

    //clave de acceso: Declaramos la constante del serial como private para que 
    //no pueda ser accesible desde fuera.
    private static final String ACCESS_UID = "0xjons21442565426";

    //Punto de entrada al programa
    public static final void main(String[] args) {
        // Comenta temporalmente la verificación de ACCESS_UID
        // if (args.length == 1 && args[0].equals(ACCESS_UID)) {
        final App APP = new App();
        APP.launchApp();
        // } else {
        //     System.out.println("Acceso Denegado");
        //     ...
        // }
    }
}
