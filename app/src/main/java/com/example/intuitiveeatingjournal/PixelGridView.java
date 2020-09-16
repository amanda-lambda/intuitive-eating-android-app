package com.example.intuitiveeatingjournal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

public class PixelGridView extends View {
    private int numColumns;
    private int numRows;
    private int cellWidth;
    private int cellHeight;
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
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return;
        }

        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        if (numColumns == 0 || numRows == 0) {
            return;
        }

        int width = getWidth();
        int height = getHeight();
        int middleColumn = (numColumns - 1) / 2;
        int num_entries = befores.size();

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
                canvas.drawRect(i * cellWidth, j * cellHeight,
                        (i + 1) * cellWidth, (j + 1) * cellHeight, paint);

                paint.setColor(colors.get(after_pos));
                canvas.drawRect((i + middleColumn + 1) * cellWidth, j * cellHeight,
                        (i + middleColumn + 2) * cellWidth, (j + 1) * cellHeight, paint);

                // Increment
                count = count + 1;
            }
        }
    }
}
