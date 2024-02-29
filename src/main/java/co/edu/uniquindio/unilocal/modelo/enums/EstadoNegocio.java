package co.edu.uniquindio.unilocal.modelo.enums;

public enum EstadoNegocio {

    APROVADO(001, "aprobado"),
    RECHAZADO(002, "rechazado"),
    PENDIENTE(003, "pendiente");

    private final int codigo;
    private final String estado;

    EstadoNegocio(int codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }
}
