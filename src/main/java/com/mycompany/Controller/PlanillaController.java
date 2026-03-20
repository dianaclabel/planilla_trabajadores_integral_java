
package com.mycompany.Controller;

import com.company.Model.EmpleadoModel;
import com.company.Model.ObreroModel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "PlanillaController", urlPatterns = {"/PlanillaController"})
public class PlanillaController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PlanillaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PlanillaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
                // 1.- Recibir los parametros del formulario web
               String nombre = request.getParameter("inNombre");
               String apellidos = request.getParameter("inApellidos");
               int tipoTrabajador = Integer.parseInt(request.getParameter("selTipoTrabajador"));
               int cargo = Integer.parseInt(request.getParameter("selCargo"));
               // Convertimos el datos a boolean 
               String asignacion = request.getParameter("recibeAsignacion");
               boolean tieneAsignacion = (asignacion!= null);
               
        // 2.- Crear el objeto y enviar los parametros al constructor (MODEL)
               String resultado = "";
               switch (tipoTrabajador) {
                case 1:
                   EmpleadoModel objEmpleado = new EmpleadoModel(nombre, apellidos,cargo,tipoTrabajador,tieneAsignacion); 
                   resultado = objEmpleado.mostrarResultados();
                    break;
                case 2:
                    ObreroModel objObrero = new ObreroModel(nombre, apellidos,cargo,tipoTrabajador,tieneAsignacion);
                    resultado = objObrero.mostrarResultados();
                    break;
                }      
        // 3.- Crear una variable de sesion
               HttpSession sTrabajador = request.getSession();
        // 4.- Recibo el resultado desde el Model (metodos)
              
               sTrabajador.setAttribute("sResultado", resultado);
              
        // 5.- Enviar resultados a la web*/
               response.sendRedirect("PlanillaView.jsp"); 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
