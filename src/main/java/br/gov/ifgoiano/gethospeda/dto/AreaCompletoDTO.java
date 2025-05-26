package br.gov.ifgoiano.gethospeda.dto;

public class AreaCompletoDTO {
    private long id;
    private String tipo;
    private String descricao;
    private ImovelResumoDTO imovel;
    private String horarioDisponivel;
    private String regrasDeUso;

    public AreaCompletoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ImovelResumoDTO getImovel() {
        return imovel;
    }

    public void setImovel(ImovelResumoDTO imovel) {
        this.imovel = imovel;
    }

    public String getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(String horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public String getRegrasDeUso() {
        return regrasDeUso;
    }

    public void setRegrasDeUso(String regrasDeUso) {
        this.regrasDeUso = regrasDeUso;
    }
}
