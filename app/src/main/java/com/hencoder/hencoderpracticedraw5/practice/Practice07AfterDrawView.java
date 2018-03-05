package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * / View.java 的 draw() 方法的简化版大致结构（是大致结构，不是源码哦）
 *
 * public void draw(Canvas canvas) {
 * ...
 *
 * drawBackground(Canvas); // 绘制背景（不能重写）
 * onDraw(Canvas); // 绘制主体
 * dispatchDraw(Canvas); // 绘制子 View
 * onDrawForeground(Canvas); // 绘制滑动相关和前景
 *
 * ...
 * }
 *
 * 从上面的代码可以看出，onDraw() dispatchDraw() onDrawForeground()
 * 这三个方法在 draw() 中被依次调用，
 * 因此它们的遮盖关系也就像前面所说的——dispatchDraw() 绘制的内容盖住 onDraw() 绘制的内容；
 * onDrawForeground() 绘制的内容盖住 dispatchDraw() 绘制的内容。
 * 而在它们的外部，则是由 draw() 这个方法作为总的调度。所以，你也可以重写 draw() 方法来做自定义的绘制。
 */
public class Practice07AfterDrawView extends AppCompatImageView {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  public Practice07AfterDrawView(Context context) {
    super(context);
  }

  public Practice07AfterDrawView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice07AfterDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(60);
  }

  /**
   * 效果等同于 在 super.draw() 的下方插入绘制代码，让绘制内容盖住其他所有
   */
  @Override public void onDrawForeground(Canvas canvas) {
    super.onDrawForeground(canvas);
    paint.setColor(Color.parseColor("#f44336"));
    canvas.drawRect(0, 40, 200, 120, paint);
    paint.setColor(Color.WHITE);
    canvas.drawText("New", 20, 100, paint);
  }

  //@Override
  //public void draw(Canvas canvas) {
  //    super.draw(canvas);
  //
  //    // 在 super.draw() 的下方插入绘制代码，让绘制内容盖住其他所有
  //    // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
  //    paint.setColor(Color.parseColor("#f44336"));
  //    canvas.drawRect(0, 40, 200, 120, paint);
  //    paint.setColor(Color.WHITE);
  //    canvas.drawText("New", 20, 100, paint);
  //}
}