package com.ammase.spinnerexampletoloadjsonusingretrofitrxjava;

import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model.ResponseGetProv;
import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.network.NetworkClient;
import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.network.RequestAPI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ammase on 13/08/17.
 */

public class MainPresenter {
    private MainView view;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void LoadDataSpinner() {
        view.showLoading();
        RequestAPI requestAPI = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null) mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(requestAPI.getResultAlamatProv()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseAuth -> combineSuccessObserver(responseAuth),
                        throwable -> combineErrorObserver(throwable)
                )
        );
    }

    private void combineSuccessObserver(ResponseGetProv responseAuth) {
        view.hideLoading();
        view.handleSpinnerSuccess(responseAuth);
    }

    private void combineErrorObserver(Throwable throwable) {
        view.hideLoading();
        view.handleSpinnerError(throwable.getLocalizedMessage().toString());
    }
}
