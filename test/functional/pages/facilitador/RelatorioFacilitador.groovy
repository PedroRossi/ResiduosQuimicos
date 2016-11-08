package pages.facilitador

import geb.Page

/**
 * Created by pedro on 05/11/16.
 */
class RelatorioFacilitador extends Page {

    static url = "/ResiduosQuimicos/facilitador/index"

    static at = {
        title ==~ /Relatorio/
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }

}
