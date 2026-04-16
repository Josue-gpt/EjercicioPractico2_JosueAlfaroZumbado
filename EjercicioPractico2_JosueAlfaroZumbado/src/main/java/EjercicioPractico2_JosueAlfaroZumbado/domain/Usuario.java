/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.domain;

import EjercicioPractico2_JosueAlfaroZumbado.domain.Rol;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String password;

    // Relación MANY TO ONE
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    // IMPORTANTE: nombre raro de la BD
    @Column(name = "ac2vo")
    private Boolean activo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
}
