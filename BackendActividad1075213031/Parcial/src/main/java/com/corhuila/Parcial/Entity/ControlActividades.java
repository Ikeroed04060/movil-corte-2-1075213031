package com.corhuila.Parcial.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ControlActividades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_actividad;

    @Column(name = "fecha", nullable = true)
    private LocalDateTime fecha;

    @Column(name = "nombre", nullable = true)
    private String nombre;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
