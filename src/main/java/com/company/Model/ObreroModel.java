
package com.company.Model;

import com.company.Interface.PensionInterface;
import com.company.Interface.SeguroInterface;
import com.mycompany.Entidad.TrabajadorEntidad;

public class ObreroModel extends TrabajadorEntidad implements PensionInterface, SeguroInterface{

    public ObreroModel(String nombre, String apellido, int cargo, int tipoTrabajador, boolean tieneAsignacion) {
        super(nombre, apellido, cargo, tipoTrabajador, tieneAsignacion);
        this.porcentajeSeguro = 0.09; // Essalud
        this.porcentajePension =  0.13;// ONP
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
        // Aseguramos que los cálculos se ejecuten antes de armar la boleta
        this.calcularPensiones();
        this.calcularSeguro();
        this.calcularGratificacion();

        double totalIngresos = this.sueldoBruto + this.asignacionFamiliar + this.comision + this.gratificacion + this.pagoFeriados;
        double totalDescuentos = this.adelanto + this.fondoPension;
        double sueldoNeto = totalIngresos - totalDescuentos;
        
        // Formato para alinear: 30 espacios a la izquierda para el texto, 10 para el número
        String formatoFila = "%-30s S/ %10.2f\n";

        return "=================================================<br>" +
       "             BOLETA DE PAGO DICIEMBRE 2025       <br>" +
       "=================================================<br>" +
       "TRABAJADOR: " + this.nombre + " " + this.apellido + "<br>" +
       "CARGO: " +  this.cargo + " | TIPO: " + this.tipoTrabajador + "<br>" +
       "-------------------------------------------------<br>" +
       "INGRESOS:<br>" +
       String.format(formatoFila, "  Sueldo Base:", this.sueldoBruto) +  "<br>" +
       String.format(formatoFila, "  Asig. Familiar:", this.asignacionFamiliar) +  "<br>" +
       String.format(formatoFila, "  Comisión:", this.comision) +  "<br>" +
       String.format(formatoFila, "  Pago Feriados:", this.pagoFeriados) +  "<br>" +
       String.format(formatoFila, "  Gratificación (+Bono):", this.gratificacion) +  "<br>" +
       "-------------------------------------------------<br>" +
       String.format(formatoFila, "TOTAL INGRESOS:", totalIngresos) +  "<br>" +
       "<br>DESCUENTOS:<br>" +
       String.format(formatoFila, "  Adelanto:", this.adelanto) +  "<br>" +
       String.format(formatoFila, "  ONP (13%):", this.fondoPension) +  "<br>" +
       "-------------------------------------------------<br>" +
       String.format(formatoFila, "TOTAL DESCUENTOS:", totalDescuentos) +  "<br>" +
       "<br>APORTACIONES (A cargo del empleador):<br>" +
       String.format(formatoFila, "  EsSalud (9%):", this.seguro) +  "<br>" +
       "-------------------------------------------------<br>" +
       String.format(formatoFila, "SUELDO NETO A PAGAR:", sueldoNeto) + "<br>" +
       "=================================================";
        
    }
    
}
