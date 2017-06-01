package sheng.android.com.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class BirdDown extends Actor{
    private static final int[] mImages = new int[]{R.drawable.finedaydown_1, R.drawable.finedaydown_2, R.drawable.finedaydown_3,
            R.drawable.finedaydown_4, R.drawable.finedaydown_5, R.drawable.finedaydown_6,
            R.drawable.finedaydown_7, R.drawable.finedaydown_8};

    private float mInitPositionX,mInitPositionY;
    private boolean mInited = false;
    private List<Bitmap> mFrames;
    private RectF mBox,mTargetBox;
    private int mCurrentFrameIndex;
    private long initTime;
    private Paint mPaint;

    public BirdDown(Context context) {
        super(context);
        mFrames = new ArrayList<Bitmap>();
        mBox = new RectF();
        mTargetBox = new RectF();
        mPaint = new Paint();
        //防锯齿
        mPaint.setAntiAlias(true);
    }
    
    @Override
    public void draw(Canvas canvas, int width, int height) {
        if(!mInited){
            //start init
            mInitPositionX = width * 0.117f;
            mInitPositionY = height * 0.785f;
            mMatrix.reset();
            mMatrix.postTranslate(mInitPositionX,mInitPositionY);
            for(int resID : mImages){
                mFrames.add(BitmapFactory.decodeResource(mContext.getResources(),resID));
            }
            mInited = true;
            initTime = System.currentTimeMillis();
            return;
        }
        //开始移动
        mMatrix.postTranslate(2,0);
        //边界处理
        mMatrix.mapRect(mTargetBox, mBox);
        if(mTargetBox.left > width){
            mMatrix.postTranslate(-mTargetBox.right,0);
        }
        //取得帧动画图片
        long curTime = System.currentTimeMillis();
        mCurrentFrameIndex = (int) ((curTime - initTime) / 200 % 8);
        Bitmap curBitmap = mFrames.get(mCurrentFrameIndex);
        //绘制
        canvas.save();
        canvas.drawBitmap(curBitmap,mMatrix,mPaint);
        canvas.restore();


    }
}
