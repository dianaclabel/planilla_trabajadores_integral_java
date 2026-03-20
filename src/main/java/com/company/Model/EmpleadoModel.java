
package com.company.Model;

import com.company.Interface.PensionInterface;
import com.company.Interface.SeguroInterface;
import com.mycompany.Entidad.TrabajadorEntidad;


public class EmpleadoModel extends TrabajadorEntidad implements PensionInterface, SeguroInterface{
    

    public EmpleadoModel(String nombre, String apellido, int cargo, int tipoTrabajador, boolean tieneAsignacion) {
        super(nombre, apellido, cargo, tipoTrabajador, tieneAsignacion);
        this.porcentajeSeguro = 0.0675; // EPS
        this.porcentajePension =  0.125;// AFP 
    }

    @Override
    protected void calcularGratificacion() {
        double bonoExtra = this.sueldoBruto * porcentajeSeguro;
        this.gratificacion = this.sueldoBruto + bonoExtra;
    }

    @Override
    public void calcularPensiones() {
       this.fondoPension = this.sueldoBruto * this.porcentajePension;
    }

    @Override
    public void calcularSeguro() {
       this.seguro = this.sueldoBruto * this.porcentajeSeguro;
    }

    @Override
    public String mostrarResultados() {
    this.calcularPensiones();
    this.calcularSeguro();
    this.calcularGratificacion();

    double totalIngresos = this.sueldoBruto + this.asignacionFamiliar + this.comision + this.pagoFeriados + this.gratificacion;
    double totalDescuentos = this.adelanto + this.fondoPension;
    double netoAPagar = totalIngresos - totalDescuentos;

    // Usamos un formato
    String formatoFila = "%-30s S/ %10.2f\n";

    return "--------------------------------------------------------------------------------<br>" +
           "                      BOLETA DE PAGO DICIEMBRE 2025                             <br>" +
           "--------------------------------------------------------------------------------<br>" +
           "Trabajador: " + nombre + " " + apellido + "<br>" +
           "Cargo: " + cargo + " | Tipo: " + tipoTrabajador + "<br>" +
           "--------------------------------------------------------------------------------<br>" +
           "INGRESOS:<br>" +
           String.format(formatoFila, "  Sueldo Bruto:", sueldoBruto) + "<br>" +
           String.format(formatoFila, "  Asignación Familiar:", asignacionFamiliar) + "<br>" +
           String.format(formatoFila, "  Comisión:", comision) + "<br>" +
           String.format(formatoFila, "  Pago Feriados:", pagoFeriados) + "<br>" +
           String.format(formatoFila, "  Gratificación (+Bono):", gratificacion) + "<br>" +
           "--------------------------------------------------------------------------------<br>" +
           String.format(formatoFila, "TOTAL INGRESOS:", totalIngresos) + "<br>" +
           "<br>DESCUENTOS:<br>" +
           String.format(formatoFila, "  Adelanto de Sueldo:", adelanto) + "<br>" +
           String.format(formatoFila, "  Fondo Pensión (AFP):", fondoPension) + "<br>" +
           "--------------------------------------------------------------------------------<br>" +
           String.format(formatoFila, "TOTAL DESCUENTOS:", totalDescuentos) + "<br>" +
           "<br>APORTACIONES (Empleador):<br>" +
           String.format(formatoFila, "  Seguro (EPS):", seguro) + "<br>" +
           "--------------------------------------------------------------------------------<br>" +
           String.format(formatoFila, "NETO A PAGAR:", netoAPagar) + "<br>" +
           "--------------------------------------------------------------------------------";
        
    }
        

    
}
    

