package bakay.stanislav.mednotetest.model;

import bakay.stanislav.mednotetest.model.data.FillData;
import io.reactivex.Observable;

public interface Model {
    Observable<FillData> getDataList();
}
