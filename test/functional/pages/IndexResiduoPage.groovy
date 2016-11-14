package pages

import geb.Page
import steps.InternationalizationHelper

/**
 * Created by pedro on 14/11/16.
 */
class IndexResiduoPage extends Page {

    static url = "/ResiduosQuimicos/residuo/index/"

    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String labelResiduo = "Residuo" //code.label
        String indexResiduoTitleList = helper.getMessage("default.list.label", labelResiduo)
        title ==~ indexResiduoTitleList
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }

    boolean isEmpty() {
        $("tbody").isEmpty()
    }

}
