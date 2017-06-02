package sheng.android.com.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class BirdUp extends Actor {
    private static final int[] mImages = new int[]{R.drawable.finedayup_1, R.drawable.finedayup_2, R.drawable.finedayup_3,
            R.drawable.finedayup_4, R.drawable.finedayup_5, R.drawable.finedayup_6,
            R.drawable.finedayup_7, R.drawable.finedayup_8};

    private float mInitPositionX;
    private float mInitPositionY;
    private boolean mInited;
    private List<Bitmap> mFrames;
    private RectF mBox;
    private RectF mTargetBox;
    private int mCurFrameIndex;
    private long mInitTime;
    private Paint mPaint;

    protected BirdUp(Context context) {
        super(context);
        mFrames = new ArrayList<Bitmap>();
        mBox = new RectF();
        mTargetBox = new RectF();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas, int width, int height) {
        //逻辑处理
        //初始化
        if (!mInited) {
            mInitPositionX = width * 0.117F;
            mInitPositionY = height * 0.35F;
            mMatrix.reset();
            mMatrix.postTranslate(mInitPositionX, mInitPositionY);
            for (int resID : mImages) {
                mFrames.add(BitmapFactory.decodeResource(mContext.getResources(), resID));
            }
            mBox.set(0, 0, mFrames.get(0).getWidth(), mFrames.get(0).getHeight());
            mInited = true;
            mInitTime = System.currentTimeMillis();
            return;
        }
        //移动
        mMatrix.postTranslate(2, 0);
        //边界处理
        mMatrix.mapRect(mTargetBox, mBox);
        if (mTargetBox.left > width) {
            mMatrix.postTranslate(-mTargetBox.right, 0);
        }
        //取得帧动画图片
        long curTime = System.currentTimeMillis();
        mCurFrameIndex = (int) ((curTime - mInitTime) / 500 % 8);

        Bitmap curBitmap = mFrames.get(mCurFrameIndex);
        //绘制
        canvas.save();
        canvas.drawBitmap(curBitmap, mMatrix, mPaint);
        canvas.restore();
    }
}
