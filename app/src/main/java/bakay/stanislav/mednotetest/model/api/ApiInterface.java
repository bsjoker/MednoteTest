package bakay.stanislav.mednotetest.model.api;

import bakay.stanislav.mednotetest.model.data.FillData;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("stocks.json")
    Observable<FillData> getAllData();
}
