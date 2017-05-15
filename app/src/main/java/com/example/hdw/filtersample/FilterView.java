package com.example.hdw.filtersample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/05/15 0015.
 *
 */

public class FilterView extends View {
    private Rect mRect;
    private Paint mPaint;

    public FilterView(Context context) {
        super(context);
    }

    public FilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE , null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

//        setBlurMaskFilter();

//        setEmbossMaskFilter();

        setColorFilter();

        mRect = new Rect(100,100,300,300);
    }

    private void setBlurMaskFilter() {
        /**
         * 创建一个模糊滤镜
         *
         * @param radius 模糊半径
         * @param style  模糊模式
         *
         *              Blur.SOLID   在边界5外画阴影
         *              Blur.NORMAL     整个图像和边界外产生阴影
         *              Blur.OUTER      整个图像透明，边界产生阴影
         *              Blur.INNER      边界内产生阴影
         *
         * @return       The new blur maskfilter
         */
        MaskFilter filter = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);
        mPaint.setMaskFilter(filter);
    }

    private void setEmbossMaskFilter() {
        /**
         * Create an emboss maskfilter
         *
         * @param direction   指定光源的位置
         * @param ambient    环境光因子[0~1]，越接近0越暗
         * @param specular   镜面反射
         * @param blurRadius 阴影半径
         * @return           the emboss maskfilter
         */
        MaskFilter filter = new EmbossMaskFilter(new float[]{0.5f,0,0},0.5f,20,50);
        mPaint.setMaskFilter(filter);
    }

    private void setColorFilter() {
        /**
         * Create a color filter that transforms colors through a 4x5 color matrix.
         * 创建一个颜色过滤器，通过一个4X5的颜色矩阵
         * @param array 用一个大小为20的数组来表示，4行5列的矩阵
         */
//        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
//                1,0,0,0,0,
//                0,1,0,0,0,
//                0,0,1,0,0,
//                0,0,0,0.7f,0
//        });

        /*
        * 缩放
        * */
//        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
//                1.2f,0,0,0,0,
//                0,1.2f,0,0,0,
//                0,0,1.2f,0,0,
//                0,0,0,1f,0
//        });

        /*
         * 平移
         **/
//        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
//                1,0,0,0,100,
//                0,1,0,0,0,
//                0,0,1,0,0,
//                0,0,0,0.7f,0
//        });

        /*
         * 发色效果 （颜色进行交换）
         **/
//        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
//                0,1,0,0,0,
//                1,0,0,0,0,
//                0,0,1,0,0,
//                0,0,0,0.7f,0
//        });

        /*
         * 复古效果
         **/
//        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
//                1/2f,1/2f,1/2f,1/2f,0,
//                1/3f,1/3f,1/3f,1/3f,0,
//                1/4f,1/4f,1/4f,1/4f,0,
//                0,0,0,0.7f,0
//        });

        /*
         * 颜色通道过滤
         **/
//        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
//                1,0,0,0,0,
//                0,0,0,0,0,
//                0,0,0,0,0,
//                0,0,0,1f,0
//        });

        /*
        * 黑白照片
        * */
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(new float[]{
                0.213f,0.715f,0.072f,0,0,
                0.213f,0.715f,0.072f,0,0,
                0.213f,0.715f,0.072f,0,0,
                0,0,0,1f,0
        });
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRect, mPaint);
    }
}
