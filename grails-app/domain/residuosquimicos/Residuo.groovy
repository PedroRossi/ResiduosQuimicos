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
        nome blank:false, nullable: false
        descricao blank:false, nullable: false
        peso nullable: false
        laboratorio nullable:false
        dataCadastro default: new Date()
    }

}