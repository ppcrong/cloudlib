package com.ppcrong.cloudlib.callback;

import java.io.IOException;
import java.util.ArrayList;

public interface CloudCallback<T> {

    void onResponse(ArrayList<T> outputs);
    void onFailure(IOException e);
}
