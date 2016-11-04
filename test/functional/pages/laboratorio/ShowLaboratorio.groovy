package pages.laboratorio

import geb.Page

/**
 * Created by pedro on 04/11/16.
 */
class ShowLaboratorio extends Page {

    static url = "/ResiduosQuimicos/laboratorio/show/"

    static at = {
        title ==~ /Show Laboratorio/
    }

}
