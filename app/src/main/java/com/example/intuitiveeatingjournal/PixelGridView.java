package com.example.intuitiveeatingjournal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class PixelGridView extends View {
    private int numColumns = 13;
    private int cellSize;
    private int numRows;
    private int border = 1;
    private ArrayList<Integer> colors;
    private ArrayList<String> befores;
    private ArrayList<String> afters;
    private Paint paint = new Paint();

    public PixelGridView(Context context, ArrayList<Integer> colors, ArrayList<String> befores, ArrayList<String> afters) {
        super(context, null);
        paint.setStyle(Paint.Style.FILL);
        this.befores = befores;
        this.afters = afters;
        this.colors = colors;
        this.border = 1;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Compute the height required to render the view
        // Assume Width will always be MATCH_PARENT.
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 7000+ 50; // Since 3000 is bottom of last Rect to be drawn added and 50 for padding.
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        int width = getWidth();
        int height = getHeight();

        int middleColumn = (numColumns - 1) / 2;
        int num_entries = befores.size();
        numRows = (num_entries + numColumns - 1) / numColumns;
        cellSize = width / numColumns;

        int count = 0;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < middleColumn; i++) {
                if (count >= num_entries) {
                    return;
                }

                // Get befores and afters
                String before = befores.get(count);
                String after = afters.get(count);
                Integer before_pos = new Integer(before);
                Integer after_pos = new Integer(after);

                // Draw rectangles
                paint.setColor(colors.get(before_pos));
                canvas.drawRect(i * cellSize + border, j * cellSize + border,
                        (i + 1) * cellSize - border, (j + 1) * cellSize - border, paint);

                paint.setColor(colors.get(after_pos));
                canvas.drawRect((i + middleColumn + 1) * cellSize + border, j * cellSize + border,
                        (i + middleColumn + 2) * cellSize - border, (j + 1) * cellSize - border, paint);

                // Increment
                count = count + 1;
            }
        }
    }
}
