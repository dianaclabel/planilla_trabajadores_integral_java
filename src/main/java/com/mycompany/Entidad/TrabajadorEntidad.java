
package com.mycompany.Entidad;


public abstract  class TrabajadorEntidad {
    //Datos basicos
    public String nombre;
    public String apellido;
    public int cargo;
    public int tipoTrabajador;
    
    //ingresos
    protected double sueldoBruto = 0;
    protected double asignacionFamiliar = 0;
    protected double gratificacion;
    protected double comision = 0;
    
    //descuentos
    protected double adelanto = 0;
    protected double fondoPension;// AFP o ONP
    
    //Aportaciones
    protected double seguro; //esaalud o EPS
    
    //otros
    protected double porcentajePension = 0;
    protected double porcentajeSeguro = 0;
    protected double remuneracionMinvital = 1130.00;
    protected boolean tieneAsignaciónFamiliar;
    protected int diasFeriadosLaborales = 3;
    protected double pagoFeriados = 0;
   

    public TrabajadorEntidad(String nombre, String apellido, int cargo, int tipoTrabajador, boolean tieneAsignacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.tipoTrabajador = tipoTrabajador;
        this.tieneAsignaciónFamiliar = tieneAsignacion;
        
        this.SeleccionarSueldo(cargo);        
        this.calcularComision();
        this.adelantoDeSueldo();
        this.calcularAsignacionFamiliar();
        this.calcularPagoFeriados();
    }
    
    
   private void SeleccionarSueldo(int cargo){
       switch (cargo) {
            case 1:
                this.sueldoBruto = 4000.00;
                break; 

            case 2:
                 this.sueldoBruto = 2500.00;
                break; 

            case 3:
                 this.sueldoBruto = 2500.00;
                break; 
            case 4:
                this.sueldoBruto = 2000.00;
                break;
            case 5:
                this.sueldoBruto = 2500.00;
                break; 
            case 6:
                this.sueldoBruto = 2500.00;
                break; 
            case 7:
                this.sueldoBruto = 1500.00;
                break;
            case 8:
                this.sueldoBruto = 1500.00;
                break;
            case 9:
                this.sueldoBruto = 1500.00;
                break;
       }
   }
    
    
    private void calcularComision() {
        if( this.cargo == 5 || this.cargo == 6 ){
            this.comision = this.sueldoBruto * 0.10; 
        } else if( this.tipoTrabajador == 2){
             this.comision = this.sueldoBruto * 0.08; 
        }
    }
    
    private void adelantoDeSueldo(){
          this.adelanto = this.sueldoBruto * 0.50; 
     }
     
    private void calcularAsignacionFamiliar(){
          if(this.tieneAsignaciónFamiliar == true){
              this.asignacionFamiliar = this.remuneracionMinvital * 0.10; 
          } 
     } 
     
    //CalculoDiasferiadosLaborales
     private void calcularPagoFeriados(){
          this.pagoFeriados =  (this.sueldoBruto / 30) * this.diasFeriadosLaborales;
     } 
     
     
    protected abstract void calcularGratificacion();
    
    public abstract String mostrarResultados();
    
    
    
   
    
    
}
