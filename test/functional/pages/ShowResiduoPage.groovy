package pages

import geb.Page
import steps.InternationalizationHelper

/**
 * Created by pedro on 04/11/16.
 */
class ShowResiduoPage extends Page {

    static url = "/ResiduosQuimicos/residuos/show/"

    static at = {
        InternationalizationHelper helper = InternationalizationHelper.instance
        String labelResiduo = "Residuo" //code.label
        String showResiduoTitleList = helper.getMessage("default.show.label", labelResiduo)
        title ==~ showResiduoTitleList
    }

}
