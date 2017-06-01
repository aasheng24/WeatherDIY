package sheng.android.com.weather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by Administrator on 2017/6/1.
 */

public abstract class Actor {
    protected Context mContext;
    protected Matrix mMatrix;
    public Actor(Context context) {
        mContext = context;
        mMatrix = new Matrix();
    }
    public abstract void draw(Canvas canvas, int width, int height);
}
