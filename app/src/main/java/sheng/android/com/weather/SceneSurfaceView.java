package sheng.android.com.weather;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017/6/1.
 */

public class SceneSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    private RenderThread mRenderThread;
    private SurfaceHolder mSurfaceHolder;
    private int mWidth;
    private int mHeight;
    private static String TAG = "SceneSurfaceView";

    public SceneSurfaceView(Context context) {
        super(context);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    public SceneSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG,"surfaceCreated");
        if(mRenderThread == null){
            mRenderThread = new RenderThread(mSurfaceHolder,getContext());
            mRenderThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG,"surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG,"surfaceChanged");
        if(mRenderThread != null){
            Handler handler = (Handler) mRenderThread.getmRenderHandler();
            handler.sendEmptyMessage(1);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        Log.d(TAG,"omMeasure width = "+mWidth +" and height = "+mHeight);
        if(mRenderThread != null){
            mRenderThread.setWidth(mWidth);
            mRenderThread.setHeight(mHeight);
        }
    }
}
