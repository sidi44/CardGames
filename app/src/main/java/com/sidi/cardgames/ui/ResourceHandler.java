package com.sidi.cardgames.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by Simon on 29/12/2017.
 */

public interface ResourceHandler {

    Resources getResources();

    View findViewById(@IdRes int id);

}
