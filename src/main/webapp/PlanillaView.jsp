

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="PlanillaController" method="POST">
            <h4>Salario del mes de Diciembre 2025</h4>    
            <br><!-- comment -->
            <label>Nombre</label>
            <input type="text" name="inNombre"/>
            <br><!-- comment -->
            <br><!-- comment -->
            <label>Apellidos</label>
            <input type="text" name="inApellidos"/>
            <br><!-- comment -->      
            <br><!-- comment -->
            <label>Tipo de trabajador</label>
            <br><!-- comment --> 
            <select name="selTipoTrabajador">
               <option value="0">Seleccione...</option>
               <option value="1">Empleado</option>
               <option value="2">Obrero</option>
            </select>
            <br><!-- comment --> 
            <br><!-- comment -->
            <label>Tipo de Cargo</label>
            <br><!-- comment --> 
            <select name="selCargo">
               <option value="0">Seleccione...</option>
               <option value="1">Gerencia</option>
               <option value="2">Contador</option>
               <option value="3">Administrador</option>
               <option value="4">Administrativo I</option>
               <option value="5">Vendedor I</option>
               <option value="6">Vendedor II</option>
               <option value="7">operario I</option>
               <option value="8">operario II</option>
               <option value="9">operario III</option>
            </select>
            <br><!-- comment -->  
            <br><!-- comment -->
            <label>
                <input type="checkbox" name="recibeAsignacion" value="true">
                ¿Recibe Asignación Familiar?
            </label>
             <br><!-- comment --> 
             <br><!-- comment -->
            
            <button type="submit">Enviar</button>
            <br><!-- comment -->   
            <br><!-- comment -->
            
          
                       
            <label>Resultado: ${sResultado} </label> 
             
        </form>
    </body>
</html>
