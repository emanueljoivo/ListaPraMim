package enums;

public enum OperacoesDeAtualizacao {

    ADICIONA("adiciona"),
    DIMINUI("diminui");

    private String operacao;

    OperacoesDeAtualizacao(String operacao) {
        this.operacao = operacao;
    }

    public String getOperacao() {return this.operacao;}
}
