package com.ammase.spinnerexampletoloadjsonusingretrofitrxjava;

import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model.ResponseGetProv;

/**
 * Created by ammase on 13/08/17.
 */

public interface MainView {
    void showLoading();

    void hideLoading();

    void handleSpinnerSuccess(ResponseGetProv responseAuth);

    void handleSpinnerError(String error);
}
