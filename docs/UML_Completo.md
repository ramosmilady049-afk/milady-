## Diagrama de clases UML completo

```mermaid
classDiagram
    class Cliente {
        -String idCliente
        -String nombre
        -String telefono
        -String correo
        -String direccion
        +registrarse()
        +actualizarDatos()
        +consultarHistorial()
    }

    class Mascota {
        -String idMascota
        -String nombre
        -String especie
        -String raza
        -int edad
        -double peso
        +registrarMascota()
        +actualizarFicha()
        +verHistorialClinico()
    }

    class Empleado {
        -String idEmpleado
        -String nombre
        -String cargo
        -String turno
        +atenderVenta()
        +registrarCita()
        +actualizarInventario()
    }

    class Servicio {
        -String idServicio
        -String nombre
        -int duracion
        -double precio
        +asignarACita()
        +calcularCosto()
    }

    class Cita {
        -String idCita
        -String fecha
        -String hora
        -String estado
        -String idMascota
        -String idEmpleado
        +agendar()
        +confirmar()
        +cancelar()
        +finalizar()
    }

    class Producto {
        -String idProducto
        -String nombre
        -String categoria
        -double precio
        -int stock
        +actualizarStock()
        +verificarDisponibilidad()
    }

    class Proveedor {
        -String idProveedor
        -String razonSocial
        -String contacto
        -String rubro
        +registrarPedido()
        +actualizarCatalogo()
    }

    class Venta {
        -String idVenta
        -String fecha
        -String idCliente
        -String idEmpleado
        -double total
        +registrarVenta()
        +calcularTotal()
        +emitirComprobante()
    }

    class DetalleVenta {
        -String idDetalle
        -String idVenta
        -String idProducto
        -int cantidad
        -double subtotal
        +calcularSubtotal()
    }

    class Pago {
        -String idPago
        -String idVenta
        -double monto
        -String metodoPago
        -String fecha
        +registrarPago()
        +validarMonto()
    }

    class Inventario {
        -String idMovimiento
        -String idProducto
        -String tipoMovimiento
        -int cantidad
        -String fecha
        +registrarEntrada()
        +registrarSalida()
        +generarAlertaStock()
    }

    Cliente "1" --> "1..*" Mascota
    Mascota "1" --> "1..*" Cita
    Empleado "1" --> "0..*" Cita
    Empleado "1" --> "0..*" Venta
    Cita "1" --> "1..*" Servicio
    Cliente "1" --> "0..*" Venta
    Venta "1" *-- "1..*" DetalleVenta
    DetalleVenta "1..*" --> "1" Producto
    Venta "1" --> "1..*" Pago
    Proveedor "1" --> "1..*" Producto
    Producto "1" --> "1..*" Inventario
```

## Multiplicidades tomadas del documento

- Cliente → Mascota: **1 a 1..***
- Mascota → Cita: **1 a 1..***
- Empleado → Cita: **1 a 0..***
- Empleado → Venta: **1 a 0..***
- Cita → Servicio: **1 a 1..***
- Cliente → Venta: **1 a 0..***
- Venta → DetalleVenta: **1 a 1..***, composición
- DetalleVenta → Producto: **1..* a 1**
- Venta → Pago: **1 a 1..***
- Proveedor → Producto: **1 a 1..***
- Producto → Inventario: **1 a 1..***

## Diagrama de casos de uso

```mermaid
flowchart LR
    Cliente((Cliente))
    Vendedor((Vendedor))
    Groomer((Veterinario/Groomer))
    Admin((Administrador))
    Proveedor((Proveedor))

    subgraph Sistema["Sistema de Gestión Integral Pet Shop"]
        UC1[Registrar cliente]
        UC2[Registrar mascota]
        UC3[Comprar producto]
        UC4[Agendar cita]
        UC5[Registrar venta y pago]
        UC6[Atender cita]
        UC7[Actualizar historial]
        UC8[Gestionar inventario]
        UC9[Gestionar proveedores]
        UC10[Generar reportes]
        UC11[Generar indicadores]
    end

    Cliente --> UC1
    Cliente --> UC2
    Cliente --> UC3
    Cliente --> UC4
    Vendedor --> UC1
    Vendedor --> UC3
    Vendedor --> UC5
    Vendedor --> UC8
    Groomer --> UC6
    Groomer --> UC7
    Admin --> UC8
    Admin --> UC9
    Admin --> UC10
    Admin --> UC11
    Proveedor --> UC9
```

## Diagrama de estados de Cita

```mermaid
stateDiagram-v2
    [*] --> Solicitada
    Solicitada --> Confirmada
    Confirmada --> En_atencion
    En_atencion --> Finalizada
    Confirmada --> Cancelada
    Confirmada --> No_asistio
    Finalizada --> [*]
    Cancelada --> [*]
    No_asistio --> [*]
```

## Diagrama de secuencia de venta

```mermaid
sequenceDiagram
    actor Cliente
    participant Vendedor
    participant Sistema
    participant Inventario
    participant Pago

    Cliente->>Vendedor: Solicita comprar producto
    Vendedor->>Sistema: Busca producto y verifica stock
    Sistema->>Inventario: Verifica disponibilidad
    Inventario-->>Sistema: Stock disponible
    Sistema-->>Vendedor: Precio y disponibilidad
    Cliente->>Vendedor: Indica método de pago
    Vendedor->>Pago: Procesa pago
    Pago-->>Sistema: Pago registrado
    Sistema->>Sistema: Registra venta y detalle
    Sistema->>Inventario: Descuenta stock
    Vendedor-->>Cliente: Entrega producto y comprobante
```
