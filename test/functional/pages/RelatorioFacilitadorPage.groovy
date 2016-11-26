package pages

import geb.Page
import steps.InternationalizationHelper

/**
 * Created by pedro on 05/11/16.
 */
class RelatorioFacilitadorPage extends Page {

    static url = "/ResiduosQuimicos/facilitador/index"

    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String relatorioFacilitador = helper.getMessage("default.resume.label")
        title ==~ relatorioFacilitador
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }

}
