package br.gov.ifgoiano.gethospeda.dto;

import br.gov.ifgoiano.gethospeda.model.TipoUsuario;

public class UsuarioResumoDTO {
    private long id;
    private TipoUsuario tipoUsuario;
    private String nome;
    private String telefone;

    public UsuarioResumoDTO() {
    }

    public UsuarioResumoDTO(long id, TipoUsuario tipoUsuario, String nome, String telefone) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.nome = nome;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}