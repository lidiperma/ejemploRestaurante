
package ejemploServlet;

import entidades.Camarero;
import entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreaSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        //llamamos a una interfaz, llamada httpsession. 
        //Creamos una sesion y a la asociamos al usuario
        //En la sesión se guardan objetos, listas, variables
       HttpSession sesionRestaurante=request.getSession(true);
        
        Camarero ultimoCamarero=new Camarero();
        ultimoCamarero.setIdCamarero("1");
        ultimoCamarero.setNombre("Marta");
        ultimoCamarero.setApellido("Pepita");
     // Con el producto como le hemos llamado aqui sacamos toda la información que queremos ver, 
     //por ejemplo en un Restaurante el jefe quiere ver los datos que ha metido el camarero, se vera el del ultimo camarero registrado
       //Producto miproducto = new Producto(1, "telefono", 300);
       
       
          //coloca el objeto en la session
          sesionRestaurante.setAttribute("ejemploSesion", ultimoCamarero);
          
        //misession.setAttribute("producto", miproducto);
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>Producto en session</body></html>");
        pw.println("<h2>"+sesionRestaurante.isNew()+"</h2>");
        pw.close();
    }


@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
