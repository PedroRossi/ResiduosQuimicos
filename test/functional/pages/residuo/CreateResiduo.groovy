package pages.residuo

import geb.Page

/**
 * Created by pedro on 04/11/16.
 */
class CreateResiduo extends Page {

    static url = "/ResiduosQuimicos/residuo/create"

    static at = {
        title ==~ /Create Residuo/
    }

    def createResiduo(residuo, peso) {
        $("form").nome = residuo
        $("form").descricao = residuo
        $("form").peso = peso
        $("input", name: "create").click()
    }

}
