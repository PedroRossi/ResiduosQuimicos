package residuosquimicos

class Laboratorio {
    /**
     * Nome do centro ao qual pertence
     */
    CentroList centro
    /**
     * Nome do departamento ao qual pertence
     */
    DepartamentoList departamento
    /**
     * Nome do laboratorio ao qual pertence
     */
    LaboratorioList laboratorio
    /**
     * Usuario que solicitou acesso ao sistema
     */
    Usuario solicitante
    /**
     * Usuario que e responsavel pelo laboratorio
     */
    Usuario responsavel

    static hasMany = [residuos: Residuo]

    static constraints = {
        centro blank: false
        departamento blank: false
        laboratorio blank: false
        solicitante nullable: true
        responsavel nullable: true
    }

}