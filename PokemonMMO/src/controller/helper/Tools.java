/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.helper;

/**
 *
 * @author mario
 */
public class Tools {
    public static void calculateMapT() {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            int y = 0;
            for (int r = 0; r < 2; r++) {
                System.out.println("<tile>");
                System.out.println("    <properties>");
                System.out.println("        <property name=\"startW\" type=\"int\" value=\"" + x + "\"/>");
                System.out.println("    </properties>");
                System.out.println("    <properties>");
                System.out.println("        <property name=\"startH\" type=\"int\" value=\"" + y + "\"/>");
                System.out.println("    </properties>");
                System.out.println("</tile>");
                y += 16;
            }
            x += 16;
        }
    }
}
