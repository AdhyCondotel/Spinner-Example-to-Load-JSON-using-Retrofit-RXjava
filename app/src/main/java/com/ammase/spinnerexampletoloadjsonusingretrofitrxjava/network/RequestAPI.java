package com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.network;

import com.ammase.spinnerexampletoloadjsonusingretrofitrxjava.model.ResponseGetProv;

import io.reactivex.Observable;
import retrofit2.http.GET;
public interface RequestAPI {

    @GET("/m/lprov")
    Observable<ResponseGetProv> getResultAlamatProv();

}
