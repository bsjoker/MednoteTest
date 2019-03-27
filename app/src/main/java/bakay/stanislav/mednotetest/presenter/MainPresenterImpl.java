package bakay.stanislav.mednotetest.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import bakay.stanislav.mednotetest.Utils.DisposableManager;
import bakay.stanislav.mednotetest.model.Model;
import bakay.stanislav.mednotetest.model.ModelImpl;
import bakay.stanislav.mednotetest.model.data.FillData;
import bakay.stanislav.mednotetest.model.data.Stock;
import bakay.stanislav.mednotetest.view.MainView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainPresenterImpl implements MainPresenter {
    private Model model = new ModelImpl();
    private MainView mainView;
    private List<Stock> listForView = new ArrayList<>();

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onStartButtonClick() {
        DisposableManager.dispose();
        onStartFetch();
    }

    @Override
    public void onStartFetch() {
        model.getDataList().repeatWhen(objectObservable -> objectObservable.delay(15000, TimeUnit.MILLISECONDS))
                .subscribe(new Observer<FillData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        DisposableManager.add(d);
                    }

                    @Override
                    public void onNext(FillData allData) {
                        if (allData != null) {
                            listForView.clear();
                            listForView.addAll(allData.getStock());
                            mainView.showData(listForView);
                        } else {
                            mainView.showEmptyList();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onClickPosition(int position) {
        mainView.showClickedItem(listForView.get(position).getName());
    }


}
