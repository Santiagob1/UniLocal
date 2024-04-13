db = connect('mongodb://localhost:27017/Unilocal?authSource=admin' );
db.clientes.insertMany([
    {
        _id: '1',
        nickName: 'pperez',
        ciudad: 'Armenia',
        fotoPerfil: 'foto.png',
        nombre: 'Pepe perez',
        password: '1234',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Cliente'
    },
    {
        _id: '2',
        nickName: 'eeee',
        ciudad: 'Armenia',
        fotoPerfil: 'eee.png',
        nombre: 'Andrea Perez',
        password: '1234',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Cliente'
    },
    {
        _id: '3',
        nickName: 'rrrr',
        ciudad: 'Armenia',
        fotoPerfil: 'rrrr.png',
        nombre: 'Rodrigo perez',
        password: '1234',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Cliente'
    },
    {
        _id: '4',
        nickName: 'wwww',
        ciudad: 'Armenia',
        fotoPerfil: 'wwww.png',
        nombre: 'William perez',
        password: '1234',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.cliente'
    },
    {
        _id: '5',
        nickName: 'tttt',
        ciudad: 'Armenia',
        fotoPerfil: 'tttt.png',
        nombre: 'Tatiana perez',
        password: '1234',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.cliente'
    }
]);

db.negocios.insertMany([
    {
        _id: '1',
        codigoCliente: '1',
        ubicacion: {
            latitud: 4.5201130,
            longitud: -76.4515260
        },
        nombre: 'Negocio 1',
        descripcion: 'Descripcion del negocio 1',
        horario: [
            {
                horaInicio: '08:00',
                horaFin: '21:00',
                dia: 'Martes'
            }
        ],
        estado: 'PENDIENTE',
        estadoRegistro: 'ACTIVO',
        tipoNegocio: 'BAR',
        fechaRechazo: '13-04-2024',
        imagenes: ['imagen1.png', 'imagen2.png'],
        lstMenuNegocio: [
            {
                _id: '1',
                codigoNegocio: '2',
                descripcion: 'Descripción negocio',
                precio: 50000
            }
        ],
        historialRevisiones: [
            {
                _id: '1',
                codigoModerador: '1',
                descripcion: 'Historial realizado',
                estadoNegocio: 'APROBADO',
                fecha: '13-04-2024'
            }
        ],
        teleonos: ['3243454353', '2342345435'],
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Negocio'
    },
    {
        _id: '2',
        codigoCliente: '2',
        ubicacion: {
            latitud: 4.45456,
            longitud: -77.84965845
        },
        nombre: 'Negocio 2',
        descripcion: 'Descripcion del negocio 2',
        horario: [
            {
                horaInicio: '08:00',
                horaFin: '21:00',
                dia: 'Lunes'
            }
        ],
        estado: 'PENDIENTE',
        estadoRegistro: 'ACTIVO',
        tipoNegocio: 'PANADERIA',
        fechaRechazo: '13-04-2024',
        imagenes: ['imagen1.png', 'imagen2.png'],
        lstMenuNegocio: [
            {
                _id: '2',
                codigoNegocio: '2',
                descripcion: 'Descripción negocio',
                precio: 50000
            }
        ],
        historialRevisiones: [
            {
                _id: '1',
                codigoModerador: '2',
                descripcion: 'Historial realizado',
                estadoNegocio: 'APROBADO',
                fecha: '13-04-2024'
            }
        ],
        teleonos: ['434354', '435435'],
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Negocio'
    },
    {
        _id: '3',
        codigoCliente: '3',
        ubicacion: {
            latitud: 4.778786,
            longitud: -90.7457645
        },
        nombre: 'Negocio 3',
        descripcion: 'Descripcion del negocio 3',
        horario: [
            {
                horaInicio: '08:00',
                horaFin: '21:00',
                dia: 'Miercoles'
            }
        ],
        estado: 'PENDIENTE',
        estadoRegistro: 'ACTIVO',
        tipoNegocio: 'DISCOTECA',
        fechaRechazo: '13-04-2024',
        imagenes: ['imagen1.png', 'imagen2.png'],
        lstMenuNegocio: [
            {
                _id: '3',
                codigoNegocio: '3',
                descripcion: 'Descripción negocio',
                precio: 50000
            }
        ],
        historialRevisiones: [
            {
                _id: '3',
                codigoModerador: '3',
                descripcion: 'Historial realizado',
                estadoNegocio: 'APROBADO',
                fecha: '13-04-2024'
            }
        ],
        teleonos: ['12121223', '456655756'],
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Negocio'
    },
    {
        _id: '4',
        codigoCliente: '4',
        ubicacion: {
            latitud: 6.74856945,
            longitud: -88.4375845
        },
        nombre: 'Negocio 4',
        descripcion: 'Descripcion del negocio 4',
        horario: [
            {
                horaInicio: '08:00',
                horaFin: '21:00',
                dia: 'Jueves'
            }
        ],
        estado: 'PENDIENTE',
        estadoRegistro: 'ACTIVO',
        tipoNegocio: 'RESTAURANTE',
        fechaRechazo: '13-04-2024',
        imagenes: ['imagen1.png', 'imagen2.png'],
        lstMenuNegocio: [
            {
                _id: '4',
                codigoNegocio: '4',
                descripcion: 'Descripción negocio',
                precio: 50000
            }
        ],
        historialRevisiones: [
            {
                _id: '4',
                codigoModerador: '4',
                descripcion: 'Historial realizado',
                estadoNegocio: 'APROBADO',
                fecha: '13-04-2024'
            }
        ],
        teleonos: ['34534543', '213123'],
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Negocio'
    },
    {
        _id: '5',
        codigoCliente: '5',
        ubicacion: {
            latitud: 4.23232,
            longitud: -65.7438
        },
        nombre: 'Negocio 5',
        descripcion: 'Descripcion del negocio 5',
        horario: [
            {
                horaInicio: '08:00',
                horaFin: '21:00',
                dia: 'Viernes'
            }
        ],
        estado: 'PENDIENTE',
        estadoRegistro: 'ACTIVO',
        tipoNegocio: 'TIENDA',
        fechaRechazo: '13-04-2024',
        imagenes: ['imagen1.png', 'imagen2.png'],
        lstMenuNegocio: [
            {
                _id: '5',
                codigoNegocio: '5',
                descripcion: 'Descripción negocio',
                precio: 50000
            }
        ],
        historialRevisiones: [
            {
                _id: '5',
                codigoModerador: '5',
                descripcion: 'Historial realizado',
                estadoNegocio: 'APROBADO',
                fecha: '13-04-2024'
            }
        ],
        teleonos: ['1122131', '6786787'],
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Negocio'
    }
]);

db.comentarios.insertMany([
    {
        _id: '1',
        fecha: '13-04-2024',
        calificacion: 5,
        codigoCliente: '1',
        codigoNegocio: '1',
        mensaje: 'Excelente servicio',
        idComentarioPadre: '0',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Comentario'
    },
    {
        _id: '2',
        fecha: '13-04-2024',
        calificacion: 4,
        codigoCliente: '2',
        codigoNegocio: '2',
        mensaje: 'Excelente servicio',
        idComentarioPadre: '1',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Comentario'
    },
    {
        _id: '3',
        fecha: '13-04-2024',
        calificacion: 1,
        codigoCliente: '3',
        codigoNegocio: '3',
        mensaje: 'Excelente servicio',
        idComentarioPadre: '5',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Comentario'
    },
    {
        _id: '4',
        fecha: '13-04-2024',
        calificacion: 2,
        codigoCliente: '4',
        codigoNegocio: '4',
        mensaje: 'Excelente servicio',
        idComentarioPadre: '1',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Comentario'
    },
    {
        _id: '5',
        fecha: '13-04-2024',
        calificacion: 4,
        codigoCliente: '5',
        codigoNegocio: '5',
        mensaje: 'Excelente servicio',
        idComentarioPadre: '2',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Comentario'
    }
]);

db.moderadores.insertMany([
    {
        _id: '1',
        nombre: 'Moderador 1',
        password: '1234',
        email: 'moderador1@gmail.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Moderador'
    },
    {
        _id: '2',
        nombre: 'Moderador 2',
        password: '1234',
        email: 'moderador2@gmail.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Moderador'
    },
    {
        _id: '3',
        nombre: 'Moderador 3',
        password: '1234',
        email: 'moderador3@gmail.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Moderador'
    },
    {
        _id: '4',
        nombre: 'Moderador 4',
        password: '1234',
        email: 'moderador4@gmail.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Moderador'
    },
    {
        _id: '5',
        nombre: 'Moderador 5',
        password: '1234',
        email: 'moderador5@gmail.com',
        estadoRegistro: 'ACTIVO',
        _class: 'co.edu.uniquindio.unilocal.modelo.documentos.Moderador'
    }
]);