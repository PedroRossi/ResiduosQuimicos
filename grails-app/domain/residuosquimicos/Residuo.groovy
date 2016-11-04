package residuosquimicos

class Residuo {
    /**
     * Nome do residuo gerado
     */
    String nome
    /**
     * Descrição sobre o residuo gerado
     */
    String descricao
    /**
     * Peso do residuo em gramas
     */
    double peso
    /**
     * Data na qual o residuo foi gerado
     */
    Date dataCadastro

    static belongsTo = [laboratorio:Laboratorio]

    static constraints = {
        nome blank:false
        descricao blank:false
    }

}