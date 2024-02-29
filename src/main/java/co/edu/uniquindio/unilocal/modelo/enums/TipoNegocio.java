package co.edu.uniquindio.unilocal.modelo.enums;

public enum TipoNegocio {
    PANADERIA(001, "panaderia"),
    CAFETERIA(002, "cafeteria"),
    HOTEL(003, "hotel"),
    BAR(004, "bar"),
    RESTAURANTE(005, "restaurante"),
    DISCOTECA(006, "discoteca"),
    TIENDA(007, "tienda");

    private final int codigo;
    private final String tipoNegocio;

    TipoNegocio(int codigo, String tipoNegocio) {
        this.codigo = codigo;
        this.tipoNegocio = tipoNegocio;
    }
}
