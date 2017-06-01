package sheng.android.com.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class Scene {
    private Context mContext;
    private int mWidth;
    private int mHeight;
    private Bitmap mBitmap;
    private List<Actor> mActors = new ArrayList<Actor>();
    private Paint mPaint;

    public Scene(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setBg(Bitmap bg){
        mBitmap = bg;
    }

    public void add(Actor actor){
        mActors.add(actor);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(mBitmap,new Rect(0,0,mBitmap.getWidth(),mBitmap.getHeight()),new Rect(0,0,mWidth,mHeight),mPaint);
        for(Actor actor : mActors){
            actor.draw(canvas,mWidth,mHeight);
        }
    }

    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public void setmHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public int getmWidth() {
        return mWidth;
    }

    public int getmHeight() {
        return mHeight;
    }
}
