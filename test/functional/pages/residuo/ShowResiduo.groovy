package pages.residuo

import geb.Page

/**
 * Created by pedro on 04/11/16.
 */
class ShowResiduo extends Page {

    static url = "/ResiduosQuimicos/residuos/show/"

    static at = {
        title ==~ /Show Residuo/
    }

}
