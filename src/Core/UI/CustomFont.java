package Core.UI;

import java.awt.Font;
import java.io.InputStream;

public class CustomFont {

    private Font font = null;
    public String Roboto_Regular = "Roboto-Regular.TTF";
    public String Roboto_Black = "Roboto-Black.TTF";
    public String Roboto_Light = "Roboto-Light.TTF";

    /* Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
	 * tamanio = float
	 */
    
    public Font Font( String fontName, int estilo, float tamanio)
    {
         try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream("/Fonts/" + fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " Error to try load custom font");
            font = new Font("Arial", Font.PLAIN, 14);            
        }
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }

}
