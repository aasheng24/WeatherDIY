package sheng.android.com.weather;

import android.content.Context;
import android.os.Handler;
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
    private RenderThread mRenderThread;
    private Scene mScene;

    public RenderThread(SurfaceHolder surfaceHolder , Context context) {
        mSurfaceHolder = surfaceHolder;
        mContext = context;
        //add scene element
        mScene = new Scene(context);

    }

    @Override
    public void run() {
        Log.d(TAG,"start run");
    }

    public RenderThread getmRenderThread(){
        return mRenderThread;
    }
    private class RenderHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    if()
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
    }
}
