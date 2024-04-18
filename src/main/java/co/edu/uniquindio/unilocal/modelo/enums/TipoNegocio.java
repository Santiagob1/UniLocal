package co.edu.uniquindio.unilocal.modelo.enums;

public enum TipoNegocio {
    PANADERIA(001, "PANADERIA"),
    CAFETERIA(002, "CAFETERIA"),
    HOTEL(003, "HOTEL"),
    BAR(004, "BAR"),
    RESTAURANTE(005, "RESTAURANTE"),
    DISCOTECA(006, "DISCOTECA"),
    TIENDA(007, "TIENDA");

    private final int codigo;
    private final String tipoNegocio;

    TipoNegocio(int codigo, String tipoNegocio) {
        this.codigo = codigo;
        this.tipoNegocio = tipoNegocio;
    }
}
