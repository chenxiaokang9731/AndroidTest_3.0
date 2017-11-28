package com.narkang.util.rx_encapsulation;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxManager {

    private CompositeDisposable disposable = new CompositeDisposable();

    public void add(Disposable d){
        disposable.add(d);
    }

    public void clear(){
        disposable.dispose();
        disposable = null;
    }
}
