package sheng.android.com.weather;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017/6/1.
 */

public class SceneSurfaceView extends SurfaceView implements SurfaceHolder.Callback{


    public SceneSurfaceView(Context context) {
        super(context);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
