package br.gov.ifgoiano.gethospeda.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario{
    private String matricula;
    @OneToMany(mappedBy = "administrador")
    private List<Denuncia> denuncias;

    public Administrador() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
