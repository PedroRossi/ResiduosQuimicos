package pages.facilitador

import geb.Page

/**
 * Created by pedro on 04/11/16.
 */
class IndexFacilitador extends Page {

    static url = "/ResiduosQuimicos/facilitador/resumoSistema"

    static at = {
        title ==~ /Resumo Sistema/
    }

    boolean comparePeso(peso) {
        $("p", name: "peso").has(text: peso)
    }

    boolean compareQnt(qntResiduos) {
        $("p", name: "qntResiduos").has(text: qntResiduos)
    }

    boolean isEmpty() {
        $("tbody").isEmpty()
    }

}
