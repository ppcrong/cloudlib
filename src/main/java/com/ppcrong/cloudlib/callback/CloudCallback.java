package com.ppcrong.cloudlib.callback;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public interface CloudCallback<T> {

    void onResponse(CopyOnWriteArrayList<T> outputs);
    void onFailure(IOException e);
}
