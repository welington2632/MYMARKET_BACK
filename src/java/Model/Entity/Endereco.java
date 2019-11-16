package Model.Entity;
public class Endereco {
    private int id;
    private String logradouro;
    private String cep;
    private int numero;
    private String complemento;

    public Endereco() {
    }

    public Endereco(int id, String logradouro, String cep, int numero, String complemento) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    public Endereco( String logradouro, String cep, int numero, String complemento) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
