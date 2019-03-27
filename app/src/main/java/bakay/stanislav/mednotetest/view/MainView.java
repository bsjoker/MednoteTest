package bakay.stanislav.mednotetest.view;

import java.util.List;
import bakay.stanislav.mednotetest.model.data.Stock;

public interface MainView{
    void showData(List<Stock> list);

    void showError(String error);

    void showEmptyList();

    void showClickedItem(String name);
}
