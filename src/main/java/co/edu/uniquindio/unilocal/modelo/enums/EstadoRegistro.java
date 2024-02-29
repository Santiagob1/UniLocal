package co.edu.uniquindio.unilocal.modelo.enums;

public enum EstadoRegistro {
    ACTIVO(001, "activo"),
    INACTIVO(002, "inactivo");

    private final int codigo;
    private final String estadoRegistro;

    EstadoRegistro(int codigo, String estadoRegistro) {
        this.codigo = codigo;
        this.estadoRegistro = estadoRegistro;
    }
}
