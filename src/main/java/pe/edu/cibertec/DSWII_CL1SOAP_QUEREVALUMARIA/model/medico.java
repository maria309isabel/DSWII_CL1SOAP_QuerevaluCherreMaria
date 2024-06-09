package pe.edu.cibertec.DSWII_CL1SOAP_QUEREVALUMARIA.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BDEvaluacion")
public class medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;

    @Column(name = "nommedico")
    private String nommedico;

    @Column(name = "apemedico")
    private String apemedico;

    @Column(name = "fechanacmedico")
    private Date fechanacmedico;

}

