/*  $Id: Shooter.java 1176 2012-03-28 22:54:10Z jenetic.bytemare@gmail.com $
 *  =======================================================================================
 */
    package de.christopherstock.android.fresslemania;

    import  android.content.*;
    import  android.graphics.*;
    import  android.graphics.Paint.Style;
    import  android.util.*;
    import  android.view.*;

    /******************************************************************************************
    *   The project's activity class.
    *
    *   @version    0.1
    *   @author     Christopher Stock
    *******************************************************************************************/
    public class FresslemaniaCanvas extends SurfaceView implements SurfaceHolder.Callback
    {
        public              static              int         CANVAS_WIDTH                    = 0;
        public              static              int         CANVAS_HEIGHT                   = 0;
        public              static              int         CANVAS_DPI                      = 0;

        public              static              int         a                               = 0;

        public FresslemaniaCanvas( Context context )
        {
            super( context );
        }

        @Override
        public void onDraw( Canvas canvas)
        {
            Paint p = new Paint();
            p.setColor( 0xffff0000 );
            p.setStyle( Style.FILL );
            canvas.drawRect( new Rect( 0, 0, 20 + a, 100 ), p );
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,int height)
        {
        }

        @Override
        public void surfaceCreated( SurfaceHolder holder )
        {
            Log.i( "info", "SURFACE CREATED !" );

            DisplayMetrics metrics = new DisplayMetrics();
            FresslemaniaActivity.singleton.getWindowManager().getDefaultDisplay().getMetrics( metrics );

            CANVAS_WIDTH        = metrics.widthPixels;
            CANVAS_HEIGHT       = metrics.heightPixels;
            CANVAS_DPI          = metrics.densityDpi;       // (int)( metrics.density * 160 );

            Log.i( "info", "CANVAS WIDTH:  [" + CANVAS_WIDTH  + "]" );
            Log.i( "info", "CANVAS HEIGHT: [" + CANVAS_HEIGHT + "]" );
            Log.i( "info", "CANVAS DPI:    [" + CANVAS_DPI    + "]" );

            //start main thread
            FresslemaniaActivity.mainThread = new FresslemaniaMainThread();
            FresslemaniaActivity.mainThread.start();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder)
        {
        }

        public static final void draw()
        {
            Canvas canvas = null;

            try
            {
                canvas = FresslemaniaActivity.surfaceHolder.lockCanvas();
                synchronized ( FresslemaniaActivity.surfaceHolder )
                {
                    if ( canvas != null )
                    {
                        FresslemaniaActivity.canvas.onDraw( canvas );
                    }
                }
            }
            finally
            {
                if ( canvas != null)
                {
                    FresslemaniaActivity.surfaceHolder.unlockCanvasAndPost( canvas );
                }
            }
        }

    }
