/*  $Id: Shooter.java 1176 2012-03-28 22:54:10Z jenetic.bytemare@gmail.com $
 *  =======================================================================================
 */
    package de.christopherstock.android.fresslemania;

    import  de.christopherstock.android.lib.*;
    import  android.app.Activity;
    import  android.os.Bundle;
    import  android.util.*;
    import  android.view.*;

    /******************************************************************************************
    *   The project's activity class.
    *
    *   @version    0.1
    *   @author     Christopher Stock
    *******************************************************************************************/
    public class FresslemaniaActivity extends Activity
    {
        public      static      FresslemaniaActivity        singleton           = null;
        public      static      FresslemaniaCanvas          canvas              = null;
        public      static      boolean                     firstStart          = false;
        public      static      SurfaceHolder               surfaceHolder       = null;
        public      static      FresslemaniaMainThread      mainThread          = null;
        public      static      boolean                     destroyed           = false;

        /******************************************************************************************
        *   Being invoked when the activity is first created.
        *******************************************************************************************/
        @Override
        public void onCreate( Bundle savedInstanceState )
        {
            //invoke super method
            super.onCreate( savedInstanceState );

            //reference singleton instance
            singleton = this;

            //fullscreen please
            LibUI.requestFullscreen( this, false );

            //hide system overlay shadow
            setTheme( R.style.fresslemania );

            //create and set surface view
            canvas = new FresslemaniaCanvas( this );
            //surfaceView.setAnimation( LibUI.getAlphaAnimation() );

            //canvasGL.setRenderer(new FresslemaniaGLRenderer() );

            setContentView( canvas );

            //set content view
            //setContentView( R.layout.main );
        }

        @Override
        protected void onPause()
        {
            super.onPause();
            //canvas.onPause();
        }

        @Override
        protected void onResume()
        {
            super.onResume();
            //canvas.onResume();
        }

        @Override
        public void onWindowFocusChanged( boolean hasFocus )
        {
            Log.i( "info", "onWindowFocusChanged [" + hasFocus + "]" );

            if ( !firstStart )
            {
                firstStart = true;

                surfaceHolder = canvas.getHolder();
                surfaceHolder.addCallback( canvas );
            }

        }
    }
