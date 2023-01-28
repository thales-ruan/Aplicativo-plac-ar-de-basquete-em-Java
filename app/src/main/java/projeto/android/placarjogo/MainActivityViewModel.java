package projeto.android.placarjogo;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Integer> mvalorLocal = new MutableLiveData<>();
    public LiveData<Integer> valorLocal = mvalorLocal;

    private MutableLiveData<Integer> mvalorVisitante = new MutableLiveData<>();
    public LiveData<Integer> valorVisitante = mvalorVisitante;

    public MainActivityViewModel() {

        reset();

    }

    public void reset() {
        mvalorLocal.setValue(0);
        mvalorVisitante.setValue(0);
    }

    public void incrementUmLocal() {
        mvalorLocal.setValue(mvalorLocal.getValue() + 1);
    }

    public void incrementDoisLocal() {
        mvalorLocal.setValue(mvalorLocal.getValue() + 2);
    }

    public void decrementoLocal() {

        if (mvalorLocal.getValue() > 0) {
            mvalorLocal.setValue(mvalorLocal.getValue() - 1);
        }
    }

    public void decrementoVisitante() {

        if (mvalorVisitante.getValue() > 0) {
            mvalorVisitante.setValue(mvalorVisitante.getValue() - 1);
        }
    }

    public void incrementUmVisitante() {
        mvalorVisitante.setValue(mvalorVisitante.getValue() + 1);
    }

    public void incrementDoisVisitante() {
        mvalorVisitante.setValue(mvalorVisitante.getValue() + 2);
    }

}
