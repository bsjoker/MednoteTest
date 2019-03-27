package bakay.stanislav.mednotetest.model;

import bakay.stanislav.mednotetest.model.api.ApiInterface;
import bakay.stanislav.mednotetest.model.api.ApiModule;
import bakay.stanislav.mednotetest.model.data.FillData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ModelImpl implements Model {
    ApiInterface apiInterface = ApiModule.getApiInterface();

    @Override
    public Observable<FillData> getDataList() {
        return apiInterface.getAllData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
