package sheng.android.com.weather;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Administrator on 2017/6/1.
 */

public class RenderThread extends Thread {
    private static String TAG = "RenderThread";
    private Context mContext;
    private SurfaceHolder mSurfaceHolder;
    private RenderHandler mRenderHandler;
    private Scene mScene;

    public RenderThread(SurfaceHolder surfaceHolder , Context context) {
        mSurfaceHolder = surfaceHolder;
        mContext = context;
        mScene = new Scene(context);
        //add scene element
        mScene.setBg(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg0_fine_day));
        mScene.add(new BirdDown(context));
        mScene.add(new BirdDown(context));

    }

    @Override
    public void run() {
        Log.d(TAG,"start run");
        Looper.prepare();
        mRenderHandler = new RenderHandler();
        mRenderHandler.sendEmptyMessage(0);
        Looper.loop();
    }

    public RenderHandler getmRenderHandler(){
        return mRenderHandler;
    }
    private class RenderHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    if(mScene.getmWidth() != 0 && mScene.getmHeight() != 0){
                        draw();
                    }
                    mRenderHandler.sendEmptyMessage(0);
                    break;
                case 1:
                    Looper.myLooper().quit();
                    break;
                default:
                    break;
            }
        }
    }

    public void setWidth(int width){
        mScene.setmWidth(width);
    }

    public void setHeight(int height){
        mScene.setmHeight(height);
    }

    private void draw(){
        Canvas canvas = mSurfaceHolder.lockCanvas();
        if(canvas != null){
            mScene.draw(canvas);
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
