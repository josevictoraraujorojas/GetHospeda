package br.gov.ifgoiano.gethospeda.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@DiscriminatorValue("proprietario")
public class Proprietario extends Usuario{
    private String cnpj;
    @OneToMany(mappedBy = "proprietario")
    private List<Imovel> imoveleis;

    public Proprietario() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
