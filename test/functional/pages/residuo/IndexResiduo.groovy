package pages.residuo

import geb.Page

/**
 * Created by pedro on 04/11/16.
 */
class IndexResiduo extends Page {

    static url = "/ResiduosQuimicos/residuo/index"

    static at = {
        title ==~ /Residuo List/
    }

    boolean hasResiduo(residuo) {
        $("td").has("a", text: residuo)
    }

    boolean hasResiduo(residuo, data) {
        $("td").has("a", text: residuo)
        $("td").has(text: data)
    }

    boolean isEmpty() {
        $("tbody").isEmpty()
    }

}
